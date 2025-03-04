
package com.lgitsolution.switcheshopcommon.dm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The Class Category.
 */
@Data
@Entity
@Table(name = "thired_party_dm_data")
public class ThirdPartyDm {

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

  @Column(name = "default_script", columnDefinition = "text")
  private String defaultScript;

}
