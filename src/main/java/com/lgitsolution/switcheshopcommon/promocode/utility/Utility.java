
package com.lgitsolution.switcheshopcommon.promocode.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.promocode.dto.PromocodeDto;
import com.lgitsolution.switcheshopcommon.promocode.model.Promocode;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  /**
   * Converts the dto object to model object.
   * 
   * @param promocodeDto the promocode dto object
   * @return the promocode model object
   */
  public static Promocode convertDtoToModel(PromocodeDto promocodeDto) {
    Promocode promocode = new Promocode();
    promocode.setName(promocodeDto.getName());
    promocode.setMessage(promocodeDto.getMessage());
    promocode.setIsReusable(promocodeDto.getIsReusable());
    promocode.setUseCount(promocodeDto.getUseCount());
    promocode.setMultiMedia(Utility.getMultiMediaJsonString(promocodeDto.getMultiMedia()));
    promocode.setMinimumPurchaseAmount(promocodeDto.getMinimumPurchaseAmount());
    promocode.setDiscountType(promocodeDto.getDiscountType());
    promocode.setDiscountAmount(promocodeDto.getDiscountAmount());
    promocode.setStatus(promocodeDto.getStatus());
    promocode.setCreatedAt(Utility.getLocalDateTime(promocodeDto.getCreatedAt()));
    promocode.setModifiedAt(Utility.getLocalDateTime(promocodeDto.getModifiedAt()));
    return promocode;
  }

  /**
   * Converts the model to dto object.
   * 
   * @param promocode the promocode model class object
   * @return the promocode dto class object
   */
  public static PromocodeDto convertModelToDto(Promocode promocode) {
    PromocodeDto promocodeDto = new PromocodeDto();
    promocodeDto.setId(promocode.getId());
    promocodeDto.setName(promocode.getName());
    promocodeDto.setMessage(promocode.getMessage());
    promocodeDto.setIsReusable(promocode.getIsReusable());
    promocodeDto.setUseCount(promocode.getUseCount());
    promocodeDto.setMultiMedia(Utility.getMultiMediaObject(promocode.getMultiMedia()));
    promocodeDto.setMinimumPurchaseAmount(promocode.getMinimumPurchaseAmount());
    promocodeDto.setDiscountType(promocode.getDiscountType());
    promocodeDto.setDiscountAmount(promocode.getDiscountAmount());
    promocodeDto.setStatus(promocode.getStatus());
    promocodeDto.setCreatedAt(Utility.getLocalDateTimeMillis(promocode.getCreatedAt()));
    promocodeDto.setModifiedAt(Utility.getLocalDateTimeMillis(promocode.getModifiedAt()));
    return promocodeDto;
  }

  /**
   * Converts the list of promocode model object to list of promocode dto object.
   * 
   * @param promocodeList the list of promocode model object
   * @return the list of promocode dto object
   */
  public static List<PromocodeDto> convertModelToDto(List<Promocode> promocodeList) {
    List<PromocodeDto> promocodeDtoList = new ArrayList<>();
    for (Promocode promocode : promocodeList) {
      PromocodeDto promocodeDto = convertModelToDto(promocode);
      promocodeDtoList.add(promocodeDto);
    }
    return promocodeDtoList;
  }

  /*
   * public static Specification<Promocode> getSpecification(SearchOptionsDto searchOptionsDto) {
   * PromocodeSpecificationBuilder builder = new PromocodeSpecificationBuilder();
   * List<SearchCriteriaDto> criteriaList = searchOptionsDto.getSearchCriteriaList(); if
   * (criteriaList != null) { criteriaList.forEach(x -> { List<Object> values = x.getValue();
   * values.forEach(y -> { SearchCriteriaDto dto = new SearchCriteriaDto();
   * dto.setFilterKey(x.getFilterKey()); dto.setDataOption(searchOptionsDto.getDataOption());
   * dto.setSearchValue(y); dto.setOperation(x.getOperation()); builder.with(dto); }); }); } return
   * builder.build(); }
   */

}
