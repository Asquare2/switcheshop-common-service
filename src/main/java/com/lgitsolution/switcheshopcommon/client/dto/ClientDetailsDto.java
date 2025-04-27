
package com.lgitsolution.switcheshopcommon.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDetailsDto {

  private Integer id;

  private String username;

  private String compId;

  private String schema;

  private String url;

  private String mobileNumber;

  private Long createdAt;
}
