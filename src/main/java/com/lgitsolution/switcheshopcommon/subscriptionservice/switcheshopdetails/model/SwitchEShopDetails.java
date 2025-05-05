package com.lgitsolution.switcheshopcommon.subscriptionservice.switcheshopdetails.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "switcheshop_details", schema = "public")
public class SwitchEShopDetails {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The Key */
  @Column(name = "key")
  private String key;

  /** The value */
  @Column(name = "value", columnDefinition = "text")
  private String value;

  /** The value */
  @Column(name = "content", columnDefinition = "text")
  private String content;
}
