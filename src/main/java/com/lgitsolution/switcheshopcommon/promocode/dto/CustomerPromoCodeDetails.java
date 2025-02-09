package com.lgitsolution.switcheshopcommon.promocode.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPromoCodeDetails {

  private Integer maxCount;

  private Integer isReusable;
  
  private Integer noOfUsage;
  
}
