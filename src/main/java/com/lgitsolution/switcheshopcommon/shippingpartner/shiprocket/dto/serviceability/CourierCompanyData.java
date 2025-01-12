
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.serviceability;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourierCompanyData {

  private Integer cod;
  private String estimated_delivery_days;
  private String etd;
}
