
package com.lgitsolution.switcheshopcommon.custommessagetemplate.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.custommessagetemplate.dto.CustomMessageTemplateDto;
import com.lgitsolution.switcheshopcommon.custommessagetemplate.model.CustomMessageTemplate;

import io.micrometer.common.util.StringUtils;

public class Utility {

  /**
   * Converts the model to dto object.
   * 
   * @param customMessageTemplate the custom message template
   * @return the custom message template dto object
   */
  public static CustomMessageTemplateDto convertModelToDto(
          CustomMessageTemplate customMessageTemplate) {
    CustomMessageTemplateDto customMessageTemplateDto = new CustomMessageTemplateDto();
    customMessageTemplateDto.setId(customMessageTemplate.getId());
    customMessageTemplateDto.setTypes(customMessageTemplate.getTypes());
    String customTitle = customMessageTemplate.getCustomTitle();
    if (customTitle != null && StringUtils.isNotEmpty(customTitle)) {
      customMessageTemplateDto.setCustomTitle(customTitle);
    } else {
      customMessageTemplateDto.setCustomTitle(customMessageTemplate.getDefaultTitle());
    }
    String customMessage = customMessageTemplate.getCustomMessage();
    if (customMessage != null && StringUtils.isNotEmpty(customMessage)) {
      customMessageTemplateDto.setCustomMessage(customMessage);
    } else {
      customMessageTemplateDto.setCustomMessage(customMessageTemplate.getDefaultMessage());
    }
    customMessageTemplateDto.setEmailType(customMessageTemplate.getEmailType());
    return customMessageTemplateDto;
  }

  /**
   * Converts the list of model object to list of dto object.
   * 
   * @param customMessageTemplateList the list of model object
   * @return the list of dto object
   */
  public static List<CustomMessageTemplateDto> convertModelToDto(
          List<CustomMessageTemplate> customMessageTemplateList) {
    List<CustomMessageTemplateDto> customMessageTemplateDtoList = new ArrayList<>();
    customMessageTemplateList.stream().forEach(customMessageTemplate -> customMessageTemplateDtoList
            .add(convertModelToDto(customMessageTemplate)));
    return customMessageTemplateDtoList;
  }

}
