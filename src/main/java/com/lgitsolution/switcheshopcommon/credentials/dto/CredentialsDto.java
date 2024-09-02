
package com.lgitsolution.switcheshopcommon.credentials.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialsDto {

  /** The id. */
  private Integer id;

  /** The service name. */
  private String serviceName;

  /** The email id. */
  private String emailId;

  /** The password. */
  private String password;

  /** The client id. */
  private String clientId;

  /** The client secret. */
  private String clientSecret;

  private Map<String, String> config;

  /** The modified at date. */
  private Long modifiedAt;

  /** The phone number */
  private String phoneNumber;

}
