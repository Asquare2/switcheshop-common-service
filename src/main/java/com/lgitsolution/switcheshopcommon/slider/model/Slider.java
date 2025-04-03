
package com.lgitsolution.switcheshopcommon.slider.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "slider")
public class Slider {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The type. */
  @Column(name = "type")
  private String type;

  @Column(name = "multi_media")
  private String multiMedia;

  /** The link. */
  @Column(name = "link")
  private String link;

  /** The status. */
  @Column(name = "status")
  private Integer status;

  /** The filter */
  @Column(name = "filter", columnDefinition = "text")
  private String filter;

  @Column(name = "slug")
  private String slug;

  @Column(name = "dm_content", columnDefinition = "text")
  private String dmContent;

  @Column(name = "row_order_id")
  private Integer rowOrderId;

  @Column(name = "title")
  private String title;

  @Column(name = "image_alt_tag")
  private String imageAltTag;

  @Column(name = "mob_multi_media")
  private String mobileMultiMedia;

}
