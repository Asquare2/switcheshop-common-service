
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundResponseDto {

  /** Cashfree Payments ID of the payment for which refund is initiated */
  private String cf_payment_id;

  /** Cashfree Payments ID for a refund */
  private String cf_refund_id;

  /** Cashfree refund charges currency for a refund */
  private String charges_currency;

  /** Time of refund creation */
  private String created_at;

  /** Cashfree forex conversion charges for refund processing */
  private Double forex_conversion_handling_charge;

  /** Cashfree forex conversion tax for refund processing */
  private Double forex_conversion_handling_tax;

  /** Cashfree forex conversion rate for refund processing */
  private Double forex_conversion_rate;

  /**
   * Key-value pair that can be used to store additional information about the entity. Maximum 5
   * key-value pairs
   */
  private RefundMetaDataDto metadata;

  /** Merchant’s order Id of the order for which refund is initiated */
  private String order_id;

  /** Time when refund was processed successfully */
  private String processed_at;

  /** Amount that is refunded */
  private Double refund_amount;

  /** The bank reference number for refund */
  private String refund_arn;

  /** Charges in INR for processing refund */
  private Double refund_charge;

  /** Currency of the refund amount */
  private String refund_currency;

  /** Merchant’s refund ID of the refund */
  private String refund_id;

  /** Method or speed of processing refund */
  private RefundModeEnum refund_mode;

  /** Note added by merchant for the refund */
  private String refund_note;

  /** How fast refund has to be processed */
  private RefundSpeedDto refund_speed;

  private RefundSplitsDto[] refund_splits;

  /** This can be one of ["SUCCESS", "PENDING", "CANCELLED", "ONHOLD", "FAILED"] */
  private RefundStatusEnum refund_status;

  /**
   * This can be one of ["PAYMENT_AUTO_REFUND", "MERCHANT_INITIATED", "UNRECONCILED_AUTO_REFUND"]
   */
  private String refund_type;

  /** Description of refund status */
  private String status_description;

}
