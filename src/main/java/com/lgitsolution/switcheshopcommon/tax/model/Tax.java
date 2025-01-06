
package com.lgitsolution.switcheshopcommon.tax.model;

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
@Table(name = "tax")
public class Tax {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "title")
  String title;

  @Column(name = "percentage")
  Float percentage;

  @Column(name = "min_price")
  Float minPrice;

  @Column(name = "max_price")
  Float maxPrice;

}
