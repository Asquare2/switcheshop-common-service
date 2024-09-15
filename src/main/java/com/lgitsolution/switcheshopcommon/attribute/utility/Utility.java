
package com.lgitsolution.switcheshopcommon.attribute.utility;

import java.util.List;

import com.lgitsolution.switcheshopcommon.attribute.dto.AttributeDto;
import com.lgitsolution.switcheshopcommon.attribute.dto.AttributeOptionDto;
import com.lgitsolution.switcheshopcommon.attribute.model.Attribute;
import com.lgitsolution.switcheshopcommon.attribute.model.AttributeOption;



public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static Attribute convertDtoToModel(AttributeDto attributeDto) {
    Attribute attribute = new Attribute();
    attribute.setId(attributeDto.getId());
    attribute.setDisplayName(attributeDto.getDisplayName());
    attribute.setName(attributeDto.getName());
    attribute.setStatus(attributeDto.getStatus());
    List<AttributeOptionDto> attributeOptionList = attributeDto.getAttributeOptionList();
    if (attributeOptionList != null && !attributeOptionList.isEmpty()) {
      attributeOptionList.stream().forEach((o) -> attribute.getAttributeOptionList().add(
              convertDtoToModel(o)));
    }
    return attribute;
  }

  public static AttributeOption convertDtoToModel(AttributeOptionDto attributeOptionDto) {
    AttributeOption attributeOption = new AttributeOption();
    attributeOption.setId(attributeOptionDto.getId());
    attributeOption.setAttributeId(attributeOptionDto.getAttributeId());
    attributeOption.setValue(attributeOptionDto.getValue());
    attributeOption.setValueTag(attributeOptionDto.getValueTag());
    attributeOption.setAttributeId(attributeOptionDto.getAttributeId());
    attributeOption.setStatus(attributeOptionDto.getStatus());
    attributeOption.setAttributeName(attributeOptionDto.getAttributeName());
    attributeOption.setColorCode(attributeOptionDto.getColorCode());
    attributeOption.setMultiMedia(Utility.getMultiMediaJsonString(attributeOptionDto
            .getMultiMedia()));
    return attributeOption;
  }

  public static AttributeDto convertModelToDto(Attribute attribute) {
    AttributeDto attributeDto = new AttributeDto();
    attributeDto.setId(attribute.getId());
    attributeDto.setDisplayName(attribute.getDisplayName());
    attributeDto.setName(attribute.getName());
    attributeDto.setStatus(attribute.getStatus());
    List<AttributeOption> attributeOptionList = attribute.getAttributeOptionList();
    if (attributeOptionList != null && !attributeOptionList.isEmpty()) {
      attributeOptionList.stream().forEach((o) -> attributeDto.getAttributeOptionList().add(
              convertModelToDto(o)));
    }
    return attributeDto;
  }

  public static AttributeOptionDto convertModelToDto(AttributeOption attributeOption) {
    AttributeOptionDto attributeOptionDto = new AttributeOptionDto();
    attributeOptionDto.setId(attributeOption.getId());
    attributeOptionDto.setAttributeId(attributeOption.getAttributeId());
    attributeOptionDto.setValue(attributeOption.getValue());
    attributeOptionDto.setValueTag(attributeOption.getValueTag());
    attributeOptionDto.setAttributeId(attributeOption.getAttributeId());
    attributeOptionDto.setStatus(attributeOption.getStatus());
    attributeOptionDto.setAttributeName(attributeOption.getAttributeName());
    attributeOptionDto.setAttributeName(attributeOption.getAttributeName());
    attributeOptionDto.setColorCode(attributeOption.getColorCode());
    attributeOptionDto.setMultiMedia(Utility.getMultiMediaObject(attributeOption.getMultiMedia()));
    return attributeOptionDto;
  }
}
