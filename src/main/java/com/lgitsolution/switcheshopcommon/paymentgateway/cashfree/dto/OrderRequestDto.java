
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import static com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.CashfreeConstants.CASHFREE_CURRENCY_TYPE_INDIAN_RUPEE;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequestDto {

  private String order_id;

  private Double order_amount;

  private String order_currency = CASHFREE_CURRENCY_TYPE_INDIAN_RUPEE;

  private CustomerDetailsDto customer_details;

  private OrderMetaDataDto order_meta;

}
