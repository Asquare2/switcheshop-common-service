
package com.lgitsolution.switcheshopcommon.flashsale.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;
import com.lgitsolution.switcheshopcommon.filter.dto.SearchOptionsDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlashSaleDto {

  private Integer id;

  private String title;

  private String description;

  private Double discount;

  private Long startDate;

  private Long endDate;

  /** This is multi media comes from User interface. */
  private Multimedia multiMedia;

  private Integer status;

  private Long createdAt;

  private Long modifiedAt;

  private SearchOptionsDto searchOptionsDto;

  private Integer maxDiscountAmount;

  /** For DM purpose */
  private String slug;

  private String dmContent;

}
