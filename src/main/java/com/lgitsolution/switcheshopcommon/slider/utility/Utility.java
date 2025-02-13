
package com.lgitsolution.switcheshopcommon.slider.utility;

import static com.lgitsolution.switcheshopcommon.slider.dto.SliderConstants.SLDR_TYPE_FILTER;
import static com.lgitsolution.switcheshopcommon.slider.dto.SliderConstants.SLDR_TYPE_LINK;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.slider.dto.SliderDto;
import com.lgitsolution.switcheshopcommon.slider.model.Slider;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static Slider convertDtoToModel(SliderDto dto) {
    Slider model = new Slider();
    model.setMultiMedia(dto.getMultiMedia());
    model.setId(dto.getId());
    model.setType(dto.getType());
    if (dto.getType().equals(SLDR_TYPE_LINK)) {
      model.setLink(dto.getLink());
    } else if (dto.getType().equals(SLDR_TYPE_FILTER)) {
      model.setFilter(Utility.getSearchOptionsDtoJsonString(dto.getSearchOptionsDto()));
    }
    model.setStatus(dto.getStatus());
    model.setDmContent(dto.getDmContent());
    model.setSlug(dto.getSlug());
    model.setRowOrderId(dto.getRowOrderId());
    model.setTitle(dto.getTitle());
    return model;
  }

  public static SliderDto convertModelToDto(Slider model) {
    SliderDto dto = new SliderDto();
    dto.setId(model.getId());
    dto.setMultiMedia(model.getMultiMedia());
    dto.setType(model.getType());
    if (model.getType().equals(SLDR_TYPE_LINK)) {
      dto.setLink(model.getLink());
    } else if (model.getType().equals(SLDR_TYPE_FILTER)) {
      dto.setSearchOptionsDto(Utility.getSearchOptionsDtoObject(model.getFilter()));
    }
    dto.setStatus(model.getStatus());
    dto.setDmContent(model.getDmContent());
    dto.setSlug(model.getSlug());
    dto.setRowOrderId(model.getRowOrderId());
    dto.setTitle(model.getTitle());
    return dto;
  }

  public static List<SliderDto> convertModelToDto(List<Slider> sliderList) {
    List<SliderDto> sliderDtoList = new ArrayList<>();
    for (Slider slider : sliderList) {
      SliderDto sliderDto = convertModelToDto(slider);
      sliderDtoList.add(sliderDto);
    }
    return sliderDtoList;
  }
}
