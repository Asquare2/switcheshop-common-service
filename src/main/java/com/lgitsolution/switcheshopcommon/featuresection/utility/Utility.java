
package com.lgitsolution.switcheshopcommon.featuresection.utility;

import static com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionConsant.FEATURE_SECTION_TYPE_1;
import static com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionConsant.FEATURE_SECTION_TYPE_2;
import static com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionConsant.FEATURE_SECTION_TYPE_3;
import static com.lgitsolution.switcheshopcommon.featuresection.dto.FeatureSectionConsant.FEATURE_SECTION_TYPE_4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    if (dto.getType() == FEATURE_SECTION_TYPE_1) {
      model.setTypeFilterData(Utility.ConvertObjectToJsonString(dto.getFeatureSectionType1()));
    } else if (dto.getType() == FEATURE_SECTION_TYPE_2) {
      model.setTypeFilterData(Utility.ConvertObjectToJsonString(dto.getFeatureSectionType2()));
    } else if (dto.getType() == FEATURE_SECTION_TYPE_3) {
      model.setTypeFilterData(Utility.ConvertObjectToJsonString(dto.getFeatureSectionType3()));
    } else if (dto.getType() == FEATURE_SECTION_TYPE_4) {
      model.setTypeFilterData(Utility.ConvertObjectToJsonString(dto.getFeatureSectionType4()));
    }
    model.setId(dto.getId());
    model.setStatus(dto.getStatus());
    model.setDmContent(dto.getDmContent());
    model.setSlug(dto.getSlug());
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
      dto.setFeatureSectionType3(Utility.convertJsonToObject(model.getTypeFilterData(),
              new FeatureSectionType3Dto()));
    } else if (model.getType() == FEATURE_SECTION_TYPE_4) {
      dto.setFeatureSectionType4(Utility.convertJsonToObject(model.getTypeFilterData(),
              new ArrayList<FeatureSectionType1Dto>()));
    }
    dto.setId(model.getId());
    dto.setStatus(model.getStatus());
    dto.setDmContent(model.getDmContent());
    dto.setSlug(model.getSlug());
    return dto;
  }

  public static List<FeatureSectionDto> convertModelToDto(List<FeatureSection> modelList) {
    return modelList.stream().map(e -> convertModelToDto(e)).collect(Collectors.toList());
  }

}
