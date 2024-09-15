package com.lgitsolution.switcheshopcommon.attribute.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeDto {

  /** The id. */
  private int id;
   
  /** The name. */
  private String name;
  
  /** The status. */
  private int status;
  
  /** The display name , that will be show on customer end. */
  private String displayName;
  
  private List<AttributeOptionDto> attributeOptionList = new ArrayList<AttributeOptionDto>();

}
