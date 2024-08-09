
package com.lgitsolution.switcheshop.specification.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecificationDto {

  private Integer id;

  private Map<String, List<String>> specificationData;

  private String name;

  private List<Integer> associatedCategories;

}
