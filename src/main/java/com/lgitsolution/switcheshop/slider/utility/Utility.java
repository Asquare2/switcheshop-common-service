
package com.lgitsolution.switcheshop.slider.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshop.slider.dto.SliderDto;
import com.lgitsolution.switcheshop.slider.model.Slider;

public class Utility {

  private static com.lgitsolution.switcheshop.common.util.Utility Utility =
          new com.lgitsolution.switcheshop.common.util.Utility();

  public static Slider convertDtoToModel(SliderDto dto) {
    Slider model = new Slider();
    model.setMultiMedia(Utility.getMultiMediaJsonString(dto.getMultiMedia()));
    model.setId(dto.getId());
    model.setType(dto.getType());
    model.setTypeOption(dto.getTypeOption());
    model.setLink(dto.getLink());
    model.setStatus(dto.getStatus());
    model.setFilter(Utility.getSearchOptionsDtoJsonString(dto.getSearchOptionsDto()));
    model.setDmContent(dto.getDmContent());
    model.setSlug(dto.getSlug());
    model.setRowOrderId(dto.getRowOrderId());
    return model;
  }

  public static SliderDto convertModelToDto(Slider model) {
    SliderDto dto = new SliderDto();
    dto.setId(model.getId());
    dto.setMultiMedia(Utility.getMultiMediaObject(model.getMultiMedia()));
    dto.setType(model.getType());
    dto.setTypeOption(model.getTypeOption());
    dto.setLink(model.getLink());
    dto.setStatus(model.getStatus());
    dto.setSearchOptionsDto(Utility.getSearchOptionsDtoObject(model.getFilter()));
    dto.setDmContent(model.getDmContent());
    dto.setSlug(model.getSlug());
    dto.setRowOrderId(model.getRowOrderId());
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
