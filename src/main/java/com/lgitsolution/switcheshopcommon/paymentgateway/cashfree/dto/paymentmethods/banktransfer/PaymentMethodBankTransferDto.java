
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.banktransfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodBankTransferDto {

  private String channel;

  private String banktransfer_bank_name;

  private String banktransfer_ifsc;

  private String banktransfer_account_number;

}
