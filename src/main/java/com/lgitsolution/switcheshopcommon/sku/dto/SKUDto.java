
package com.lgitsolution.switcheshopcommon.sku.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SKUDto {

  private Integer id;

  private String name;

  private Multimedia multiMedia;

  private Integer status;

  private Integer productId;

  private Integer quantity;

  private Float price;

  private Float specialPrice;

  // Comma separated primary keys of attribute option
  private String attributeOptions;

  private String title;

  private String shortDescription;

  private String longDescription;

  /** For DM purpose */
  private String slug;

  private String dmContent;

  private String itemId;

  private Float salePrice = 0.0f;

  private Float discountPercentage;

  private Double averageRating;

  private Integer flashSaleId;

  private Integer minimumOrderQuantity;

  private Integer maximumOrderQuantity;

  private String productIdentificationNo;

  private int taxId;

  private int categoryId;

  private String searchValues;

}
