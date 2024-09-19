
package com.lgitsolution.switcheshopcommon.companydetails.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "company_details")
public class CompanyDetails {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The Key */
  @Column(name = "key")
  private String key;

  /** The question */
  @Column(name = "value", columnDefinition = "text")
  private String value;

}
