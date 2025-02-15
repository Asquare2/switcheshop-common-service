
package com.lgitsolution.switcheshopcommon.slider.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.filter.dto.SearchOptionsDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SliderDto {

  private Integer id;

  private String type;

  private String link;

  private Integer status;

  private SearchOptionsDto searchOptionsDto;

  /** This is multi media comes from User interface. */
  private String multiMedia;

  private String imageAltTag;

  private String slug;

  private String dmContent;

  private Integer rowOrderId;

  private String title;

}
