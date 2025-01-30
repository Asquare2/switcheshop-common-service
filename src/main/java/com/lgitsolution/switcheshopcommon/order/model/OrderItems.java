
package com.lgitsolution.switcheshopcommon.order.model;

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

  @Column(name = "identification_no")
  private String identificationNumber;

  @Column(name = "name")
  private String skuName;

  @Column(name = "title")
  private String title;

  @Column(name = "price")
  private Float originalPrice;

  @Column(name = "selling_price")
  private Float sellingPrice;

  @Column(name = "sale_id")
  private Integer saleId;

  /** The hsn code. */
  @Column(name = "hsn_code")
  private String hsnCode;

}
