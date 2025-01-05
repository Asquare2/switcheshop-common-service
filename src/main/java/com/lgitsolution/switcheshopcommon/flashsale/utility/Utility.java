
package com.lgitsolution.switcheshopcommon.flashsale.utility;

import static com.lgitsolution.switcheshopcommon.common.dto.CommonConstants.ACTIVE_STATUS;

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
    flashSale.setStartDate(Utility.getLocalDate(flashSaleDto.getStartDate()));
    flashSale.setEndDate(Utility.getLocalDate(flashSaleDto.getEndDate()));
    flashSale.setMultiMedia(Utility.getMultiMediaJsonString(flashSaleDto.getMultiMedia()));
    flashSale.setStatus(flashSaleDto.getStatus());
    flashSale.setCreatedAt(Utility.getLocalDate(flashSaleDto.getCreatedAt()));
    flashSale.setModifiedAt(Utility.getLocalDate(flashSaleDto.getModifiedAt()));
    flashSale.setFilter(Utility.getSearchOptionsDtoJsonString(flashSaleDto.getSearchOptionsDto()));
    flashSale.setMaxDiscountAmount(flashSaleDto.getMaxDiscountAmount());
    flashSale.setSlug(flashSaleDto.getSlug());
    flashSale.setDmContent(flashSaleDto.getDmContent());
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
    flashSaleDto.setStartDate(Utility.getLocalDateMillis(flashSale.getStartDate()));
    flashSaleDto.setEndDate(Utility.getLocalDateMillis(flashSale.getEndDate()));
    flashSaleDto.setMultiMedia(Utility.getMultiMediaObject(flashSale.getMultiMedia()));
    flashSaleDto.setStatus(flashSale.getStatus());
    flashSaleDto.setCreatedAt(Utility.getLocalDateMillis(flashSale.getCreatedAt()));
    flashSaleDto.setModifiedAt(Utility.getLocalDateMillis(flashSale.getModifiedAt()));
    flashSaleDto.setSearchOptionsDto(Utility.getSearchOptionsDtoObject(flashSale.getFilter()));
    flashSaleDto.setMaxDiscountAmount(flashSale.getMaxDiscountAmount());
    flashSaleDto.setSlug(flashSale.getSlug());
    flashSaleDto.setDmContent(flashSale.getDmContent());
    return flashSaleDto;
  }

  /**
   * 
   * @param flashSaleList
   * @param checkActiveSale
   * @return
   */
  public static List<FlashSaleDto> convertModelToDto(List<FlashSale> flashSaleList,
          boolean checkActiveSale) {
    List<FlashSaleDto> flashSaleDtoList = new ArrayList<>();
    for (FlashSale flashSale : flashSaleList) {
      FlashSaleDto flashSaleDto = convertModelToDto(flashSale);
        flashSaleDtoList.add(flashSaleDto);
    }
    return flashSaleDtoList;
  }

  /**
   * Check that sale is active or not
   * 
   * @param flashSaleDto
   * @return
   */
  private static boolean isActiveSale(FlashSaleDto flashSaleDto) {
    boolean isActiveSaleL = false;
    Long currentTimeL = System.currentTimeMillis();
    if (flashSaleDto != null && flashSaleDto.getStatus() == ACTIVE_STATUS && flashSaleDto
            .getStartDate() >= currentTimeL && flashSaleDto.getEndDate() <= currentTimeL) {
      isActiveSaleL = true;
    }
    return isActiveSaleL;
  }

}
