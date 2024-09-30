
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItem {

  private String name;
  private String sku;
  private int units;
  private String selling_price;
  private String discount;
  private String tax;
  private int hsn;
}
