
package com.lgitsolution.switcheshop.featuresection.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.lgitsolution.switcheshop.featuresection.dto.FeatureSectionDto;
import com.lgitsolution.switcheshop.featuresection.model.FeatureSection;

public class Utility {

  private static com.lgitsolution.switcheshop.common.util.Utility Utility =
          new com.lgitsolution.switcheshop.common.util.Utility();

  public static FeatureSection convertDtoToModel(FeatureSectionDto dto) {
    FeatureSection model = new FeatureSection();
    model.setRowOrderId(dto.getRowOrderId());
    model.setTitle(dto.getTitle());
    model.setShortDescription(dto.getShortDescription());
    model.setStyle(dto.getStyle());
    model.setId(dto.getId());
    model.setFilter(Utility.getSearchOptionsDtoJsonString(dto.getSearchOptionsDto()));
    model.setStatus(dto.getStatus());
    model.setDmContent(dto.getDmContent());
    model.setSlug(dto.getSlug());
    return model;
  }

  public static FeatureSectionDto convertModelToDto(FeatureSection model) {
    FeatureSectionDto dto = new FeatureSectionDto();
    dto.setRowOrderId(model.getRowOrderId());
    dto.setTitle(model.getTitle());
    dto.setShortDescription(model.getShortDescription());
    dto.setStyle(model.getStyle());
    dto.setId(model.getId());
    dto.setSearchOptionsDto(Utility.getSearchOptionsDtoObject(model.getFilter()));
    dto.setStatus(model.getStatus());
    dto.setDmContent(model.getDmContent());
    dto.setSlug(model.getSlug());
    return dto;
  }

  public static List<FeatureSectionDto> convertModelToDto(List<FeatureSection> modelList) {
    return modelList.stream().map(e -> convertModelToDto(e)).collect(Collectors.toList());
  }

}
