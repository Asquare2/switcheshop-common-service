package com.lgitsolution.switcheshopcommon.attributechart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "attribute_chart")
public class AttributeChart {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "chart_data", columnDefinition = "text")
  private String chartData;

  @Column(name = "template_name", columnDefinition = "text")
  private String templateName;

  @Column(name = "multi_media", columnDefinition = "text")
  private String multiMedia;

}
