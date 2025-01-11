
package com.lgitsolution.switcheshopcommon.category.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The Class Category.
 */
@Data
@Entity
@Table(name = "product_category")
public class Category {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The name. */
  @Column(name = "name")
  private String name;

  @Column(name = "multi_media")
  private String multiMedia;

  /** The status. */
  @Column(name = "status")
  private Integer status;

  /** The parent id. */
  @Column(name = "parent_id")
  private Integer parentId;

  /** The is parent. */
  @Column(name = "is_parent")
  private Integer isParent;

  /** The hsn code. */
  @Column(name = "hsn_code")
  private String hsnCode;

  /** The row order number code. */
  @Column(name = "row_order_id")
  private int rowOrderId;

  @Column(name = "slug")
  private String slug;

  @Column(name = "dm_content", columnDefinition = "text")
  private String dmContent;

  @Column(name = "specification_id")
  private Integer specificationId = null;

  @Column(name = "title")
  private String title;

  @Column(name = "attribute_ids", columnDefinition = "text")
  private String attributeIds;

}
