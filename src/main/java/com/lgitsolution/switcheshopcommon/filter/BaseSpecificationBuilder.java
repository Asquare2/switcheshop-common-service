
package com.lgitsolution.switcheshopcommon.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.lgitsolution.switcheshopcommon.filter.dto.SearchCriteriaDto;
import com.lgitsolution.switcheshopcommon.filter.dto.SearchOperationEnum;

public class BaseSpecificationBuilder<T> {

  protected List<SearchCriteriaDto> params;

  public BaseSpecificationBuilder() {
    params = new ArrayList<SearchCriteriaDto>();
  }

  public BaseSpecificationBuilder with(SearchCriteriaDto searchCriteria) {
    params.add(searchCriteria);
    return this;
  }

  public BaseSpecificationBuilder with(String key, String operation, List<Object> value) {
    params.add(new SearchCriteriaDto(key, operation, value));
    return this;
  }

  public Specification<Object> build() {
    if (params.size() == 0) {
      return null;
    }

    Specification<Object> result = new BaseSpecification(params.get(0));

    for (int index = 1; index < params.size(); index++) {
      SearchCriteriaDto criteria = params.get(index);

      result = SearchOperationEnum.getDataOption(criteria
              .getDataOption()) == SearchOperationEnum.ALL ? Specification.where(result).and(
                      new BaseSpecification(criteria)) : Specification.where(result).or(
                              new BaseSpecification(criteria));
    }
    return result;
  }
}
