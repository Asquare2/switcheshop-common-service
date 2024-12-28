package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.couriers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder.AssignedDateTime;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData {

  private int courier_company_id;
  private String awb_code;
  private int cod;
  private int order_id;
  private int shipment_id;
  private int awb_code_status;
  private AssignedDateTime assigned_date_time;
  private float applied_weight;
  private int company_id;
  private String courier_name;
  private String child_courier_name = null;
  private String pickup_scheduled_date;
  private String routing_code;
  private String rto_routing_code;
  private String invoice_no;
  private String transporter_id;
  private String transporter_name;
  private ShippedBy shipped_by;
}
