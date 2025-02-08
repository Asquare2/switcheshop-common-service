
package com.lgitsolution.switcheshopcommon.common.authentication.otp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.authentication.dto.JWTAuthResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OtpValidationResponseDto {

  private OtpStatus otpStatus;

  private String phoneNumber;

  private String emailId;

  private Boolean isUserAlreadyExist;

  private JWTAuthResponse jwtAuthResponse;

}
