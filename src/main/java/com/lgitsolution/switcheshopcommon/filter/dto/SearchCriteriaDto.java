
package com.lgitsolution.switcheshopcommon.filter.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaDto {

  private String filterKey;

  /** List of values that is coming from front end. */
  private List<Object> value;

  private String operation;

  private String dataOption;

  /**
   * Value that will use for database search that is nothing but individual value from value list.
   */
  private Object searchValue;

  public SearchCriteriaDto(String filterKey, String operation, List<Object> value) {
    super();
    this.filterKey = filterKey;
    this.operation = operation;
    this.value = value;
  }

}
