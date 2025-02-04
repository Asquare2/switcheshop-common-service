
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundRequestDto {

  /**
   * Amount to be refunded. Should be lesser than or equal to the transaction amount. (Decimals
   * allowed)
   */
  private Double refund_amount;

  /**
   * An unique ID to associate the refund with.
   * 
   * Provide alphanumeric values Required string length: 3 - 40
   */
  private String refund_id;

  /**
   * A refund note for your reference.
   * 
   * Required string length: 3 - 100
   */
  private String refund_note;

  /**
   * Speed at which the refund is processed. It's an optional field with default being STANDARD
   * 
   * Available options: STANDARD, INSTANT
   */
  private RefundModeEnum refund_speed;

  private RefundSplitsDto[] refund_splits;

}
