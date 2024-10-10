
package com.lgitsolution.switcheshopcommon.flashsale.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.flashsale.dto.FlashSaleDto;
import com.lgitsolution.switcheshopcommon.flashsale.model.FlashSale;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  /**
   * 
   * @param flashSaleDtoDto
   * @return
   */
  public static FlashSale convertDtoToModel(FlashSaleDto flashSaleDto) {
    FlashSale flashSale = new FlashSale();
    flashSale.setTitle(flashSaleDto.getTitle());
    flashSale.setDescription(flashSaleDto.getDescription());
    flashSale.setDiscount(flashSaleDto.getDiscount());
    flashSale.setStartDate(Utility.getLocalDateTime(flashSaleDto.getStartDate()));
    flashSale.setEndDate(Utility.getLocalDateTime(flashSaleDto.getEndDate()));
    flashSale.setMultiMedia(Utility.getMultiMediaJsonString(flashSaleDto.getMultiMedia()));
    flashSale.setStatus(flashSaleDto.getStatus());
    flashSale.setCreatedAt(Utility.getLocalDateTime(flashSaleDto.getCreatedAt()));
    flashSale.setModifiedAt(Utility.getLocalDateTime(flashSaleDto.getModifiedAt()));
    flashSale.setFilter(Utility.getSearchOptionsDtoJsonString(flashSaleDto.getSearchOptionsDto()));
    flashSale.setMaxDiscountAmount(flashSaleDto.getMaxDiscountAmount());
    return flashSale;
  }

  /**
   * Converts the model to dto object.
   * 
   * @param flashSale the flash sale object
   * @return the dto object
   */
  public static FlashSaleDto convertModelToDto(FlashSale flashSale) {
    FlashSaleDto flashSaleDto = new FlashSaleDto();
    flashSaleDto.setId(flashSale.getId());
    flashSaleDto.setTitle(flashSale.getTitle());
    flashSaleDto.setDescription(flashSale.getDescription());
    flashSaleDto.setDiscount(flashSale.getDiscount());
    flashSaleDto.setStartDate(Utility.getLocalDateTimeMillis(flashSale.getStartDate()));
    flashSaleDto.setEndDate(Utility.getLocalDateTimeMillis(flashSale.getEndDate()));
    flashSaleDto.setMultiMedia(Utility.getMultiMediaObject(flashSale.getMultiMedia()));
    flashSaleDto.setStatus(flashSale.getStatus());
    flashSaleDto.setCreatedAt(Utility.getLocalDateTimeMillis(flashSale.getCreatedAt()));
    flashSaleDto.setModifiedAt(Utility.getLocalDateTimeMillis(flashSale.getModifiedAt()));
    flashSaleDto.setSearchOptionsDto(Utility.getSearchOptionsDtoObject(flashSale.getFilter()));
    flashSaleDto.setMaxDiscountAmount(flashSale.getMaxDiscountAmount());
    return flashSaleDto;
  }

  /**
   * 
   * @param flashSaleList
   * @return
   */
  public static List<FlashSaleDto> convertModelToDto(List<FlashSale> flashSaleList) {
    List<FlashSaleDto> flashSaleDtoList = new ArrayList<>();
    for (FlashSale flashSale : flashSaleList) {
      FlashSaleDto flashSaleDto = convertModelToDto(flashSale);
      flashSaleDtoList.add(flashSaleDto);
    }
    return flashSaleDtoList;
  }

}
