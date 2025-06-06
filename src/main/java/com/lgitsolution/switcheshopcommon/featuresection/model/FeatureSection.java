
package com.lgitsolution.switcheshopcommon.featuresection.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "feature_section")
public class FeatureSection {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "title")
  private String title;

  @Column(name = "row_order_id")
  private Integer rowOrderId;

  @Column(name = "type")
  private Integer type;

  @Column(name = "status")
  private Integer status;

  @Column(name = "type_filter_data")
  private String typeFilterData;

  @Column(name = "bg_color")
  private String bgColor;

  @Column(name = "text_color")
  private String textColor;

}
