
package com.lgitsolution.switcheshopcommon.invoice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceItemDto {

  private String title;

  private String hsn;

  private Float taxAmount;

  private Float taxPercentage;

  private Float originalPrice;

  private Float sellingPrice;

  private String skuName;
  
  private int quantity;
  
  private Float discountAmount;

  private String taxType = "IGST";

}
