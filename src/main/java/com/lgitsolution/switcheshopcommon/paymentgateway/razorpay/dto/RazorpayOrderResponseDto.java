
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.JsonObject;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayOrderResponseDto {

  /** The unique identifier of the order. */
  private String id;

  /**
   * The amount for which the order was created, in currency subunits. For example, for an amount of
   * ₹295.00, enter 29500.
   */
  private Integer amount;

  /** Name of the entity. Here, it is order. */
  private String entity;

  /** The amount paid against the order. */
  private Integer amount_paid;

  /** The amount pending against the order. */
  private Integer amount_due;

  /**
   * ISO code for the currency in which you want to accept the payment. The default length is 3
   * characters.
   */
  private String currency;

  /**
   * Receipt number that corresponds to this order. Can have a maximum length of 40 characters and
   * has to be unique.
   */
  private String receipt;

  /**
   * The status of the order. Possible values:
   * <p>
   * created: When you create an order it is in the created state. It stays in this state till a
   * payment is attempted on it.
   * </p>
   * <p>
   * attempted: An order moves from created to attempted state when a payment is first attempted on
   * it. It remains in the attempted state till one payment associated with that order is captured.
   * </p>
   * <p>
   * paid: After the successful capture of the payment, the order moves to the paid state. No
   * further payment requests are permitted once the order moves to the paid state. The order stays
   * in the paid state even if the payment associated with the order is refunded.
   * </p>
   */
  private RazorpayOrderStatusEnum status;

  /**
   * The number of payment attempts, successful and failed, that have been made against this order.
   */
  private Integer attempts;

  /**
   * Key-value pair that can be used to store additional information about the entity. Maximum 15
   * key-value pairs, 256 characters (maximum) each. For example, "note_key": "Beam me up Scotty”.
   */
  private JsonObject notes;

  /** Indicates the Unix timestamp when this order was created. */
  private Long created_at;

  private RazorpayErrorDto error;

  public Double getAmount() {
    return Double.valueOf(this.amount / 100);
  }

}
