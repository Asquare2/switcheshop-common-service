
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.cardlessemi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodCardlessEmiDto {

  private String channel;

  private String provider;

  private String phone;

}
