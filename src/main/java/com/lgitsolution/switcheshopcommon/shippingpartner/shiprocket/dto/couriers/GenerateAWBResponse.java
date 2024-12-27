package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.couriers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class GenerateAWBResponse {

  private int awb_assign_status;
  private Response response;
}
