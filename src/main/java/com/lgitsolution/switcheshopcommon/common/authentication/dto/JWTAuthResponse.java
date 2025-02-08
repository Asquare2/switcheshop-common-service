
package com.lgitsolution.switcheshopcommon.common.authentication.dto;

import lombok.Data;

@Data
public class JWTAuthResponse {

  private String token;

  private String refreshToken;

  private String userName;

  private String name;

}
