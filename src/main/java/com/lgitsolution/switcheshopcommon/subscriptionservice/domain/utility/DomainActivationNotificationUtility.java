
package com.lgitsolution.switcheshopcommon.subscriptionservice.domain.utility;

import com.lgitsolution.switcheshopcommon.subscriptionservice.domain.dto.DomainActivationNotificationDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.domain.model.DomainActivationNotification;

public class DomainActivationNotificationUtility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  public static DomainActivationNotification convertDtoToModel(
          DomainActivationNotificationDto dto) {
    DomainActivationNotification model = new DomainActivationNotification();
    model.setId(dto.getId());
    model.setClientDetailId(dto.getClientDetailId());
    model.setDomainName(dto.getDomainName());
    model.setStatus(dto.getStatus());
    model.setCreatedAt(CommonUtility.getLocalDate(dto.getCreatedAt()));
    return model;
  }

  public static DomainActivationNotificationDto convertModelToDto(
          DomainActivationNotification model) {
    DomainActivationNotificationDto dto = new DomainActivationNotificationDto();
    dto.setId(model.getId());
    dto.setClientDetailId(model.getClientDetailId());
    dto.setDomainName(model.getDomainName());
    dto.setStatus(model.getStatus());
    dto.setCreatedAt(CommonUtility.getLocalDateMillis(model.getCreatedAt()));
    return dto;
  }

}
