
package com.lgitsolution.switcheshopcommon.email.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailDto {

  String to;
  String[] cc;
  String[] bcc;
  String subject;
  String body;
  boolean isHtmlContent;
  String filePath;

}
