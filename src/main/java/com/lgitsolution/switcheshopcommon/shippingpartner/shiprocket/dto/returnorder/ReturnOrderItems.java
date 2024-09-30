
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.returnorder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnOrderItems {

  private String name;
  private boolean qc_enable;
  private String qc_product_name;
  private String sku;
  private int units;
  private double selling_price;
  private double discount;
  private String qc_brand;
  private String qc_product_image;
}
