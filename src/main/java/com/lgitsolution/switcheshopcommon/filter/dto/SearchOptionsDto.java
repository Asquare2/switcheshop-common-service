
package com.lgitsolution.switcheshopcommon.filter.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchOptionsDto {

  private List<SearchCriteriaDto> searchCriteriaList;
  private String dataOption;
  private SortCriteriaDto sortCriteriaDto;
  private int countRequired = 0;
}
