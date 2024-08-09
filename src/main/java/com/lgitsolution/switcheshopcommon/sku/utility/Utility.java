
package com.lgitsolution.switcheshopcommon.sku.utility;

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
    return skuDto;
  }
}
