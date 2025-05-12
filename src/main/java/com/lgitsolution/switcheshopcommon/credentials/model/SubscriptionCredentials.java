
package com.lgitsolution.switcheshopcommon.credentials.model;

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

/** The credentials model class mapped with database. */
@Data
@Entity
@Table(name = "credentials", schema = "public")
public class SubscriptionCredentials {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The service name. */
  @Column(name = "service_name", unique = true)
  private String serviceName;

  /** The email id. */
  @Column(name = "email_id")
  @ColumnTransformer(read = "convert_from(decrypt(email_id, '"
          + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes'), 'UTF_8')",
          write = "encrypt(?::bytea, '" + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes')")
  private String emailId;

  /** The password. */
  @Column(name = "password")
  @ColumnTransformer(read = "convert_from(decrypt(password, '"
          + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes'), 'UTF_8')",
          write = "encrypt(?::bytea, '" + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes')")
  private String password;

  /** The client id. */
  @Column(name = "client_id")
  private String clientId;

  /** The client secret. */
  @Column(name = "client_secret")
  @ColumnTransformer(read = "convert_from(decrypt(client_secret, '"
          + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes'), 'UTF_8')",
          write = "encrypt(?::bytea, '" + CMN_COLUMN_ENCRYPTION_DECRYPTION_KEY + "', 'aes')")
  private String clientSecret;

  @Column(name = "config")
  private String config;

  /** The modified at date. */
  @Column(name = "modified_at")
  private LocalDate modifiedAt;

}
