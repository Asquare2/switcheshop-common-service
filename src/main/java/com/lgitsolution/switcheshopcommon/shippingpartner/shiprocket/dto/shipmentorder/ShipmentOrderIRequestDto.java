package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentOrderIRequestDto {

  private String order_id;
  private String order_date;
  private String channel_id;

  private String billing_customer_name;
  private String billing_last_name;
  private String billing_address;
  private String billing_city;
  private String billing_pincode;
  private String billing_state;
  private String billing_country;
  private String billing_email;
  private String billing_phone;
  private String billing_alternate_phone;

  private boolean shipping_is_billing;

  private String shipping_customer_name;
  private String shipping_last_name;
  private String shipping_address;
  private String shipping_city;
  private String shipping_pincode;
  private String shipping_state;
  private String shipping_country;
  private String shipping_email;
  private String shipping_phone;
  private String shipping_alternate_phone;

  private List<OrderItem> order_items;
  private String payment_method;
  private int sub_total;
  private int length;
  private int breadth;
  private int height;
  private double weight;
  private String pickup_location;

}
