
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

  public static final String ID = "id";
  public static final String ORDER_DETAIL_ID = "orderDetailId";
  public static final String SKU_ID = "skuId";
  public static final String QUANTITY = "quantity";
  public static final String IDENTIFICATION_NUMBER = "identificationNumber";
  public static final String SKU_NAME = "skuName";
  public static final String TITLE = "title";
  public static final String ORIGINAL_PRICE = "originalPrice";
  public static final String SELLING_PRICE = "sellingPrice";
  public static final String SALE_ID = "saleId";
  public static final String HSN_CODE = "hsnCode";

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
