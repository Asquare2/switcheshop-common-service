
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundSpeedDto {

  /** Accepted speed of refund. */
  private String accepted;

  /** Error message, if any for refund_speed request */
  private String message;

  /** Processed speed of refund. */
  private String processed;

  /** Requested speed of refund. */
  private String requested;

}
