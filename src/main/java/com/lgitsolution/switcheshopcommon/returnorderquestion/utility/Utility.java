
package com.lgitsolution.switcheshopcommon.returnorderquestion.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.lgitsolution.switcheshopcommon.returnorderquestion.dto.ReturnOrderQuestionDto;
import com.lgitsolution.switcheshopcommon.returnorderquestion.model.ReturnOrderQuestion;

public class Utility {

  public static ReturnOrderQuestion convertDtoToModel(ReturnOrderQuestionDto dto) {
    ReturnOrderQuestion model = new ReturnOrderQuestion();
    model.setId(dto.getId());
    model.setQuestion(dto.getQuestion());
    model.setAnswer(dto.getAnswer());
    model.setAnswerFieldType(dto.getAnswerFieldType());
    model.setStatus(dto.getStatus());
    return model;
  }

  public static ReturnOrderQuestionDto convertModelToDto(ReturnOrderQuestion model) {
    ReturnOrderQuestionDto dto = new ReturnOrderQuestionDto();
    dto.setId(model.getId());
    dto.setQuestion(model.getQuestion());
    dto.setAnswer(model.getAnswer());
    dto.setAnswerFieldType(model.getAnswerFieldType());
    dto.setStatus(model.getStatus());
    return dto;
  }

  public static List<ReturnOrderQuestionDto> convertModelToDto(
          List<ReturnOrderQuestion> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).collect(Collectors.toList());
  }
}
