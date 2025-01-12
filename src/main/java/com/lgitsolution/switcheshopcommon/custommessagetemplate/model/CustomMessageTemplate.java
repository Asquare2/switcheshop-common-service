
package com.lgitsolution.switcheshopcommon.custommessagetemplate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The custom message template model class to connect with database.
 */
@Data
@Entity
@Table(name = "custom_message_template")
public class CustomMessageTemplate {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The types of the messages. */
  @Column(name = "types")
  private String types;

  /** The default title of the message. */
  @Column(name = "default_title")
  private String defaultTitle;

  /** The default message. */
  @Column(name = "default_message")
  private String defaultMessage;

  /** The custom title of the message. */
  @Column(name = "custom_title")
  private String customTitle;

  /** The custom title of the message. */
  @Column(name = "custom_message")
  private String customMessage;

  /** The email type for which the template will be send as email. */
  @Column(name = "email_type")
  private String emailType;

}
