package com.lgitsolution.switcheshopcommon.attribute.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeOptionDto {

  @Id
  private int id;

  private String value;

  private int status;

  private String valueTag;
  
  private int attributeId;
  
  /** The name. */
  private String attributeName;
  
  private String colorCode;
  
  /** This is multi media comes from User interface. */
  private Multimedia multiMedia;  
  
}
