
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import static com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.CashfreeConstants.CASHFREE_CURRENCY_TYPE_INDIAN_RUPEE;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOrderRequestDto {

  @JsonProperty(value = "order_id")
  private String orderItemId;

  private Double order_amount;

  private String order_currency = CASHFREE_CURRENCY_TYPE_INDIAN_RUPEE;

  private CustomerDetailsDto customer_details;

  private OrderMetaDataDto order_meta;

  private String order_expiry_time;

  public PaymentOrderRequestDto() {
    customer_details = new CustomerDetailsDto();
  }

}
