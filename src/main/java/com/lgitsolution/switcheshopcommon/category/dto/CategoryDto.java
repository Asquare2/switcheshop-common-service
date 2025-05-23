
package com.lgitsolution.switcheshopcommon.category.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDto {

  private Integer id;

  private String name;

  private Integer status;

  private Integer parentId;

  private Integer isParent;

  private String hsnCode;

  /** This is multi media comes from User interface. */
  private Multimedia multiMedia;

  /** The row order number code. */
  private int rowOrderId;

  private int productCount;

  /** For DM purpose */
  private String slug;

  private String dmContent;

  private Integer specificationId = -1;

  private String title;

  private Set<Integer> attributeIds;
  
}
