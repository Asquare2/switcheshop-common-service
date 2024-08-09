
package com.lgitsolution.switcheshopcommon.specification.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.specification.dto.SpecificationDto;
import com.lgitsolution.switcheshopcommon.specification.model.Specification;


public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility commonUtility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  /**
   * 
   * @param dto
   * @return
   */
  public static Specification convertDtoToModel(SpecificationDto dto) {
    Specification specification = new Specification();
    specification.setName(dto.getName());
    specification.setSpecificationData(commonUtility.convertMapOfListToJsonString(dto
            .getSpecificationData()));
    return specification;
  }

  /**
   * 
   * @param specification
   * @return
   */
  public static SpecificationDto convertModelToDto(Specification specification) {
    SpecificationDto dto = new SpecificationDto();
    dto.setId(specification.getId());
    dto.setName(specification.getName());
    dto.setSpecificationData(commonUtility.convertJsonStringToMapOfList(specification
            .getSpecificationData()));
    return dto;
  }

  /**
   * 
   * @param speificationList
   * @return
   */
  public static List<SpecificationDto> convertModelToDto(List<Specification> speificationList) {
    List<SpecificationDto> dtoList = new ArrayList<>();
    speificationList.forEach(specification -> dtoList.add(convertModelToDto(specification)));
    return dtoList;
  }

}
