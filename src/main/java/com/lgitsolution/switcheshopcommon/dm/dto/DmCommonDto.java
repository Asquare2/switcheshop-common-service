package com.lgitsolution.switcheshopcommon.dm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DmCommonDto {

  private int id;
  private String title;
  private String shortDesc;
  private String longDesc;
  private String slug;
  private String dmContent;
  private Multimedia multiMedia;

}