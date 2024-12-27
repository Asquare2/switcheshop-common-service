package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.couriers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippedBy {
  private String shipper_company_name;
  private String shipper_address_1;
  private String shipper_address_2;
  private String shipper_city;
  private String shipper_state;
  private String shipper_country;
  private String shipper_postcode;
  private int shipper_first_mile_activated;
  private String shipper_phone;
  private String shipper_email;
  private String rto_company_name;
  private String rto_address_1;
  private String rto_address_2;
  private String rto_city;
  private String rto_state;
  private String rto_country;
  private String rto_postcode;
  private String rto_phone;
  private String rto_email;
}
