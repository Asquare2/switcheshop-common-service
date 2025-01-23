
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.ordertracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentTrackActivities {

  private String date;
  private String status;
  private String activity;
  private String location;
  @JsonProperty(value = "sr-status")
  private String srStatus;
  @JsonProperty(value = "sr-status-label")
  private String srStatusLabel;
}
