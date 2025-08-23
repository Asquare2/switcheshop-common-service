
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayPaymentResponseDto {

  private String entity;

  private Integer count;

  /** */
  private RazorpayPaymentResponseItemsDto[] items;
}