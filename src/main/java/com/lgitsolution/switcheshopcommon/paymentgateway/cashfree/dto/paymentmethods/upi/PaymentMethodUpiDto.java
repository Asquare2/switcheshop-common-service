
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.upi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodUpiDto {

  private String channel;

  private String upi_id;

}