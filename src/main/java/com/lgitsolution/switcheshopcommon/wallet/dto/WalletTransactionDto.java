
package com.lgitsolution.switcheshopcommon.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;

  private String transactionFor;

  @Enumerated(EnumType.STRING)
  private TransactionUserType transactionUserType;

  private String transactionBy;

  private Integer orderDetailsId;

  private Integer returnDetailsId;

  private Long createdAt;

  private float remainingWalletAmount;

}
