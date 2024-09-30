
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.wallet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletBalanceData {

  private String balance_amount;

}
