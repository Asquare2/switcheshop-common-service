
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponseDto {

  private String cf_order_id;

  private String order_id;

  /** The type of the entity e.g. Order. */
  private String entity;

  private String order_currency;

  private Double order_amount;

  private String order_status;

  private String payment_session_id;

  private String order_expiry_time;

  private String order_note;

  private String created_at;

  private CustomerDetailsDto customer_details;

  private OrderMetaDataDto order_meta;

  /* Attributes for errors. */
  private String message;

  private String code;

  private String type;

}
