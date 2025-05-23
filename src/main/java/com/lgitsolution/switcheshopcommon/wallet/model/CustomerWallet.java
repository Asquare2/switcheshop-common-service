
package com.lgitsolution.switcheshopcommon.wallet.model;

import static com.lgitsolution.switcheshopcommon.common.dto.CommonConstants.CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY;

import java.time.LocalDate;

import org.hibernate.annotations.ColumnTransformer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The model class Tax.
 */
@Data
@Entity
@Table(name = "customer_wallet")
public class CustomerWallet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "customer_details_id")
  private int customerDetailsId;

  @Column(name = "wallet_id")
  private String walletId;

  @Column(name = "balance")
  @ColumnTransformer(read = "convert_from(decrypt(balance, '" + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY
          + "', 'aes'), 'UTF_8')", write = "encrypt(?::bytea, '"
                  + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes')")
  private String balance;

  @Column(name = "modified_at")
  private LocalDate modifiedAt;
}
