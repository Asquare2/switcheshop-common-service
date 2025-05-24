
package com.lgitsolution.switcheshopcommon.client.utility;

import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgitsolution.switcheshopcommon.client.dto.ClientDetailsDto;
import com.lgitsolution.switcheshopcommon.client.model.ClientDetails;
import com.lgitsolution.switcheshopcommon.promocode.dto.CustomerPromoCodeDetails;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  public static ClientDetails convertDtoToModel(ClientDetailsDto dto) {
    ClientDetails model = new ClientDetails();
    model.setId(dto.getId());
    model.setUsername(dto.getUsername());
    model.setSchema(dto.getSchema());
    model.setCompId(dto.getCompId());
    model.setUrl(dto.getUrl());
    model.setMappedUrl(dto.getMappedUrl());
    model.setCreatedAt(CommonUtility.getLocalDate(dto.getCreatedAt()));
    model.setPromocode(CommonUtility.ConvertObjectToJsonString(dto.getPromocodeDetails()));
    return model;
  }

  public static ClientDetailsDto convertModelToDto(ClientDetails model) {
    ClientDetailsDto dto = new ClientDetailsDto();
    dto.setId(model.getId());
    dto.setUsername(model.getUsername());
    dto.setSchema(model.getSchema());
    dto.setCompId(model.getCompId());
    dto.setMappedUrl(model.getMappedUrl());
    dto.setUrl(model.getUrl());
    dto.setCreatedAt(CommonUtility.getLocalDateMillis(model.getCreatedAt()));
    if (model.getPromocode() != null && !model.getPromocode().isBlank()) {
      dto.setPromocodeDetails(parseJsonToMap(model.getPromocode()));
    }
    return dto;
  }

  private static HashMap<Integer, CustomerPromoCodeDetails> parseJsonToMap(String json) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(json,
              new TypeReference<HashMap<Integer, CustomerPromoCodeDetails>>() {
              });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(
              "Failed to parse JSON to HashMap<String, CustomerPromoCodeDetails>", e);
    }
  }

}
