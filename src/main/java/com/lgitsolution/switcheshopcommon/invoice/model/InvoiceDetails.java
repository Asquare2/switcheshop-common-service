
package com.lgitsolution.switcheshopcommon.invoice.model;

import java.time.LocalDate;

import com.lgitsolution.switcheshopcommon.invoice.dto.RefundStatus;

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
@Table(name = "invoice_detail")
public class InvoiceDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "order_detail_id")
  private Integer orderDetailsId;

  @Column(name = "created_at")
  private LocalDate createdAt;

  @Column(name = "total_payable")
  private Float totalPayable;

  @Column(name = "invoice_number")
  private String invoiceNumber;

  @Column(name = "invoice_items_detail", columnDefinition = "text")
  private String invoiceItemsDetailList;

  @Column(name = "total_tax")
  private Float taxTotalAmount;

  @Column(name = "order_item_id")
  private String orderItemId;

  @Column(name = "refund_status")
  @Enumerated(EnumType.STRING)
  private RefundStatus refundStatus = RefundStatus.no;

  @Column(name = "refund_amount")
  private Float refundAmount = 0.0f;

}
