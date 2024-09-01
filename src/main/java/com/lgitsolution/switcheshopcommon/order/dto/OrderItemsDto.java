
package com.lgitsolution.switcheshopcommon.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.sku.dto.SKUDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemsDto {

  private Integer id;

  private Integer orderDetailId;

  private Integer skuId;

  private SKUDto skuDto;

  private Integer quantity;

  private Long createdAt;

  private Long modifiedAt;

}
