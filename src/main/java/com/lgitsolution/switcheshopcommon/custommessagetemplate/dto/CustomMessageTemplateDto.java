
package com.lgitsolution.switcheshopcommon.custommessagetemplate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomMessageTemplateDto {

  private Integer id;

  private String types;

  private String customTitle;

  private String customMessage;

  private String emailType;

}