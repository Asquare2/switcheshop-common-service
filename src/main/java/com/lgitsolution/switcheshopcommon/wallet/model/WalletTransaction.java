
package com.lgitsolution.switcheshopcommon.wallet.model;

import java.time.LocalDate;

import com.lgitsolution.switcheshopcommon.wallet.dto.TransactionType;
import com.lgitsolution.switcheshopcommon.wallet.dto.TransactionUserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "wallet_transaction")
public class WalletTransaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "customer_details_id")
  private int customerDetailsId;

  @Column(name = "customer_wallet_id")
  private int customerWalletId;

  @Column(name = "transaction_id")
  private String transactionId;

  @Column(name = "transaction_amount")
  private float transactionAmount;

  @Column(name = "transaction_type")
  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;

  @Column(name = "transaction_for")
  private String transactionFor;

  @Column(name = "transaction_user_type")
  @Enumerated(EnumType.STRING)
  private TransactionUserType transactionUserType;

  @Column(name = "transaction_by")
  private String transactionBy;

  @Column(name = "order_details_id")
  private Integer orderDetailsId;

  @Column(name = "return_details_id")
  private Integer returnDetailsId;

  @Column(name = "created_at")
  private LocalDate createdAt;
}
