
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickuplocation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddPickupLocationRequest {

  private String pickup_location;
  private String name;
  private String email;
  private String phone;
  private String address;
  private String address_2;
  private String city;
  private String state;
  private String country;
  private String pin_code;
}
