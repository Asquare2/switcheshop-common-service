
package com.lgitsolution.switcheshopcommon.client.utility;

import com.lgitsolution.switcheshopcommon.client.dto.ClientDetailsDto;
import com.lgitsolution.switcheshopcommon.client.model.ClientDetails;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  public static ClientDetails convertDtoToModel(ClientDetailsDto dto) {
    ClientDetails model = new ClientDetails();
    model.setId(dto.getId());
    model.setUsername(dto.getUsername());
    model.setSchema(dto.getSchema());
    model.setCompId(dto.getCompId());
    model.setUrl(dto.getUrl());
    model.setCreatedAt(CommonUtility.getLocalDate(dto.getCreatedAt()));
    return model;
  }

  public static ClientDetailsDto convertModelToDto(ClientDetails model) {
    ClientDetailsDto dto = new ClientDetailsDto();
    dto.setId(model.getId());
    dto.setUsername(model.getUsername());
    dto.setSchema(model.getSchema());
    dto.setCompId(model.getCompId());
    dto.setUrl(model.getUrl());
    dto.setCreatedAt(CommonUtility.getLocalDateMillis(model.getCreatedAt()));
    return dto;
  }

}
