
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDetailDto {

  private Integer id;

  private Integer orderDetailId;

  private Double amount;

  private String provider;

  private String spStatus;

  private Long createdAt;

  private Long modifiedAt;

  private String spOrderId;

  private String paymentSessionId;

  private OrderResponseDto createdOrderResponse;

  private OrderPaymentsResponseDto[] orderPaymentsResponseArr;

  private Integer status;

}
