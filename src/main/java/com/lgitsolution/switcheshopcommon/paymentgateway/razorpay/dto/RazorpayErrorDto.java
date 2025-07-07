
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayErrorDto {

  /**  */
  private String code;

  private String description;

  private String source;

  private String step;

  private String reason;

  private String field;

}
