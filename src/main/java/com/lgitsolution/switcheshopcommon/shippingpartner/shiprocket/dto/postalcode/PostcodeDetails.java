
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.postalcode;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodeDetails {

  private String postcode;
  private String city;
  private List<String> locality;
  private String state;
  private String state_code;
  private String longitude;
  private String latitude;
  private String country;
}
