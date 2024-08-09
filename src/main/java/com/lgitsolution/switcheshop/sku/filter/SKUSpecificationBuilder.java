
package com.lgitsolution.switcheshop.sku.filter;

import org.springframework.data.jpa.domain.Specification;

import com.lgitsolution.switcheshop.filter.BaseSpecificationBuilder;
import com.lgitsolution.switcheshop.filter.dto.SearchCriteriaDto;
import com.lgitsolution.switcheshop.filter.dto.SearchOperationEnum;
import com.lgitsolution.switcheshop.sku.model.SKU;

public class SKUSpecificationBuilder extends BaseSpecificationBuilder<SKU> {

  public SKUSpecificationBuilder() {
    super();
  }

  @Override
  public Specification<Object> build() {
    if (params.size() == 0) {
      return null;
    }
    Specification<Object> result = new SkuSpecification(params.get(0));
    for (int index = 1; index < params.size(); index++) {
      SearchCriteriaDto criteria = params.get(index);
      result = SearchOperationEnum.getDataOption(criteria
              .getDataOption()) == SearchOperationEnum.ALL ? Specification.where(result).and(
                      new SkuSpecification(criteria)) : Specification.where(result).or(
                              new SkuSpecification(criteria));
    }
    return result;
  }

}
