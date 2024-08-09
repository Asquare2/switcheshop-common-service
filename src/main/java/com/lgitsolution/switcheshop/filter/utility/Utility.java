
package com.lgitsolution.switcheshop.filter.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.lgitsolution.switcheshop.filter.BaseSpecificationBuilder;
import com.lgitsolution.switcheshop.filter.dto.SearchCriteriaDto;
import com.lgitsolution.switcheshop.filter.dto.SearchOperationEnum;
import com.lgitsolution.switcheshop.filter.dto.SearchOptionsDto;
import com.lgitsolution.switcheshop.filter.dto.SortCriteriaDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class Utility {

  public static Predicate getCommonPredicate(Root<?> root, CriteriaQuery<?> query,
          CriteriaBuilder cb, SearchCriteriaDto searchCriteria) {

    List<Object> value = searchCriteria.getValue();
    List<Predicate> predicateList = new ArrayList<Predicate>();
    Predicate p = null;
    String filterKey = searchCriteria.getFilterKey();

    for (Object searchValueObject : value) {
      String strToSearch = searchValueObject.toString().toLowerCase();
      String operation = searchCriteria.getOperation();

      switch (Objects.requireNonNull(SearchOperationEnum.getSimpleOperation(operation))) {
        case CONTAINS:
          p = cb.like(cb.lower(root.get(filterKey)), "%" + strToSearch + "%");
          break;
        case DOES_NOT_CONTAIN:
          p = cb.notLike(cb.lower(root.get(filterKey)), "%" + strToSearch + "%");
          break;
        case BEGINS_WITH:
          p = cb.like(cb.lower(root.get(filterKey)), strToSearch + "%");
          break;
        case DOES_NOT_BEGIN_WITH:
          p = cb.notLike(cb.lower(root.get(filterKey)), strToSearch + "%");
          break;
        case EQUAL:
          p = cb.equal(root.get(filterKey), searchValueObject.toString());
          break;
        case NOT_EQUAL:
          p = cb.notEqual(root.get(filterKey), searchValueObject);
          break;
        case ENDS_WITH:
          p = cb.like(cb.lower(root.get(filterKey)), "%" + strToSearch);
          break;
        case DOES_NOT_END_WITH:
          p = cb.notLike(cb.lower(root.get(filterKey)), "%" + strToSearch);
          break;
        case GREATER_THAN:
          p = cb.greaterThan(root.<String>get(filterKey), searchValueObject.toString());
          break;
        case GREATER_THAN_EQUAL:
          p = cb.greaterThanOrEqualTo(root.<String>get(filterKey), searchValueObject.toString());
          break;
        case LESS_THAN:
          p = cb.lessThan(root.<String>get(filterKey), searchValueObject.toString());
          break;
        case LESS_THAN_EQUAL:
          p = cb.lessThanOrEqualTo(root.<String>get(filterKey), searchValueObject.toString());
      }
      predicateList.add(p);
    }
    Predicate[] finalPredicateArray = new Predicate[predicateList.size()];
    predicateList.toArray(finalPredicateArray);
    Predicate finalPredicate = cb.or(finalPredicateArray);
    return finalPredicate;
  }

  public static Sort getSortedCriteria(SortCriteriaDto sortCriteriaDto) {
    Sort sort = null;
    if (sortCriteriaDto.getSortOption().equals("asc")) {
      sort = Sort.by(sortCriteriaDto.getSortKey()).ascending();
    } else {
      sort = Sort.by(sortCriteriaDto.getSortKey()).descending();
    }
    return sort;
  }

  public static Specification getSpecification(SearchOptionsDto searchOptionsDto,
          BaseSpecificationBuilder builder) {
    List<SearchCriteriaDto> criteriaList = searchOptionsDto.getSearchCriteriaList();
    if (criteriaList != null) {
      criteriaList.forEach(x -> {
        x.setDataOption(searchOptionsDto.getDataOption());
        builder.with(x);
      });
    }
    return builder.build();
  }

}
