
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.couriers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerateAWBRequest {

  private Integer shipment_id;
  private Integer courier_id = null;
  private Integer is_return = 0;
}
