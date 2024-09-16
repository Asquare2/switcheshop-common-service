
package com.lgitsolution.switcheshopcommon.featuresection.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureSectionDto {

  private Integer id;

  private String title;

  private Integer rowOrderId;

  private Integer type;

  private Integer status;

  private String slug;

  private String dmContent;

  private FeatureSectionType1Dto featureSectionType1;

  private FeatureSectionType2Dto featureSectionType2;

  private FeatureSectionType3Dto featureSectionType3;

  private List<FeatureSectionType1Dto> featureSectionType4;

}
