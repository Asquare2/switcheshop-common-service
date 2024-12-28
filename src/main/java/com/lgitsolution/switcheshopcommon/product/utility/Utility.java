
package com.lgitsolution.switcheshopcommon.product.utility;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lgitsolution.switcheshopcommon.product.dto.ProductDto;
import com.lgitsolution.switcheshopcommon.product.model.Product;
import com.lgitsolution.switcheshopcommon.sku.dto.SKUDto;
import com.lgitsolution.switcheshopcommon.sku.model.SKU;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static Product convertDtoToModel(ProductDto dto) {
    Product model = new Product();
    model.setId(dto.getId());
    model.setProductIdentificationNo(dto.getIdentificationNo());
    model.setTitle(dto.getTitle());
    model.setShortDescription(dto.getShortDescription());
    model.setLongDescription(dto.getLongDescription());
    model.setMadeIn(dto.getMadeIn());
    model.setType(dto.getType());
    model.setTag(dto.getTag());
    model.setTaxIncluded(dto.getTaxIncluded());
    model.setCustomerType(dto.getCustomerType());
    model.setCategoryId(dto.getCategoryId());
    model.setBrandId(dto.getBrandId());
    model.setMultimedia(Utility.getMultiMediaJsonString(dto.getMultiMedia()));
    model.setMinimumOrderQuantity(dto.getMinimumOrderQuantity());
    model.setMaximumOrderQuantity(dto.getMaximumOrderQuantity());
    model.setQuantityStepSize(dto.getQuantityStepSize());
    model.setWarrantyPeriod(dto.getWarrantyPeriod());
    model.setGuaranteePeriod(dto.getGuaranteePeriod());
    model.setDeliveryType(dto.getDeliveryType());
    model.setCodAllowed(dto.getCodAllowed());
    model.setCancelable(dto.getCancelable());
    model.setReturnable(dto.getReturnable());
    model.setAttachmentRequired(dto.getAttachmentRequired());
    model.setPickupLocation(dto.getPickupLocationId());
    model.setTaxId(dto.getTaxId());
    List<SKUDto> skuList = dto.getSkuList();
    skuList.stream().forEach(o -> {
      model.getSkuList().add(com.lgitsolution.switcheshopcommon.sku.utility.Utility
              .convertDtoToModel(o));
    });
    model.setModifiedBy(dto.getModifiedBy());
    model.setStatus(dto.getStatus());
    model.setCreatedAt(Utility.getLocalDateTime(dto.getCreatedAt()));
    model.setModifiedAt(Utility.getLocalDateTime(dto.getModifiedAt()));
    model.setDeliverableZipCode(dto.getDeliverableZipCode());
    model.setVideoType(dto.getVideoType());
    model.setProductType(dto.getProductType());
    model.setDisplaySkuOnAttributeId(dto.getDisplaySkuOnAttributeId());
    model.setIsDisplaySkuWise(dto.getIsDisplaySkuWise());
    model.setSpecificationData(dto.getSpecificationData());
    model.setSlug(dto.getSlug());
    model.setDmContent(dto.getDmContent());
    model.setItemId(dto.getItemId());
    model.setFaq(com.lgitsolution.switcheshopcommon.common.util.Utility.convertMapToJsonString(dto
            .getFaq()));
    model.setRatingMap(com.lgitsolution.switcheshopcommon.common.util.Utility
            .ConvertObjectToJsonString(dto.getRatingMap()));
    return model;
  }

  public static ProductDto convertModelToDto(Product model) {
    ProductDto dto = new ProductDto();
    dto.setId(model.getId());
    dto.setIdentificationNo(model.getProductIdentificationNo());
    dto.setTitle(model.getTitle());
    dto.setShortDescription(model.getShortDescription());
    dto.setLongDescription(model.getLongDescription());
    dto.setMadeIn(model.getMadeIn());
    dto.setType(model.getType());
    dto.setTag(model.getTag());
    dto.setTaxIncluded(model.getTaxIncluded());
    dto.setCustomerType(model.getCustomerType());
    dto.setCategoryId(model.getCategoryId());
    dto.setBrandId(model.getBrandId());
    dto.setMultiMedia(Utility.getMultiMediaObject(model.getMultimedia()));
    dto.setMinimumOrderQuantity(model.getMinimumOrderQuantity());
    dto.setMaximumOrderQuantity(model.getMaximumOrderQuantity());
    dto.setQuantityStepSize(model.getQuantityStepSize());
    dto.setWarrantyPeriod(model.getWarrantyPeriod());
    dto.setGuaranteePeriod(model.getGuaranteePeriod());
    dto.setDeliveryType(model.getDeliveryType());
    dto.setCodAllowed(model.getCodAllowed());
    dto.setCancelable(model.getCancelable());
    dto.setReturnable(model.getReturnable());
    dto.setAttachmentRequired(model.getAttachmentRequired());
    dto.setTaxId(model.getTaxId());
    dto.setPickupLocationId(model.getPickupLocation());
    List<SKU> skuList = model.getSkuList();
    if (skuList != null && !skuList.isEmpty()) {
      skuList.stream().forEach(o -> {
        dto.getSkuList().add(com.lgitsolution.switcheshopcommon.sku.utility.Utility
                .convertModelToDto(o, null));

      });
    }
    dto.setModifiedBy(model.getModifiedBy());
    dto.setStatus(model.getStatus());
    dto.setCreatedAt(Utility.getLocalDateTimeMillis(model.getCreatedAt()));
    dto.setModifiedAt(Utility.getLocalDateTimeMillis(model.getModifiedAt()));
    dto.setDeliverableZipCode(model.getDeliverableZipCode());
    dto.setVideoType(model.getVideoType());
    dto.setProductType(model.getProductType());
    dto.setDisplaySkuOnAttributeId(model.getDisplaySkuOnAttributeId());
    dto.setIsDisplaySkuWise(model.getIsDisplaySkuWise());
    dto.setSpecificationData(model.getSpecificationData());
    dto.setSlug(model.getSlug());
    dto.setDmContent(model.getDmContent());
    dto.setItemId(model.getItemId());
    dto.setFaq(com.lgitsolution.switcheshopcommon.common.util.Utility.convertJsonStringToMap(model
            .getFaq()));
    dto.setRatingMap(com.lgitsolution.switcheshopcommon.common.util.Utility.convertJsonToObject(
            model.getRatingMap(), new LinkedHashMap<String, String>()));
    dto.setAverageRating(getAverageRating(dto.getRatingMap()));
    return dto;
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
