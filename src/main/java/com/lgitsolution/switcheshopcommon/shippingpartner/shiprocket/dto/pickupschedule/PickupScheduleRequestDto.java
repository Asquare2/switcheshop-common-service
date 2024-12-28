package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickupschedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupScheduleRequestDto {

  private Integer shipment_id;
  private String status = null;
  private String[] pickup_date = null;

}
