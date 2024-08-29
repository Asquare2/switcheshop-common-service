
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentsAuthorizationDto {

  private String action;

  private String status;

  private Double captured_amount;

  private String start_time;

  private String end_time;

  private String approve_by;

  private String action_reference;

  private String action_time;

}
