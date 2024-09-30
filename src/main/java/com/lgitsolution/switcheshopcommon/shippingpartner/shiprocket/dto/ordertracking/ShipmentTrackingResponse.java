package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.ordertracking;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentTrackingResponse {

  private int track_status;
  private int shipment_status;
  private List<ShipmentDetails> shipment_track;
  private List<ShipmentTrackActivities> shipment_track_activities;
  private String track_url;
  private String etd;
  private QcResponse qc_response;
  private String message;
  private int status_code;
}
