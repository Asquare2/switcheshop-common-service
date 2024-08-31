
package com.lgitsolution.switcheshopcommon.paymentgateway.utility;

import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderPaymentsResponseDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderResponseDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.PaymentDetailDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.model.PaymentDetail;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static PaymentDetailDto convertModelToDto(PaymentDetail paymentDetail) {
    PaymentDetailDto paymentDetailDto = new PaymentDetailDto();
    paymentDetailDto.setId(paymentDetail.getId());
    paymentDetailDto.setOrderDetailId(paymentDetail.getOrderDetailId());
    paymentDetailDto.setAmount(paymentDetail.getAmount());
    paymentDetailDto.setProvider(paymentDetail.getProvider());
    paymentDetailDto.setSpStatus(paymentDetail.getSpStatus());
    paymentDetailDto.setCreatedAt(Utility.getLocalDateTimeMillis(paymentDetail.getCreatedAt()));
    paymentDetailDto.setModifiedAt(Utility.getLocalDateTimeMillis(paymentDetail.getModifiedAt()));
    paymentDetailDto.setSpOrderId(paymentDetail.getSpOrderId());
    paymentDetailDto.setPaymentSessionId(paymentDetail.getPaymentSessionId());
    paymentDetailDto.setCreatedOrderResponse(Utility.convertJsonToObject(paymentDetail
            .getCreatedOrderResponse(), new OrderResponseDto()));
    paymentDetailDto.setOrderPaymentsResponseArr(Utility.convertJsonToObject(paymentDetail
            .getOrderPaymentsResponse(), new OrderPaymentsResponseDto[0]));
    paymentDetailDto.setStatus(paymentDetail.getStatus());
    paymentDetailDto.setOrderItemId(paymentDetail.getOrderItemId());
    return paymentDetailDto;
  }

  public static PaymentDetail convertDtoToModel(PaymentDetailDto dto) {
    PaymentDetail paymentDetail = new PaymentDetail();
    paymentDetail.setId(dto.getId());
    paymentDetail.setOrderDetailId(dto.getOrderDetailId());
    paymentDetail.setAmount(dto.getAmount());
    paymentDetail.setProvider(dto.getProvider());
    paymentDetail.setSpStatus(dto.getSpStatus());
    paymentDetail.setCreatedAt(Utility.getLocalDateTime(dto.getCreatedAt()));
    paymentDetail.setModifiedAt(Utility.getLocalDateTime(dto.getModifiedAt()));
    paymentDetail.setSpOrderId(dto.getSpOrderId());
    paymentDetail.setPaymentSessionId(dto.getPaymentSessionId());
    paymentDetail.setCreatedOrderResponse(Utility.ConvertObjectToJsonString(dto
            .getCreatedOrderResponse()));
    paymentDetail.setOrderPaymentsResponse(Utility.ConvertObjectToJsonString(dto
            .getOrderPaymentsResponseArr()));
    paymentDetail.setStatus(dto.getStatus());
    paymentDetail.setOrderItemId(dto.getOrderItemId());
    return paymentDetail;
  }

}
