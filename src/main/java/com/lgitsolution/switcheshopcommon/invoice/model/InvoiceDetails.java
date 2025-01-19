package com.lgitsolution.switcheshopcommon.invoice.model;

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
@Table(name = "invoice_detail")
public class InvoiceDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "order_detail_id")
  private Integer orderDetailsId;

  @Column(name = "order_item_id")
  private String orderItemId;

  @Column(name = "created_at")
  private LocalDate createdAt;

  @Column(name = "promocode_name")
  private String promocodeName;

  @Column(name = "promocode_discount")
  private Float promocodeDiscount;

  @Column(name = "total_payable")
  private Float totalPayable;

  @Column(name = "invoice_number")
  private String invoiceNumber;

  @Column(name = "invoice_items_detail", columnDefinition = "text")
  private String invoiceItemsDetailList;

  @Column(name = "total_tax")
  private Float taxTotalAmount;

}
