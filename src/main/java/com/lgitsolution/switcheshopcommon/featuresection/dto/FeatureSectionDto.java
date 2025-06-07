
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

  private String subTitle;

  private Integer rowOrderId;

  private Integer type;

  private Integer status;

  private String bgColor;

  private String textColor;

  // Single big image
  private FeatureSectionType1Dto featureSectionType1;

  // Category
  private FeatureSectionType2Dto featureSectionType2;

  // Button
  private List<FeatureSectionType3Dto> featureSectionType3;

  // product size images
  private List<FeatureSectionType1Dto> featureSectionType4;

  // Slider Type
  private List<FeatureSectionType1Dto> featureSectionType5;

  private List<FeatureSectionType1Dto> featureSectionType6;

}
