
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickupschedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupScheduleResponseDto {

  private int pickup_status;
  private Response response;
  private String message;
  private int status_code;
}
