
package com.lgitsolution.switcheshopcommon.faq.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaqDto {

  private Integer id;

  private String question;

  private String answer;

  private String title;

}