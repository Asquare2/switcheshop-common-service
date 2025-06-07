
package com.lgitsolution.switcheshopcommon.featuresection.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.filter.dto.SearchOptionsDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureSectionType1Dto {

  /** This is multi media comes from User interface. */
  private String multiMedia;

  private String mobileMultiMedia;

  private String imageAltTag;

  private SearchOptionsDto searchOptionsDto;

  private String link;

  private String text;

  private String title;

  private String slug;

  private String dmContent;

  private String itemID;

}
