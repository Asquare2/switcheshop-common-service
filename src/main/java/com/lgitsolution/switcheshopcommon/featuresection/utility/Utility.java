
package com.lgitsolution.switcheshopcommon.featuresection.utility;

import static com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionConsant.FEATURE_SECTION_TYPE_1;
import static com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionConsant.FEATURE_SECTION_TYPE_2;
import static com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionConsant.FEATURE_SECTION_TYPE_3;
import static com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionConsant.FEATURE_SECTION_TYPE_4;
import static com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionConsant.FEATURE_SECTION_TYPE_5;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionDto;
import com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionType1Dto;
import com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionType2Dto;
import com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionType3Dto;
import com.lgitsolution.switcheshopcommon.featuresection.model.FeatureSection;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static FeatureSection convertDtoToModel(FeatureSectionDto dto) {
    FeatureSection model = new FeatureSection();
    model.setRowOrderId(dto.getRowOrderId());
    model.setTitle(dto.getTitle());
    model.setType(dto.getType());
    model.setStatus(dto.getStatus());
    if (dto.getType() == FEATURE_SECTION_TYPE_1) {
      model.setTypeFilterData(Utility.ConvertObjectToJsonString(dto.getFeatureSectionType1()));
    } else if (dto.getType() == FEATURE_SECTION_TYPE_2) {
      model.setTypeFilterData(Utility.ConvertObjectToJsonString(dto.getFeatureSectionType2()));
    } else if (dto.getType() == FEATURE_SECTION_TYPE_3) {
      model.setTypeFilterData(Utility.ConvertObjectToJsonString(dto.getFeatureSectionType3()));
    } else if (dto.getType() == FEATURE_SECTION_TYPE_4) {
      model.setTypeFilterData(Utility.ConvertObjectToJsonString(dto.getFeatureSectionType4()));
    } else if (dto.getType() == FEATURE_SECTION_TYPE_5) {
      model.setTypeFilterData(Utility.ConvertObjectToJsonString(dto.getFeatureSectionType5()));
    }
    return model;
  }

  public static FeatureSectionDto convertModelToDto(FeatureSection model) {
    FeatureSectionDto dto = new FeatureSectionDto();
    dto.setRowOrderId(model.getRowOrderId());
    dto.setTitle(model.getTitle());
    dto.setType(model.getType());
    if (model.getType() == FEATURE_SECTION_TYPE_1) {
      dto.setFeatureSectionType1(Utility.convertJsonToObject(model.getTypeFilterData(),
              new FeatureSectionType1Dto()));
    } else if (model.getType() == FEATURE_SECTION_TYPE_2) {
      dto.setFeatureSectionType2(Utility.convertJsonToObject(model.getTypeFilterData(),
              new FeatureSectionType2Dto()));
    } else if (model.getType() == FEATURE_SECTION_TYPE_3) {
      dto.setFeatureSectionType3(parseJsonToType3List(model.getTypeFilterData()));
    } else if (model.getType() == FEATURE_SECTION_TYPE_4) {
      dto.setFeatureSectionType4(parseJsonToType1List(model.getTypeFilterData()));
    }
    else if (model.getType() == FEATURE_SECTION_TYPE_5) {
      dto.setFeatureSectionType5(parseJsonToType1List(model.getTypeFilterData()));
    }
    dto.setId(model.getId());
    dto.setStatus(model.getStatus());
    return dto;
  }

  /**
   * Parse json string to type 1 feature section details list.
   * 
   * @param json string
   * @return the list of address details
   */
  private static List<FeatureSectionType1Dto> parseJsonToType1List(String json) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(json, new TypeReference<List<FeatureSectionType1Dto>>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to parse JSON to List<FeatureSectionType1Dto>", e);
    }
  }

  /**
   * Parse json string to type 1 feature section details list.
   * 
   * @param json string
   * @return the list of address details
   */
  private static List<FeatureSectionType3Dto> parseJsonToType3List(String json) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(json, new TypeReference<List<FeatureSectionType3Dto>>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to parse JSON to List<FeatureSectionType1Dto>", e);
    }
  }

  public static List<FeatureSectionDto> convertModelToDto(List<FeatureSection> modelList) {
    return modelList.stream().map(e -> convertModelToDto(e)).collect(Collectors.toList());
  }

}
