
package com.lgitsolution.switcheshopcommon.faq.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.faq.dto.FaqDto;
import com.lgitsolution.switcheshopcommon.faq.model.Faq;

public class Utility {

  /**
   * this method converts faq to Dto
   * 
   * @param faqDto
   * @return the faq model
   */
  public static Faq convertDtoToModel(FaqDto faqDto) {
    Faq faq = new Faq();
    faq.setId(faqDto.getId());
    faq.setQuestion(faqDto.getQuestion());
    faq.setAnswer(faqDto.getAnswer());
    faq.setTitle(faqDto.getTitle());
    return faq;
  }

  public static FaqDto convertModelToDto(Faq faq) {
    FaqDto faqDto = new FaqDto();
    faqDto.setId(faq.getId());
    faqDto.setQuestion(faq.getQuestion());
    faqDto.setAnswer(faq.getAnswer());
    faqDto.setTitle(faq.getTitle());
    return faqDto;
  }

  public static List<FaqDto> convertModelToDto(List<Faq> faqList) {
    List<FaqDto> faqDtoList = new ArrayList<>();
    for (Faq faq : faqList) {
      FaqDto faqDto = convertModelToDto(faq);
      faqDtoList.add(faqDto);
    }
    return faqDtoList;
  }

}
