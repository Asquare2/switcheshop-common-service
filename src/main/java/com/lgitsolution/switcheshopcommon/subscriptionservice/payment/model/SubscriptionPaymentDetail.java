
package com.lgitsolution.switcheshopcommon.subscriptionservice.payment.model;

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
@Table(name = "subscription_payment_detail", schema = "public")
public class SubscriptionPaymentDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "subscription_id")
  private Integer subscriptionId;

  @Column(name = "client_id")
  private Integer clientId;

  @Column(name = "amount")
  private Float amount;

  @Column(name = "provider")
  private String provider;

  @Column(name = "currency")
  private String currency;

  @Column(name = "payment_session_id")
  private String paymentSessionId;

  @Column(name = "sp_order_id")
  private String spOrderId;

  @Column(name = "sp_status")
  private String spStatus;

  @Column(name = "status")
  private String status;

  @Column(name = "payment_method")
  private String paymentMethod;

  @Column(name = "create_order_response")
  private String createdOrderResponse;

  /** The transactions for an order. */
  @Column(name = "order_payments_response")
  private String orderPaymentsResponse;

  @Column(name = "created_at")
  private LocalDate createdAt;

  @Column(name = "modified_at")
  private LocalDate modifiedAt;

}
