
package com.lgitsolution.switcheshopcommon.sku.utility;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import com.lgitsolution.switcheshopcommon.product.model.Product;
import com.lgitsolution.switcheshopcommon.sku.dto.SKUDto;
import com.lgitsolution.switcheshopcommon.sku.model.SKU;


public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility commonUtility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static SKU convertDtoToModel(SKUDto dto) {
    SKU model = new SKU();

    model.setId(dto.getId());
    model.setName(dto.getName());
    model.setMultiMedia(commonUtility.getMultiMediaJsonString(dto.getMultiMedia()));
    model.setStatus(dto.getStatus());
    model.setProduct(new Product(dto.getProductId()));
    model.setQuantity(dto.getQuantity());
    model.setPrice(dto.getPrice());
    model.setSpecialPrice(dto.getSpecialPrice());
    model.setAttributeOptions(dto.getAttributeOptions());
    model.setTitle(dto.getTitle());
    model.setShortDescription(dto.getShortDescription());
    model.setLongDescription(dto.getLongDescription());
    model.setSlug(dto.getSlug());
    model.setDmContent(dto.getDmContent());
    model.setItemId(dto.getItemId());
    model.setSalePrice(dto.getSalePrice());
    model.setDiscountPercentage(dto.getDiscountPercentage());
    return model;
  }

  public static SKUDto convertModelToDto(SKU model) {
    SKUDto skuDto = new SKUDto();
    skuDto.setId(model.getId());
    skuDto.setName(model.getName());
    skuDto.setMultiMedia(commonUtility.getMultiMediaObject(model.getMultiMedia()));
    skuDto.setStatus(model.getStatus());
    if (model.getProduct() != null) {
      skuDto.setProductId(model.getProduct().getId());
      Map<String, String> ratingMap = com.lgitsolution.switcheshopcommon.common.util.Utility
              .convertJsonToObject(model.getProduct().getRatingMap(),
                      new LinkedHashMap<String, String>());
      if (ratingMap != null) {
        skuDto.setAverageRating(getAverageRating(ratingMap));
      }
    }
    skuDto.setQuantity(model.getQuantity());
    skuDto.setPrice(model.getPrice());
    skuDto.setSpecialPrice(model.getSpecialPrice());
    skuDto.setAttributeOptions(model.getAttributeOptions());
    skuDto.setTitle(model.getTitle());
    skuDto.setShortDescription(model.getShortDescription());
    skuDto.setLongDescription(model.getLongDescription());
    skuDto.setSlug(model.getSlug());
    skuDto.setDmContent(model.getDmContent());
    skuDto.setItemId(model.getItemId());
    skuDto.setSalePrice(model.getSalePrice());
    skuDto.setDiscountPercentage(model.getDiscountPercentage());
    return skuDto;
  }

  /**
   * 
   * @param ratingMap
   * @return
   */
  private static Double getAverageRating(Map<String, String> ratingMap) {
    double totalScoreL = 0;
    double totalResponseL = 0;
    double responseL = 0;
    for (String ratingL : ratingMap.keySet()) {
      responseL = Double.parseDouble(ratingMap.get(ratingL));
      totalScoreL += Double.parseDouble(ratingL) * responseL;
      totalResponseL += responseL;
    }
    Double averageRatingL = totalScoreL / totalResponseL;
    DecimalFormat decimalFormat = new DecimalFormat("#.#");
    averageRatingL = Double.parseDouble(decimalFormat.format(averageRatingL));
    return averageRatingL;
  }

}
