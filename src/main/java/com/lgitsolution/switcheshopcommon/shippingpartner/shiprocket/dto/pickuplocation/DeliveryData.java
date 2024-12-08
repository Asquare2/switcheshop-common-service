
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickuplocation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryData {

  private ShippingDataDTO data;
  private int status_code;

}
