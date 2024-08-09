
package com.lgitsolution.switcheshop.order.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetails {

  public OrderDetails() {
  }

  public OrderDetails(Integer id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "customer_details_id")
  private Integer customerDetailsId;

  @Column(name = "total_amout")
  private Float totalAmount;

  @Column(name = "total_payable")
  private Float totalPayable;

  @Column(name = "status")
  private Integer status;

  @Column(name = "order_notes")
  private String orderNotes;

  @Column(name = "delivery_charge")
  private Float deliveryCharge;

  @Column(name = "wallet_used")
  private Float walletUsed;

  @Column(name = "promocode_name")
  private String promocodeName;

  @Column(name = "promocode_discount")
  private Float promocodeDiscount;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "modified_at")
  private LocalDateTime modifiedAt;

  @Column(name = "delivery_partner_response")
  private String deliveryPartnerResponse;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "order_detail_id", referencedColumnName = "id")
  private List<OrderItems> orderItemsList = new ArrayList<>();

}
