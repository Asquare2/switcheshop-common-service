
package com.lgitsolution.switcheshop.filter;

import org.springframework.data.jpa.domain.Specification;

import com.lgitsolution.switcheshop.filter.dto.SearchCriteriaDto;
import com.lgitsolution.switcheshop.filter.utility.Utility;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class BaseSpecification implements Specification<Object> {

  private final SearchCriteriaDto searchCriteria;

  public BaseSpecification(final SearchCriteriaDto searchCriteria) {
    super();
    this.searchCriteria = searchCriteria;
  }

  @Override
  public Predicate toPredicate(Root<Object> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
    return Utility.getCommonPredicate(root, query, cb, searchCriteria);
  }
}
