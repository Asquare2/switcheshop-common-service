
package com.lgitsolution.switcheshop.product.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshop.common.dto.Multimedia;
import com.lgitsolution.switcheshop.sku.dto.SKUDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

  private Integer id;

  private String identificationNo;

  private String title;

  private String shortDescription;

  private String longDescription;

  private String madeIn;

  private String type;

  private String tag;

  private int taxIncluded;

  private int taxId;

  private int customerType;

  private int categoryId;

  private int brandId;

  private Multimedia multiMedia;

  private Integer minimumOrderQuantity;

  private int maximumOrderQuantity;

  private int quantityStepSize;

  private int warrantyPeriod;

  private int guaranteePeriod;

  private int deliveryType;

  private int codAllowed;

  private int cancelable;

  private int returnable;

  private int attachmentRequired;

  private Long createdAt;

  private Long modifiedAt;

  private String modifiedBy;

  private int status;

  private List<SKUDto> skuList = new ArrayList<SKUDto>();

  private String deliverableZipCode;

  private int videoType = 0;

  private int productType;

  private int displaySkuOnAttributeId;
  
  private int pickupLocationId;

  private int isDisplaySkuWise;

  private String specificationData;

  /** For DM purpose */
  private String slug;

  private String dmContent;

  private String itemId;

  private LinkedHashMap<String, String> faq;

}
