
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.paylater;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodPaylaterDto {

  private String channel;

  private String provider;

  private String phone;

}
