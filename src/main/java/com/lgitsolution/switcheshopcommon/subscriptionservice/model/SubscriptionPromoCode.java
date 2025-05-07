
package com.lgitsolution.switcheshopcommon.subscriptionservice.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "promocode", schema = "public")
public class SubscriptionPromoCode {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The name. */
  @Column(name = "name")
  private String name;

  /** The message. */
  @Column(name = "message")
  private String message;

  /** The flag is reusable. */
  @Column(name = "is_reusable")
  private Integer isReusable;

  /** The total use count. */
  @Column(name = "use_count")
  private Integer useCount;

  /** The multimedia. */
  @Column(name = "multi_media")
  /** This is multi media comes from User interface. */
  private String multiMedia;

  /** The minimum purchase amount. */
  @Column(name = "minimum_purchase_amount")
  private Integer minimumPurchaseAmount;

  /** The discount type. */
  @Column(name = "discount_type")
  private Integer discountType;

  /** The discount. */
  @Column(name = "discount_amount")
  private Double discountAmount;

  /** The status. */
  @Column(name = "status")
  private Integer status;

  /** The created at. */
  @Column(name = "created_at")
  private LocalDate createdAt;

  /** The modified at. */
  @Column(name = "modified_at")
  private LocalDate modifiedAt;

}
