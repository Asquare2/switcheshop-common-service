
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.netbanking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodNetbankingDto {

  private String channel;

  private Integer netbanking_bank_code;

  private String netbanking_bank_name;

  private String netbanking_ifsc;

  private String netbanking_account_number;

}
