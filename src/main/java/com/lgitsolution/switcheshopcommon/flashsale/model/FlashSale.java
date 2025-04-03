
package com.lgitsolution.switcheshopcommon.flashsale.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The FlashSale model class mapped with database.
 */
@Data
@Entity
@Table(name = "flash_sale")
public class FlashSale {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The title. */
  @Column(name = "title")
  private String title;

  /** The description. */
  @Column(name = "description")
  private String description;

  /** The discount. */
  @Column(name = "discount")
  private Double discount;

  /** The start date. */
  @Column(name = "start_date")
  private LocalDate startDate;

  /** The end date. */
  @Column(name = "end_date")
  private LocalDate endDate;

  /** This multi media. */
  @Column(name = "multi_media")
  private String multiMedia;

  /** The status. */
  @Column(name = "status")
  private Integer status;

  /** The created date. */
  @Column(name = "created_at")
  private LocalDate createdAt;

  /** The modified at date. */
  @Column(name = "modified_at")
  private LocalDate modifiedAt;

  /** The filter. */
  @Column(name = "filter")
  private String filter;

  @Column(name = "max_discount_amount")
  private Integer maxDiscountAmount;

  @Column(name = "slug")
  private String slug;

  @Column(name = "dm_content", columnDefinition = "text")
  private String dmContent;

  @Column(name = "image_alt_tag")
  private String imageAltTag;

  @Column(name = "mob_multi_media")
  private String mobileMultiMedia;

}
