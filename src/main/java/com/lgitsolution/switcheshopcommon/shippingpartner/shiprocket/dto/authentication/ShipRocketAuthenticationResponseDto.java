package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipRocketAuthenticationResponseDto {

  private int companyId;
  private String createdAt;
  private String email;
  private String firstName;
  private int id;
  private String lastName;
  private String token;
  private String message;
  // 403: invalid id or pass word
  private int status_code;

}
