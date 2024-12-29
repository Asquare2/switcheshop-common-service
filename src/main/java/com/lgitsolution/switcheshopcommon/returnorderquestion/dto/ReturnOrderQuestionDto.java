
package com.lgitsolution.switcheshopcommon.returnorderquestion.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnOrderQuestionDto {

  private Integer id;

  private String question;

  private String answer;

  private String answerFieldType;

  private Integer status;

}