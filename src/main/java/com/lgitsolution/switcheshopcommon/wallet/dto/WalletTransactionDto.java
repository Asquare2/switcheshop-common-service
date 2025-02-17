
package com.lgitsolution.switcheshopcommon.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletTransactionDto {

  private int id;

  private int customerDetailsId;

  private int customerWalletId;

  private String transactionId;

  private float transactionAmount;

  private String transactionType;

  private String transactionFor;

  private String transactionUserType;

  private String transactionBy;

  private Integer orderDetailsId;

  private Integer returnDetailsId;

  private Long createdAt;

}
