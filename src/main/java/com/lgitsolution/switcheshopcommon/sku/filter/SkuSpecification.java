
package com.lgitsolution.switcheshopcommon.sku.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;

import com.lgitsolution.switcheshopcommon.filter.dto.SearchCriteriaDto;
import com.lgitsolution.switcheshopcommon.filter.dto.SearchOperationEnum;
import com.lgitsolution.switcheshopcommon.product.model.Product;
import com.lgitsolution.switcheshopcommon.sku.model.SKU;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class SkuSpecification implements Specification<Object> {

  private final SearchCriteriaDto searchCriteria;

  public SkuSpecification(final SearchCriteriaDto searchCriteria) {
    super();
    this.searchCriteria = searchCriteria;
  }

  @Override
  public Predicate toPredicate(Root<Object> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

    List<Object> value = searchCriteria.getValue();
    List<Predicate> predicateList = new ArrayList<Predicate>();
    Predicate p = null;
    String filterKey = searchCriteria.getFilterKey();

    for (Object searchValueObject : value) {

      String strToSearch = searchValueObject.toString().toLowerCase();
      String operation = searchCriteria.getOperation();

      switch (Objects.requireNonNull(SearchOperationEnum.getSimpleOperation(searchCriteria
              .getOperation()))) {
        case CONTAINS:
          if (filterKey.equals("productIdentificationNo") || filterKey.equals(
                  "specificationData")) {
            p = cb.like(cb.lower(productJoin(root).get(filterKey)), "%" + strToSearch + "%");
            break;
          }
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
          if (filterKey.equals("categoryId") || filterKey.equals("productIdentificationNo")
                  || filterKey.equals("customerType") || filterKey.equals("brandId")) {
            p = cb.equal(productJoin(root).get(filterKey), searchValueObject.toString());
            break;
          }
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
          break;
      }
      predicateList.add(p);
    }

    Predicate[] finalPredicateArray = new Predicate[predicateList.size()];
    predicateList.toArray(finalPredicateArray);
    Predicate finalPredicate = cb.or(finalPredicateArray);
    return finalPredicate;

  }

  /**
   * Create join pn product table
   * 
   * @param root the root
   * @return the root join with product
   */
  private Join<SKU, Product> productJoin(Root<Object> root) {
    return root.join("product");
  }

}
