
package com.lgitsolution.switcheshop.featuresection.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshop.filter.dto.SearchOptionsDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureSectionDto {

  private Integer id;

  private String title;

  private String shortDescription;

  private SearchOptionsDto searchOptionsDto;

  private Integer rowOrderId;

  private Integer style;

  private Integer status;

  private String slug;

  private String dmContent;

}
