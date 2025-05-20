
package com.lgitsolution.switcheshopcommon.email.preferences.utility;

import com.lgitsolution.switcheshopcommon.email.preferences.dto.EmailPreferencesDto;
import com.lgitsolution.switcheshopcommon.email.preferences.model.EmailPreferences;
import com.lgitsolution.switcheshopcommon.email.preferences.model.SubscriptionEmailPreferences;

public class Utility {

  /**
   * Converts the dto object into model object.
   * 
   * @param dto the email preferences dto
   * @return the converted object
   */
  public static EmailPreferences convertDtoToModel(EmailPreferencesDto dto) {
    EmailPreferences model = new EmailPreferences();
    model.setEmailType(dto.getEmailType());
    model.setEmailId(dto.getEmailId());
    model.setPassword(dto.getPassword());
    model.setConfig(com.lgitsolution.switcheshopcommon.common.util.Utility.convertMapToJsonString(
            dto.getConfig()));
    model.setModifiedAt(com.lgitsolution.switcheshopcommon.common.util.Utility.getLocalDate(dto
            .getModifiedAt()));
    return model;
  }

  /**
   * Converts the model object into dto object.
   * 
   * @param model the email preferences model
   * @return the converted object
   */
  public static EmailPreferencesDto convertModelToDto(EmailPreferences model) {
    EmailPreferencesDto dto = new EmailPreferencesDto();
    dto.setId(model.getId());
    dto.setEmailType(model.getEmailType());
    dto.setEmailId(model.getEmailId());
    dto.setPassword(model.getPassword());
    dto.setConfig(com.lgitsolution.switcheshopcommon.common.util.Utility.convertJsonStringToMap(
            model.getConfig()));
    dto.setModifiedAt(com.lgitsolution.switcheshopcommon.common.util.Utility.getLocalDateMillis(
            model.getModifiedAt()));
    return dto;
  }

  /**
   * Converts the dto object into model object.
   * 
   * @param dto the email preferences dto
   * @return the converted object
   */
  public static SubscriptionEmailPreferences convertDtoToSubscriptionModel(
          EmailPreferencesDto dto) {
    SubscriptionEmailPreferences model = new SubscriptionEmailPreferences();
    model.setEmailType(dto.getEmailType());
    model.setEmailId(dto.getEmailId());
    model.setPassword(dto.getPassword());
    model.setConfig(com.lgitsolution.switcheshopcommon.common.util.Utility.convertMapToJsonString(
            dto.getConfig()));
    model.setModifiedAt(com.lgitsolution.switcheshopcommon.common.util.Utility.getLocalDate(dto
            .getModifiedAt()));
    return model;
  }

  /**
   * Converts the model object into dto object.
   * 
   * @param model the email preferences model
   * @return the converted object
   */
  public static EmailPreferencesDto convertSubscriptionModelToDto(
          SubscriptionEmailPreferences model) {
    EmailPreferencesDto dto = new EmailPreferencesDto();
    dto.setId(model.getId());
    dto.setEmailType(model.getEmailType());
    dto.setEmailId(model.getEmailId());
    dto.setPassword(model.getPassword());
    dto.setConfig(com.lgitsolution.switcheshopcommon.common.util.Utility.convertJsonStringToMap(
            model.getConfig()));
    dto.setModifiedAt(com.lgitsolution.switcheshopcommon.common.util.Utility.getLocalDateMillis(
            model.getModifiedAt()));
    return dto;
  }

}
