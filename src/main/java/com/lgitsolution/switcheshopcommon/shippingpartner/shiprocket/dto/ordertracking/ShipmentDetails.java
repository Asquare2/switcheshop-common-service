package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.ordertracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentDetails {

  private long id;
  private String awb_code;
  private int courier_company_id;
  private long shipment_id;
  private long order_id;
  private String pickup_date;
  private String delivered_date;
  private String weight;
  private int packages;
  private String current_status;
  private String delivered_to;
  private String destination;
  private String consignee_name;
  private String origin;
  private String courier_agent_details;
  private String edd;
}
