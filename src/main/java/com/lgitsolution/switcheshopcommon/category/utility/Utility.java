
package com.lgitsolution.switcheshopcommon.category.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.lgitsolution.switcheshopcommon.category.dto.CategoryDto;
import com.lgitsolution.switcheshopcommon.category.model.Category;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static Category convertDtoToModel(CategoryDto categoryDto) {
    Category category = new Category();
    category.setHsnCode(categoryDto.getHsnCode());
    category.setIsParent(categoryDto.getIsParent());
    category.setMultiMedia(Utility.getMultiMediaJsonString(categoryDto.getMultiMedia()));
    category.setName(categoryDto.getName());
    category.setParentId(categoryDto.getParentId());
    category.setStatus(categoryDto.getStatus());
    category.setRowOrderId(categoryDto.getRowOrderId());
    category.setSlug(categoryDto.getSlug());
    category.setDmContent(categoryDto.getDmContent());
    if (categoryDto.getSpecificationId() > 0) {
      category.setSpecificationId(categoryDto.getSpecificationId());
    }
    category.setAttributeIds(Utility.ConvertObjectToJsonString(categoryDto.getAttributeIds()));
    category.setTitle(categoryDto.getTitle());
    return category;
  }

  public static CategoryDto convertModelToDto(Category category) {
    CategoryDto categoryDto = new CategoryDto();
    categoryDto.setId(category.getId());
    categoryDto.setHsnCode(category.getHsnCode());
    categoryDto.setIsParent(category.getIsParent());
    categoryDto.setMultiMedia(Utility.getMultiMediaObject(category.getMultiMedia()));
    categoryDto.setName(category.getName());
    categoryDto.setParentId(category.getParentId());
    categoryDto.setStatus(category.getStatus());
    categoryDto.setRowOrderId(category.getRowOrderId());
    categoryDto.setSlug(category.getSlug());
    categoryDto.setDmContent(category.getDmContent());
    if (category.getSpecificationId() != null) {
      categoryDto.setSpecificationId(category.getSpecificationId());
    }
    categoryDto.setAttributeIds(Utility.convertJsonToObject(category.getAttributeIds(),
            new HashSet<Integer>()));
    categoryDto.setTitle(category.getTitle());
    return categoryDto;
  }

  public static List<CategoryDto> convertModelToDto(List<Category> categoryList) {
    List<CategoryDto> categoryDtoList = new ArrayList<>();
    for (Category category : categoryList) {
      CategoryDto categoryDto = convertModelToDto(category);
      categoryDtoList.add(categoryDto);
    }
    return categoryDtoList;
  }

}
