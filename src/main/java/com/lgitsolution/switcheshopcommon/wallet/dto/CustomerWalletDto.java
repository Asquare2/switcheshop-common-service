
package com.lgitsolution.switcheshopcommon.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerWalletDto {

  private int id;

  private int customerDetailsId;

  private String walletId;

  private Float balance = 0.0f;

  private Long modifiedAt;
}
