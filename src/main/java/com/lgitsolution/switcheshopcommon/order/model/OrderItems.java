
package com.lgitsolution.switcheshopcommon.order.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItems {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "order_detail_id")
  private Integer orderDetailId;

  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "order_detail_id")
  // private OrderDetails orderDetails;

  @Column(name = "sku_id")
  private Integer skuId;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "modified_at")
  private LocalDateTime modifiedAt;

}
