
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayAcquirerDataDto {

  /**
   * A unique bank reference number provided by the banking partner when a refund is processed. This
   * reference number can be used by the customer to track the status of the refund with the bank.
   */
  private String rrn;

  /** A unique reference number generated for RuPay card payments. */
  private String authentication_reference_number;

  /** A unique reference number provided by the banking partner in case of netbanking payments. */
  private String bank_transaction_id;

}
