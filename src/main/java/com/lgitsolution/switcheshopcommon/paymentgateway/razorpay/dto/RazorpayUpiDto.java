
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayUpiDto {

  /**
   * The payment method used for making the payment. Possible values:
   * <p>
   * bank_account
   * </p>
   * <p>
   * credit_card
   * </p>
   * <p>
   * wallet
   * </p>
   */
  private String payer_account_type;

  /**
   * The customer's VPA (Virtual Payment Address) or UPI id used to make the payment. For example,
   * gauravkumar@exampleupi.
   */
  private String vpa;

}
