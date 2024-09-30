package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {

  private int pickup_location_added;
  private int order_created;
  private int awb_generated;
  private int label_generated;
  private int pickup_generated;
  private int manifest_generated;
  private String pickup_scheduled_date;
  private String pickup_booked_date;
  private int order_id;
  private int shipment_id;
  private String awb_code;
  private int courier_company_id;
  private String courier_name;
  private AssignedDateTime assigned_date_time;
  private int applied_weight;
  private int cod;
  private String label_url;
  private String manifest_url;
  private String routing_code;
  private String rto_routing_code;
  private String pickup_token_number;

}
