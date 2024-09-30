
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickuplocation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddPickupLocationResponse {

  private boolean success;
  private int pickup_id;
  private String company_name;
  private String full_name;
  private ShippingAddressDTO address;
  private String message;
  private int status_code;
}
