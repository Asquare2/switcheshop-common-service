
package com.lgitsolution.switcheshopcommon.attributechart.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeChartDto {

  private Integer id;

  // for clothes Map key as a attribute name and valve map have column name as a key and size as a
  // value
  private Map<String, Map<String, String>> chartData;

  private String templateName;

  private Multimedia multiMedia;

}
