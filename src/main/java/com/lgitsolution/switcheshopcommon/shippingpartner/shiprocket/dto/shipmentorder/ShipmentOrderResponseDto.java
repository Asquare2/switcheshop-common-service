package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentOrderResponseDto {
  private int status;
  private Payload payload;
  private String message;
  private int status_code;
}
