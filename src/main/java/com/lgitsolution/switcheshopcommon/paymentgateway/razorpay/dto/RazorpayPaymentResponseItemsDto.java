
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayPaymentResponseItemsDto {

  /** Unique identifier of the payment. */
  private String id;

  /** Indicates the type of entity. */
  private String entity;

  /** The payment amount in currency subunits. For example, for an amount of ₹1.00 enter 100. */
  private Integer amount;

  /** The currency in which the payment is made. */
  private String currency;

  /**
   * The status of the payment. Possible values: created, authorized, captured, refunded, failed
   */
  private String status;

  /**
   * The payment method used for making the payment. Possible values: card, netbanking, wallet, upi,
   * emi
   */
  private String method;

  /**
   * Order id, if provided. Know more about Orders.
   * <p>
   * https://razorpay.com/docs/payments/orders/
   * </p>
   */
  private String order_id;

  /** Description of the payment, if any. */
  private String description;

  /**
   * Indicates whether the payment is done via an international card or a domestic one. Possible
   * values:
   * <p>
   * true: Payment made using international card.
   * </p>
   * <p>
   * false: Payment not made using international card.
   * </p>
   */
  private boolean international;

  /**
   * The refund status of the payment. Possible values:
   * <p>
   * null
   * </p>
   * <p>
   * partial
   * </p>
   * <p>
   * full
   * </p>
   */
  private String refund_status;

  /**
   * The amount refunded in currency subunits. For example, if amount_refunded = 100, it is equal to
   * ₹1.00.
   */
  private Integer amount_refunded;

  /**
   * Indicates if the payment is captured. Possible values:
   * <p>
   * true: Payment has been captured.
   * </p>
   * <p>
   * false: Payment has not been captured.
   * </p>
   */
  private boolean captured;

  /** Customer email address used for the payment. */
  private String email;

  /** Customer contact number used for the payment. */
  private String contact;

  /** Fee (including tax) charged by us. */
  private Integer fee;

  /** Tax charged for the payment. */
  private Integer tax;

  /** Error that occurred during payment. For example, BAD_REQUEST_ERROR. */
  private String error_code;

  /**
   * Description of the error that occurred during payment. For example, Payment processing failed
   * because of incorrect OTP.
   */
  private String error_description;

  /** The point of failure. For example, customer. */
  private String error_source;

  /**
   * The stage where the transaction failure occurred. The stages can vary depending on the payment
   * method used to complete the transaction. For example, payment_authentication.
   */
  private String error_step;

  /** The exact error reason. For example, incorrect_otp. */
  private String error_reason;

  /** Contains user-defined fields, stored for reference purposes. */
  private Map<String, String> notes;

  /** Timestamp, in UNIX format, on which the payment was created. */
  private Long created_at;

  /** The unique identifier of the card used by the customer to make the payment. */
  private String card_id;

  /** The name of the wallet used by the customer to make the payment. For example, payzapp. */
  private String wallet;

  /** A dynamic array consisting of a unique reference numbers. */
  private RazorpayAcquirerDataDto acquirer_data;

  /**
   * The 4-character bank code which the customer's account is associated with. For example, UTIB
   * for Axis Bank.
   */
  private String bank;

  /** Details of the UPI payment received. Applicable if method is upi. */
  private RazorpayUpiDto upi;

  /**
   * The customer's VPA (Virtual Payment Address) or UPI id used to make the payment. For example,
   * gauravkumar@exampleupi.
   */
  private String vpa;

}