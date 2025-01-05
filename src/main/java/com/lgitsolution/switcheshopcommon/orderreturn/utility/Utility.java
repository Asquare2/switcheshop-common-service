
package com.lgitsolution.switcheshopcommon.orderreturn.utility;

import java.util.List;

import com.lgitsolution.switcheshopcommon.orderreturn.dto.ReturnDetailDto;
import com.lgitsolution.switcheshopcommon.orderreturn.model.ReturnDetail;

public class Utility {

  public static ReturnDetailDto convertModelToDto(ReturnDetail model) {
    ReturnDetailDto dto = new ReturnDetailDto();
    dto.setId(model.getId());
    dto.setOrderId(model.getOrderId());
    dto.setOrderItemId(model.getOrderItemId());
    dto.setReplaceOrderId(model.getReplaceOrderId());
    dto.setPaymentId(model.getPaymentId());
    dto.setStatus(model.getStatus());
    dto.setReason(model.getReason());
    dto.setRequestedFor(model.getRequestedFor());
    dto.setPaymentStatus(model.getPaymentStatus());
    dto.setItemId(model.getItemId());
    dto.setDeliveryPartnerResponse(model.getDeliveryPartnerResponse());
    dto.setTrackingData(model.getTrackingData());
    dto.setPickupScheduledDate(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getLocalDateMillis(model.getPickupScheduledDate()));
    dto.setShipmentId(model.getShipmentId());
    dto.setAwbCode(model.getAwbCode());
    dto.setCourierCompanyId(model.getCourierCompanyId());
    dto.setCourierName(model.getCourierName());
    dto.setCreatedAt(com.lgitsolution.switcheshopcommon.common.util.Utility.getLocalDateMillis(model
            .getCreatedAt()));
    return dto;
  }

  public static ReturnDetail convertDtoToModel(ReturnDetailDto dto) {
    ReturnDetail model = new ReturnDetail();
    model.setId(dto.getId());
    model.setOrderId(dto.getOrderId());
    model.setOrderItemId(dto.getOrderItemId());
    model.setReplaceOrderId(dto.getReplaceOrderId());
    model.setPaymentId(dto.getPaymentId());
    model.setStatus(dto.getStatus());
    model.setReason(dto.getReason());
    model.setRequestedFor(dto.getRequestedFor());
    model.setPaymentStatus(dto.getPaymentStatus());
    model.setItemId(dto.getItemId());
    model.setDeliveryPartnerResponse(dto.getDeliveryPartnerResponse());
    model.setTrackingData(dto.getTrackingData());
    model.setPickupScheduledDate(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getLocalDate(dto.getPickupScheduledDate()));
    model.setShipmentId(dto.getShipmentId());
    model.setAwbCode(dto.getAwbCode());
    model.setCourierCompanyId(dto.getCourierCompanyId());
    model.setCourierName(dto.getCourierName());
    model.setCreatedAt(com.lgitsolution.switcheshopcommon.common.util.Utility.getLocalDate(dto
            .getCreatedAt()));
    return model;
  }

  /**
   * 
   * @param modelList
   * @return
   */
  public static List<ReturnDetailDto> convertModelToDto(List<ReturnDetail> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).toList();
  }

}
