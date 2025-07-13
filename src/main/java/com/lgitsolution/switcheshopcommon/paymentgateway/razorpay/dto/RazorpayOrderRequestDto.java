
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayOrderRequestDto {

  /**
   * Payment amount in the smallest currency sub-unit. For example, if the amount to be charged is
   * ₹299.00, then pass 29900 in this field. In the case of three decimal currencies, such as KWD,
   * BHD and OMR, to accept a payment of 295.991, pass the value as 295990. And in the case of zero
   * decimal currencies such as JPY, to accept a payment of 295, pass the value as 295.
   */
  private Integer amount;

  /**
   * ISO code for the currency in which you want to accept the payment. The default length is 3
   * characters.
   * 
   * <p>
   * Refer to this link:
   * </p>
   * https://razorpay.com/docs/payments/international-payments/#supported-currencies
   */
  private String currency;

  /**
   * Receipt number that corresponds to this order, set for your internal reference. Can have a
   * maximum length of 40 characters and has to be unique.
   */
  private String receipt;

  /**
   * Key-value pair that can be used to store additional information about the entity. Maximum 15
   * key-value pairs, 256 characters (maximum) each. For example, "note_key": "Beam me up Scotty”.
   */
  private Map<String, String> notes;

  /**
   * Indicates whether the customer can make a partial payment. Possible values: true : The customer
   * can make partial payments. false (default) : The customer cannot make partial payments.
   */
  private Boolean partial_payment = false;

  /**
   * Minimum amount that must be paid by the customer as the first partial payment. For example, if
   * an amount of ₹700.00 is to be received from the customer in two installments of #1 - ₹500.00,
   * #2 - ₹200.00, then you can set this value as 50000. This parameter should be passed only if
   * partial_payment is true.
   */
  private Integer first_payment_min_amount;

  public Double getAmount() {
    return Double.valueOf(this.amount / 100);
  }

}
