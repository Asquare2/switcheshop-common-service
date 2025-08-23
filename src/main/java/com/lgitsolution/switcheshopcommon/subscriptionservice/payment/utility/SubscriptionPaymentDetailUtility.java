
package com.lgitsolution.switcheshopcommon.subscriptionservice.payment.utility;

import java.util.List;

import com.lgitsolution.switcheshopcommon.common.util.Utility;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderPaymentsResponseDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderResponseDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.dto.PaymentDetailConstants;
import com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto.RazorpayOrderResponseDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto.RazorpayPaymentResponseDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.payment.dto.SubscriptionPaymentDetailDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.payment.model.SubscriptionPaymentDetail;

public class SubscriptionPaymentDetailUtility {

  public static SubscriptionPaymentDetailDto convertModelToDto(SubscriptionPaymentDetail model) {
    SubscriptionPaymentDetailDto dto = new SubscriptionPaymentDetailDto();
    dto.setId(model.getId());
    dto.setSubscriptionId(model.getSubscriptionId());
    dto.setSubscriptionItemId(model.getSubscriptionItemId());
    dto.setClientId(model.getClientId());
    dto.setAmount(model.getAmount());
    dto.setProvider(model.getProvider());
    dto.setCurrency(model.getCurrency());
    dto.setPaymentMethod(model.getPaymentMethod());
    dto.setPaymentSessionId(model.getPaymentSessionId());
    dto.setSpOrderId(model.getSpOrderId());
    dto.setSpStatus(model.getSpStatus());
    dto.setStatus(model.getStatus());
    if (PaymentDetailConstants.PAYMENT_PROVIDER_CASHFREE.equals(dto.getProvider())) {
      dto.setCreatedOrderResponse(Utility.convertJsonToObject(model.getCreatedOrderResponse(),
              new OrderResponseDto()));
      dto.setOrderPaymentsResponseArr(Utility.convertJsonToObject(model.getOrderPaymentsResponse(),
              new OrderPaymentsResponseDto[0]));
    } else if (PaymentDetailConstants.PAYMENT_PROVIDER_RAZORPAY.equals(dto.getProvider())) {
      dto.setCreatedOrderResponse(Utility.convertJsonToObject(model.getCreatedOrderResponse(),
              new RazorpayOrderResponseDto()));
      dto.setOrderPaymentsResponseArr(Utility.convertJsonToObject(model.getOrderPaymentsResponse(),
              new RazorpayPaymentResponseDto[0]));
    }
    dto.setCreatedAt(Utility.getLocalDateMillis(model.getCreatedAt()));
    dto.setModifiedAt(Utility.getLocalDateMillis(model.getModifiedAt()));
    return dto;
  }

  public static SubscriptionPaymentDetail convertDtoToModel(SubscriptionPaymentDetailDto dto) {
    SubscriptionPaymentDetail model = new SubscriptionPaymentDetail();
    model.setId(dto.getId());
    model.setSubscriptionId(dto.getSubscriptionId());
    model.setSubscriptionItemId(dto.getSubscriptionItemId());
    model.setClientId(dto.getClientId());
    model.setAmount(dto.getAmount());
    model.setProvider(dto.getProvider());
    model.setCurrency(dto.getCurrency());
    model.setPaymentMethod(dto.getPaymentMethod());
    model.setPaymentSessionId(dto.getPaymentSessionId());
    model.setSpOrderId(dto.getSpOrderId());
    model.setSpStatus(dto.getSpStatus());
    model.setStatus(dto.getStatus());
    model.setCreatedOrderResponse(Utility.ConvertObjectToJsonString(dto.getCreatedOrderResponse()));
    model.setOrderPaymentsResponse(Utility.ConvertObjectToJsonString(dto
            .getOrderPaymentsResponseArr()));
    model.setCreatedAt(Utility.getLocalDate(dto.getCreatedAt()));
    model.setModifiedAt(Utility.getLocalDate(dto.getModifiedAt()));
    return model;
  }

  public static List<SubscriptionPaymentDetailDto> convertModelToDto(
          List<SubscriptionPaymentDetail> paymentDetail) {
    return paymentDetail.stream().map(paymentDetailL -> convertModelToDto(paymentDetailL)).toList();
  }

}
