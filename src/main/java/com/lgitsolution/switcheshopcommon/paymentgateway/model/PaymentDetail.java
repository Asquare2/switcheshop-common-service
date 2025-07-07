
package com.lgitsolution.switcheshopcommon.paymentgateway.model;

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
@Table(name = "payment_detail")
public class PaymentDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "order_detail_id")
  private Integer orderDetailId;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "provider")
  private String provider;

  @Column(name = "sp_status")
  private String spStatus;

  @Column(name = "created_at")
  private LocalDate createdAt;

  @Column(name = "modified_at")
  private LocalDate modifiedAt;

  @Column(name = "sp_order_id")
  private String spOrderId;

  @Column(name = "payment_session_id")
  private String paymentSessionId;

  @Column(name = "create_order_response")
  private String createdOrderResponse;

  /** The transactions for an order. */
  @Column(name = "order_payments_response")
  private String orderPaymentsResponse;

  @Column(name = "status")
  private Integer status;

  @Column(name = "order_item_id")
  private String orderItemId;

  @Column(name = "payment_method")
  private String paymentMethod;

}
