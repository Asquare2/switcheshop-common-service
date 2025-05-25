
package com.lgitsolution.switcheshopcommon.subscriptionservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainActivationNotificationDto {

  private int id;

  private int clientDetailId;

  private String domainName;

  private int status;

  private Long createdAt;

}
