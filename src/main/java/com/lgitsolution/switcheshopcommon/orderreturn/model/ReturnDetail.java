package com.lgitsolution.switcheshopcommon.orderreturn.model;

import java.time.LocalDate;

import com.lgitsolution.switcheshopcommon.orderreturn.dto.RefundMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

  @Column(name = "approved_amount")
  private Float totalApprovedAmount;

  @Column(name = "reject_return_reason", columnDefinition = "text")
  private String rejectReturnReason;

  @Column(name = "return_order_que_ans", columnDefinition = "text")
  private String returnOrderQuestionAnswerDto;

  @Column(name = "order_id_no")
  private String orderIdentificationNo;

  @Column(name = "sku_name")
  private String skuName;

  @Column(name = "requested_sku_name")
  private String requestedSkuName;

  @Column(name = "requested_sku_id")
  private Integer requestedSkuId;

  @Column(name = "displayed_tracking_data")
  private String displayedTrackingData;
  
  @Column(name = "refund_mode")
  @Enumerated(EnumType.STRING)
  private RefundMode refundMode;

}
