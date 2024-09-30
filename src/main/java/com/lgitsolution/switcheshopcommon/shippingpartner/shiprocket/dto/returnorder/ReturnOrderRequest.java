
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.returnorder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnOrderRequest {

  private String order_id;
  private String order_date;
  private String channel_id;
  private String pickup_customer_name;
  private String pickup_last_name;
  private String company_name;
  private String pickup_address;
  private String pickup_address_2;
  private String pickup_city;
  private String pickup_state;
  private String pickup_country;
  private int pickup_pincode;
  private String pickup_email;
  private String pickup_phone;
  private String pickup_isd_code;
  private String shipping_customer_name;
  private String shipping_last_name;
  private String shipping_address;
  private String shipping_address_2;
  private String shipping_city;
  private String shipping_country;
  private int shipping_pincode;
  private String shipping_state;
  private String shipping_email;
  private String shipping_isd_code;
  private long shipping_phone;
  private List<ReturnOrderItems> order_items;
  private String payment_method;
  private String total_discount;
  private double sub_total;
  private int length;
  private int breadth;
  private int height;
  private double weight;
  private boolean request_pickup;
}
