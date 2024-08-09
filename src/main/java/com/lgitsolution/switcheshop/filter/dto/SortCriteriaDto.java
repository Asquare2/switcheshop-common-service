
package com.lgitsolution.switcheshop.filter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortCriteriaDto {

  private String sortKey;
  private String sortOption;
}
