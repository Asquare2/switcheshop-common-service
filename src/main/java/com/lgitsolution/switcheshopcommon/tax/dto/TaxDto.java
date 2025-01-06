
package com.lgitsolution.switcheshopcommon.tax.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxDto {

  Integer id;

  String title;

  Float percentage;

  Float minPrice;

  Float maxPrice;

  /**
   * Gets the concatenated title and tax value e.g if title is GSTIN and percentage is 5.3 then the
   * value will be <b>GSTIN (5%)</b>.
   * 
   * @return the concatenated title and tax information
   */
  public String getDisplayableTax() {
    return title + " (" + percentage + "%)";
  }

}
