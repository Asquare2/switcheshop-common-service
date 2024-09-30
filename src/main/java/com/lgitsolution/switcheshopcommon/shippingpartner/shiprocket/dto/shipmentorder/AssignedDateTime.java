package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignedDateTime {

  private String date;
  private int timezone_type;
  private String timezone;

}
