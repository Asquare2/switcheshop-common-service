
package com.lgitsolution.switcheshopcommon.common.authentication.dto;

import com.lgitsolution.switcheshopcommon.customer.dto.CustomerDetailsDto;
import com.lgitsolution.switcheshopcommon.customer.model.CustomerDetails;

import lombok.Data;

@Data
public class JWTAuthResponse {

  private String token;

  private String refreshToken;

  private String userName;

  private String name;
  
  private CustomerDetails details;
}
