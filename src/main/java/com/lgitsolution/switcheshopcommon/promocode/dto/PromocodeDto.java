
package com.lgitsolution.switcheshopcommon.promocode.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromocodeDto {

  private Integer id;

  private String name;

  private String message;

  private Integer isReusable;

  private Integer useCount;

  /** This is multi media comes from User interface. */
  private Multimedia multiMedia;;

  private Integer minimumPurchaseAmount;

  private Integer discountType;

  private Double discountAmount;

  private Integer status;

  private Long createdAt;

  private Long modifiedAt;

}
