package com.lgitsolution.switcheshopcommon.orderreturn.model;

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
@Table(name = "return_detail")
public class ReturnDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "order_id")
  private Integer orderId;

  @Column(name = "order_item_id")
  private Integer orderItemId;

  @Column(name = "replace_order_id")
  private Integer replaceOrderId;

  @Column(name = "payment_id")
  private Integer paymentId;

  @Column(name = "status")
  private Integer status;

  @Column(name = "reason", columnDefinition = "text")
  private String reason;

  @Column(name = "requested_for")
  private Integer requestedFor;

  @Column(name = "payment_status")
  private Integer paymentStatus;

  @Column(name = "item_id")
  private String itemId;

  @Column(name = "delivery_partner_response", columnDefinition = "text")
  private String deliveryPartnerResponse;

  @Column(name = "tracking_data", columnDefinition = "text")
  private String trackingData;

  @Column(name = "pickup_scheduled_date")
  private LocalDate pickupScheduledDate;

  @Column(name = "shipment_id")
  private String shipmentId;

  @Column(name = "awb_code")
  private String awbCode;

  @Column(name = "courier_company_id")
  private String courierCompanyId;

  @Column(name = "courier_name")
  private String courierName;

  @Column(name = "created_at")
  private LocalDate createdAt;
}
