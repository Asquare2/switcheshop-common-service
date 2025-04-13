
package com.lgitsolution.switcheshopcommon.user.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.ModuleAccess;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemUserDto {

  private Integer id;

  private String userName;

  private String password;

  private String fullName;

  private String email;

  private Map<String, ModuleAccess> moduleAccess;

  private String role;

  private String address;

  private String city;

  private String mobile;

  private String identityProof;

  private Multimedia multiMedia;

  private Long createdAt;

  private Long modifiedAt;

  private Long lastLogin;

}
