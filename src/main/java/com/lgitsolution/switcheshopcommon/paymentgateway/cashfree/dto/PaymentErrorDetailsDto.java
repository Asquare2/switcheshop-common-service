
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentErrorDetailsDto {

  private String error_code;

  private String error_description;

  private String error_reason;

  private String error_source;

  private String error_code_raw;

  private String error_description_raw;

  private String error_subcode_raw;

}
