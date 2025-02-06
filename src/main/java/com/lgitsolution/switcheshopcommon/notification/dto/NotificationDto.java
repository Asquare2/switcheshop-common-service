
package com.lgitsolution.switcheshopcommon.notification.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationDto {

  private Long id;
  private String message;
  private String role;
  private Long tableId;
  private String moduleName;
  private String priority;
  private boolean isMail;
  private boolean isMarkAsRead;
  private Long createdAt;
}
