
package com.lgitsolution.switcheshopcommon.email.preferences.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailPreferencesDto {

  /** The id. */
  private Integer id;

  private String emailType;

  /** The email id. */
  private String emailId;

  /** The password. */
  private String password;

  private Map<String, String> config;

  /** The modified at date. */
  private Long modifiedAt;

}
