
package com.lgitsolution.switcheshopcommon.subscriptionservice.payment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderPaymentsResponseDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderResponseDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionPaymentDetailDto {

  private Integer id;
  private Integer subscriptionId;
  private String subscriptionItemId;
  private Integer clientId;
  private Double amount = 0.0;
  private String provider;
  private String currency;
  private String paymentMethod;
  private String paymentSessionId;
  private String spOrderId;
  private String spStatus;
  private Integer status;
  private OrderResponseDto createdOrderResponse;
  private OrderPaymentsResponseDto[] orderPaymentsResponseArr;
  private Long createdAt;
  private Long modifiedAt;

}
