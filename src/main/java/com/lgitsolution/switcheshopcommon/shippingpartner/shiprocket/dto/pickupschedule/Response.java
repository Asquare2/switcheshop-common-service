package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickupschedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder.AssignedDateTime;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

  private String pickup_scheduled_date;
  private String pickup_token_number;
  private int status;
  private String others;
  private AssignedDateTime pickup_generated_date;
  private String data;
}
