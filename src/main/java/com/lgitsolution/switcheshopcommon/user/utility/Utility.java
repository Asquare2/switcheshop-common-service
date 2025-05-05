
package com.lgitsolution.switcheshopcommon.user.utility;

import com.lgitsolution.switcheshopcommon.user.dto.SystemUserDto;
import com.lgitsolution.switcheshopcommon.user.model.SystemUser;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static SystemUser convertDtoToModel(SystemUserDto dto) {
    SystemUser model = new SystemUser();
    model.setUserName(dto.getUserName());
    model.setAddress(dto.getAddress());
    model.setCity(dto.getCity());
    model.setEmail(dto.getEmail());
    model.setFullName(dto.getFullName());
    model.setId(dto.getId());
    model.setIdentityProof(dto.getIdentityProof());
    model.setMobile(dto.getMobile());
    model.setModuleAccess(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getModuleAccessJsonString(dto.getModuleAccess()));
    model.setPassword(dto.getPassword());
    model.setRole(dto.getRole());
    model.setMultiMedia(CommonUtility.getMultiMediaJsonString(dto.getMultiMedia()));
    model.setCreatedAt(CommonUtility.getLocalDate(dto.getCreatedAt()));
    model.setModifiedAt(CommonUtility.getLocalDate(dto.getModifiedAt()));
    model.setLastLogin(CommonUtility.getLocalDateTime(dto.getLastLogin()));
    model.setCompanyId(dto.getCompanyId());
    return model;
  }

  public static SystemUserDto convertModelToDto(SystemUser systemUser) {
    return convertModelToDto(systemUser, false);
  }

  public static SystemUserDto convertModelToDto(SystemUser model, boolean skipPassword) {
    SystemUserDto dto = new SystemUserDto();
    dto.setUserName(model.getUsername());
    dto.setAddress(model.getAddress());
    dto.setCity(model.getCity());
    dto.setEmail(model.getEmail());
    dto.setFullName(model.getFullName());
    dto.setId(model.getId());
    dto.setIdentityProof(model.getIdentityProof());
    dto.setMobile(model.getMobile());
    dto.setModuleAccess(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getModuleAccessObject(model.getModuleAccess()));
    if (!skipPassword) {
      dto.setPassword(model.getPassword());
    }
    dto.setRole(model.getRole());
    dto.setMultiMedia(CommonUtility.getMultiMediaObject(model.getMultiMedia()));
    dto.setCreatedAt(CommonUtility.getLocalDateMillis(model.getCreatedAt()));
    dto.setModifiedAt(CommonUtility.getLocalDateMillis(model.getModifiedAt()));
    dto.setLastLogin(CommonUtility.getLocalDateTimeMillis(model.getLastLogin()));
    dto.setCompanyId(model.getCompanyId());
    return dto;
  }

}
