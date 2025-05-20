
package com.lgitsolution.switcheshopcommon.email.preferences.model;

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

/** The email preferences model class mapped with database. */
@Data
@Entity
@Table(name = "subscription_email_preferences", schema = "public")
public class SubscriptionEmailPreferences {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "email_type")
  private String emailType;

  @Column(name = "email_id")
  @ColumnTransformer(read = "convert_from(decrypt(email_id, '"
          + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes'), 'UTF_8')",
          write = "encrypt(?::bytea, '" + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes')")
  private String emailId;

  @Column(name = "password")
  @ColumnTransformer(read = "convert_from(decrypt(password, '"
          + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes'), 'UTF_8')",
          write = "encrypt(?::bytea, '" + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes')")
  private String password;

  @Column(name = "config")
  private String config;

  /** The modified at date. */
  @Column(name = "modified_at")
  private LocalDate modifiedAt;

}
