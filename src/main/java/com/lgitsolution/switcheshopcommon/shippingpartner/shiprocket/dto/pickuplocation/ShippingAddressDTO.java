
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickuplocation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingAddressDTO {

  private long id;
  private String pickup_location;
  private String address_type;
  private String address;
  private String address_2;
  private boolean updated_address;
  private String old_address;
  private String old_address2;
  private String city;
  private String state;
  private String country;
  private String pin_code;
  private String email;
  private int is_first_mile_pickup;
  private String phone;
  private String name;
  private long company_id;
  private String gstin;
  private String vendor_name;
  private int status;
  private int phone_verified;
  private String lat;
  private String lng;
  private String open_time;
  private String close_time;
  private String warehouse_code;
  private String alternate_phone;
  private long rto_address_id;
  private int lat_long_status;
  @JsonProperty(value = "new")
  private int isNew;
  private Object associated_rto_address;
}
