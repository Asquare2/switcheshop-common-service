
package com.lgitsolution.switcheshopcommon.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleAccess {

  int readPermission;

  int writePermission;

  int updatePermission;

  int deletePermission;

  int dmPermission;

}
