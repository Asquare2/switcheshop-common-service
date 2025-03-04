
package com.lgitsolution.switcheshopcommon.sku.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SKUDto {

  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String PRODUCT_ID = "productId";
  public static final String QUANTITY = "quantity";
  public static final String PRICE = "price";
  public static final String SPECIAL_PRICE = "specialPrice";
  public static final String ATTRIBUTE_OPTIONS = "attributeOptions";
  public static final String TITLE = "title";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String LONG_DESCRIPTION = "longDescription";
  public static final String SLUG = "slug";
  public static final String DM_CONTENT = "dmContent";
  public static final String ITEM_ID = "itemId";
  public static final String SALE_PRICE = "salePrice";
  public static final String DISCOUNT_PERCENTAGE = "discountPercentage";
  public static final String AVERAGE_RATING = "averageRating";
  public static final String FLASH_SALE_ID = "flashSaleId";
  public static final String MINIMUM_ORDER_QUANTITY = "minimumOrderQuantity";
  public static final String MAXIMUM_ORDER_QUANTITY = "maximumOrderQuantity";
  public static final String PRODUCT_IDENTIFICATION_NO = "productIdentificationNo";
  public static final String CATEGORY_ID = "categoryId";
  public static final String SEARCH_VALUES = "searchValues";

  private Integer id;

  private String name;

  private Multimedia multiMedia;

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

  private int categoryId;

  private String searchValues;

}
