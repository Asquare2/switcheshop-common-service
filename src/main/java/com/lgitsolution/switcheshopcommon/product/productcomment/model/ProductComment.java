
package com.lgitsolution.switcheshopcommon.product.productcomment.model;

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
@Table(name = "product_comment")
public class ProductComment {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The product ID. */
  @Column(name = "product_id")
  private Integer productId;

  /** The customer details ID. */
  @Column(name = "customer_details_id")
  private Integer customerDetailsId;

  /** The order details ID. */
  @Column(name = "order_detail_id")
  private Integer orderId;

  /** The rating start. */
  @Column(name = "rating_star")
  private Integer ratingStar;

  /** The comment */
  @Column(name = "comment")
  private String comment;

  /** The Is Published. */
  @Column(name = "is_published")
  private Integer isPublished;

  /** The created at. */
  @Column(name = "created_at")
  private LocalDate createdAt;
}
