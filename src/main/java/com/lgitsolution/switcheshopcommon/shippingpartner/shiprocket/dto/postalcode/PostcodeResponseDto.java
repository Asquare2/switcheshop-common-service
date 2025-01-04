
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.postalcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodeResponseDto {

  private boolean success;
  private PostcodeDetails postcode_details;
  private String message;
  private int status_code;
}
