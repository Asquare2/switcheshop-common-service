package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.serviceability;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceabilityRequestDto {

  private int pickup_postcode;
  private int delivery_postcode;
  private int cod = 0;
  private String weight = "3";

}
