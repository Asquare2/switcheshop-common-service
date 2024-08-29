
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import static com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.CashfreeConstants.CASHFREE_PAYMENT_METHODS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderMetaDataDto {

  private String return_url;

  private String notify_url;

  private String payment_methods = CASHFREE_PAYMENT_METHODS;

}
