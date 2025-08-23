
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayRefundResponseDto {

  /** The unique identifier of the refund. For example, rfnd_FgRAHdNOM4ZVbO. */
  private String id;

  /** Indicates the type of entity. Here, it is refund. */
  private String entity;

  /**
   * The amount to be refunded (in the smallest unit of currency). For example, if the refund value
   * is ₹30.00 it will be 3000.
   */
  private Integer amount;

  /**
   * The currency of payment amount for which the refund is initiated. Check the list of supported
   * currencies. https://razorpay.com/docs/payments/international-payments/#supported-currencies
   */
  private String currency;

  /**
   * The unique identifier of the payment for which a refund is initiated. For example,
   * pay_FgR9UMzgmKDJRi
   */
  private String payment_id;

  /** Unix timestamp at which the refund was created. For example, 1600856650. */
  private Integer created_at;

  /**
   * This parameter is populated if the refund was created as part of a batch upload. For example,
   * batch_00000000000001.
   */
  private String batch_id;

  /**
   * Key-value store for storing your reference data. A maximum of 15 key-value pairs can be
   * included. For example, "note_key": "Beam me up Scotty".
   */
  private Map<String, String> notes;

  /** A unique identifier provided by you for your internal reference. */
  private String receipt;

  /** A dynamic array consisting of a unique reference numbers. */
  private RazorpayAcquirerDataDto[] acquirer_data;

  /**
   * Indicates the state of the refund. Possible values: pending: This state indicates that Razorpay
   * is attempting to process the refund. processed: This is the final state of the refund. failed:
   * A refund can attain the failed state in the following scenarios: Normal refund is not possible
   * for a payment which is more than 6 months old. Instant Refund can sometimes fail because of
   * customer's account or bank-related issues.
   */
  private String status;

  /**
   * The processing mode of the refund seen in the refund response. This attribute is seen in the
   * refund response only if the speed parameter is set in the refund request. Possible values:
   * normal: Indicates that the refund will be processed via the normal speed. The refund will take
   * 5-7 working days. optimum: Indicates that the refund will be processed at an optimal speed
   * based on Razorpay's internal fund transfer logic. If the refund can be processed instantly,
   * Razorpay will do so, irrespective of the payment method used to make the payment. If an instant
   * refund is not possible, Razorpay will initiate a refund that is processed at the normal speed.
   */
  private String speed_requested;

  /**
   * This is a parameter in the response which describes the mode used to process a refund. This
   * attribute is seen in the refund response only if the speed parameter is set in the refund
   * request. Possible values: instant: Indicates that the refund has been processed instantly via
   * fund transfer. normal: Indicates that the refund has been processed by the payment processing
   * partner. The refund will take 5-7 working days.
   */
  private String speed_processed;

  private RazorpayErrorDto error;

  public Double getAmount() {
    return Double.valueOf(this.amount / 100);
  }

}