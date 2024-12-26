
package com.lgitsolution.switcheshopcommon.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemsDto {

  private Integer id;

  private Integer orderDetailId;

  private Integer skuId;

  private Integer quantity;

  private Long createdAt;

  private Long modifiedAt;
  
  private String identificationNumber;

  private String skuName;

  private String title;

  private Float originalPrice;

  private Float sellingPrice;

  private Float tax;

}
