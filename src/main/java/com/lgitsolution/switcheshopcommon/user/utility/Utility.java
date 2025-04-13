
package com.lgitsolution.switcheshopcommon.user.utility;

import com.lgitsolution.switcheshopcommon.user.dto.SystemUserDto;
import com.lgitsolution.switcheshopcommon.user.model.SystemUser;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static SystemUser convertDtoToModel(SystemUserDto systemUserDto) {
    SystemUser systemUser = new SystemUser();
    systemUser.setUserName(systemUserDto.getUserName());
    systemUser.setAddress(systemUserDto.getAddress());
    systemUser.setCity(systemUserDto.getCity());
    systemUser.setEmail(systemUserDto.getEmail());
    systemUser.setFullName(systemUserDto.getFullName());
    systemUser.setId(systemUserDto.getId());
    systemUser.setIdentityProof(systemUserDto.getIdentityProof());
    systemUser.setMobile(systemUserDto.getMobile());
    systemUser.setModuleAccess(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getModuleAccessJsonString(systemUserDto.getModuleAccess()));
    systemUser.setPassword(systemUserDto.getPassword());
    systemUser.setRole(systemUserDto.getRole());
    systemUser.setMultiMedia(CommonUtility.getMultiMediaJsonString(systemUserDto.getMultiMedia()));
    systemUser.setCreatedAt(CommonUtility.getLocalDate(systemUserDto.getCreatedAt()));
    systemUser.setModifiedAt(CommonUtility.getLocalDate(systemUserDto.getModifiedAt()));
    systemUser.setLastLogin(CommonUtility.getLocalDateTime(systemUserDto.getLastLogin()));
    return systemUser;
  }

  public static SystemUserDto convertModelToDto(SystemUser systemUser) {
    return convertModelToDto(systemUser, false);
  }

  public static SystemUserDto convertModelToDto(SystemUser systemUser, boolean skipPassword) {
    SystemUserDto systemUserDto = new SystemUserDto();
    systemUserDto.setUserName(systemUser.getUsername());
    systemUserDto.setAddress(systemUser.getAddress());
    systemUserDto.setCity(systemUser.getCity());
    systemUserDto.setEmail(systemUser.getEmail());
    systemUserDto.setFullName(systemUser.getFullName());
    systemUserDto.setId(systemUser.getId());
    systemUserDto.setIdentityProof(systemUser.getIdentityProof());
    systemUserDto.setMobile(systemUser.getMobile());
    systemUserDto.setModuleAccess(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getModuleAccessObject(systemUser.getModuleAccess()));
    if (!skipPassword) {
      systemUserDto.setPassword(systemUser.getPassword());
    }
    systemUserDto.setRole(systemUser.getRole());
    systemUserDto.setMultiMedia(CommonUtility.getMultiMediaObject(systemUser.getMultiMedia()));
    systemUserDto.setCreatedAt(CommonUtility.getLocalDateMillis(systemUser.getCreatedAt()));
    systemUserDto.setModifiedAt(CommonUtility.getLocalDateMillis(systemUser.getModifiedAt()));
    systemUserDto.setLastLogin(CommonUtility.getLocalDateTimeMillis(systemUser.getLastLogin()));
    return systemUserDto;
  }

}
