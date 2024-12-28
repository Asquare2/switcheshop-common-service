package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.returnorder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder.AssignedDateTime;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturenOrderPayload {

  private int order_created;

  private int awb_generated;

  private int pickup_generated;

  private String pickup_scheduled_date;

  private long order_id;

  private long shipment_id;

  private String awb_code;

  private int courier_company_id;

  private String courier_name;

  private AssignedDateTime assigned_date_time;

  private double applied_weight;

  private int cod;

  private int is_return;

  private String routing_code;

  private String rto_routing_code;

  private String pickup_token_number;
}
