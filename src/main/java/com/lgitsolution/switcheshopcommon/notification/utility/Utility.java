
package com.lgitsolution.switcheshopcommon.notification.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.lgitsolution.switcheshopcommon.notification.dto.NotificationDto;
import com.lgitsolution.switcheshopcommon.notification.dto.Priority;
import com.lgitsolution.switcheshopcommon.notification.model.Notification;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  public static Notification convertDtoToModel(NotificationDto notificationDto) {
    Notification notification = new Notification();
    notification.setId(notificationDto.getId());
    notification.setMessage(notificationDto.getMessage());
    notification.setRole(notificationDto.getRole());
    notification.setTableId(notificationDto.getTableId());
    notification.setModuleName(notificationDto.getModuleName());
    notification.setPriority(Priority.valueOfLabel(notificationDto.getPriority()));
    notification.setMail(notificationDto.isMail());
    notification.setMarkAsRead(notificationDto.isMarkAsRead());
    notification.setCreatedAt(CommonUtility.getLocalDate(notificationDto.getCreatedAt()));
    return notification;
  }

  public static NotificationDto convertModelToDto(Notification notification) {
    NotificationDto notificationDto = new NotificationDto();
    notificationDto.setId(notification.getId());
    notificationDto.setMessage(notification.getMessage());
    notificationDto.setRole(notification.getRole());
    notificationDto.setTableId(notification.getTableId());
    notificationDto.setModuleName(notification.getModuleName());
    notificationDto.setPriority(notification.getPriority().getValue());
    notificationDto.setMail(notification.isMail());
    notificationDto.setMarkAsRead(notification.isMarkAsRead());
    notificationDto.setCreatedAt(CommonUtility.getLocalDateMillis(notification.getCreatedAt()));
    return notificationDto;
  }

  public static List<NotificationDto> convertModelToDto(List<Notification> notificationList) {
    return notificationList.stream().map(Utility::convertModelToDto).collect(Collectors.toList());
  }
}
