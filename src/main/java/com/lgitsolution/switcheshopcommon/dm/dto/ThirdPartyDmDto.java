
package com.lgitsolution.switcheshopcommon.dm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThirdPartyDmDto {

  private Integer id;
  private String key;
  private String value;
  private String defaultScript;
  private String finalScript;
}
