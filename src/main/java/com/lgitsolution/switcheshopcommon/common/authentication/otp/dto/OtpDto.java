
package com.lgitsolution.switcheshopcommon.common.authentication.otp.dto;

import lombok.Data;

@Data
public class OtpDto {

  private Long generationTimeMillis;

  private String otp;

}
