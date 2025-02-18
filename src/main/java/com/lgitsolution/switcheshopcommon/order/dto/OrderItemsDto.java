
package com.lgitsolution.switcheshopcommon.order.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemsDto {

  private Integer id;

  private Integer orderDetailId;

  private Integer skuId;

  private Integer quantity;
  
  private String identificationNumber;

  private String skuName;

  private String title;

  private Float originalPrice;

  private Float sellingPrice;

  private Integer saleId;

  private String hsnCode;

  // Not for saving purpose
  private Integer productId;

  private Multimedia multimedia;
  
  private String skuItemId;

  private String slug;
  
  private List selectedSKUAttributes = null;

}
