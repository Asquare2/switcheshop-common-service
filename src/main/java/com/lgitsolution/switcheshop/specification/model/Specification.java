
package com.lgitsolution.switcheshop.specification.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "specification")
public class Specification {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The specification data. */
  @Column(name = "specification_data")
  private String specificationData;

  /** The name. */
  @Column(name = "set_name")
  private String name;

}
