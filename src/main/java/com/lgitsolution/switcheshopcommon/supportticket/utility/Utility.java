
package com.lgitsolution.switcheshopcommon.supportticket.utility;

import java.util.List;

import com.lgitsolution.switcheshopcommon.order.dto.OrderStatusDetail;
import com.lgitsolution.switcheshopcommon.supportticket.dto.SupportTicketConstant;
import com.lgitsolution.switcheshopcommon.supportticket.dto.SupportTicketDto;
import com.lgitsolution.switcheshopcommon.supportticket.model.SupportTicket;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static SupportTicket convertDtoToModel(SupportTicketDto dto) {
    SupportTicket model = new SupportTicket();
    model.setId(dto.getId());
    model.setTicketId(dto.getTicketId());
    model.setCustomerDetailsId(dto.getCustomerDetailsId());
    model.setOrderItemId(dto.getOrderItemId());
    model.setSubject(dto.getSubject());
    model.setDescription(dto.getDescription());
    model.setStatus(dto.getStatus());
    model.setResponse(dto.getResponse());
    model.setImage(dto.getImage());
    model.setCreatedAt(Utility.getLocalDate(dto.getCreatedAt()));
    model.setModifiedAt(Utility.getLocalDate(dto.getModifiedAt()));
    return model;
  }

  public static SupportTicketDto convertModelToDto(SupportTicket model) {
    SupportTicketDto dto = new SupportTicketDto();
    dto.setId(model.getId());
    dto.setTicketId(model.getTicketId());
    dto.setCustomerDetailsId(model.getCustomerDetailsId());
    dto.setOrderItemId(model.getOrderItemId());
    dto.setSubject(model.getSubject());
    dto.setDescription(model.getDescription());
    dto.setStatus(model.getStatus());
    dto.setResponse(model.getResponse());
    dto.setImage(model.getImage());
    dto.setCreatedAt(Utility.getLocalDateMillis(model.getCreatedAt()));
    dto.setModifiedAt(Utility.getLocalDateMillis(model.getModifiedAt()));
    dto.setStatusDetail(getOrderStatusDetailObj(dto.getStatus()));

    return dto;
  }

  public static OrderStatusDetail getOrderStatusDetailObj(int status) {
    OrderStatusDetail statusDetail = new OrderStatusDetail();
    statusDetail.setStatusCode(status);
    if (status == SupportTicketConstant.Open.getValue()) {
      statusDetail.setName(SupportTicketConstant.Open.toString());
    } else if (status == SupportTicketConstant.InProgress.getValue()) {
      statusDetail.setName(SupportTicketConstant.InProgress.toString());
    } else {
      statusDetail.setName(SupportTicketConstant.Closed.toString());
    }
    return statusDetail;
  }

  /**
   * 
   * @param modelList
   * @return
   */
  public static List<SupportTicketDto> convertModelToDto(List<SupportTicket> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).toList();
  }

}
