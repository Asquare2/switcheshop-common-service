package com.lgitsolution.switcheshopcommon.attribute.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "attribute_options")
public class AttributeOption {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  /** The name , that comes from attribute option table. */
  @Column(name = "name")
  private String attributeName;

  @Column(name = "value")
  private String value;

  @Column(name = "status")
  private int status;

  @Column(name = "value_tag")
  private String valueTag;

  @Column(name = "attribute_id")
  private int attributeId;
  
  @Column(name = "color_code")
  private String colorCode;
  
  
  @Column(name = "multi_media")
  private String multiMedia;
  
}
