
package com.lgitsolution.switcheshopcommon.subcribe.utility;

import com.lgitsolution.switcheshopcommon.subcribe.dto.SubscribeDetailsDto;
import com.lgitsolution.switcheshopcommon.subcribe.model.SubscribeDetail;

public class Utility {

  /**
   * Converts the dto to model object.
   * 
   * @param dto the dto dto class object
   * @return the model class object
   */
  public static SubscribeDetail convertDtoToModel(SubscribeDetailsDto dto) {
    SubscribeDetail model = new SubscribeDetail();
    model.setId(dto.getId());
    return model;
  }

  /**
   * Converts the model to dto object.
   * 
   * @param model the model class object
   * @return the dto dto class object
   */
  public static SubscribeDetailsDto convertModelToDto(SubscribeDetail model) {
    SubscribeDetailsDto dto = new SubscribeDetailsDto();
    dto.setId(model.getId());
    dto.setEmailId(model.getEmailId());
    return dto;
  }

}
