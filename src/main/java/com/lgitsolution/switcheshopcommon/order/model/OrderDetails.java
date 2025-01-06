
package com.lgitsolution.switcheshopcommon.order.model;

import java.time.LocalDate;
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

  @Column(name = "total_amount")
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
  private LocalDate createdAt;

  @Column(name = "modified_at")
  private LocalDate modifiedAt;

  @Column(name = "delivery_partner_response", columnDefinition = "text")
  private String deliveryPartnerResponse;

  @Column(name = "package_dimensions")
  private String packageDimensions;

  @Column(name = "item_id")
  private String itemId;

  @Column(name = "tracking_data", columnDefinition = "text")
  private String trackingData;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "order_detail_id", referencedColumnName = "id")
  private List<OrderItems> orderItemsList = new ArrayList<>();

  @Column(name = "payment_method")
  private String paymenMethod;

  @Column(name = "address", columnDefinition = "text")
  private String address;

  @Column(name = "pickup_scheduled_date")
  private LocalDate pickupScheduledDate;

  @Column(name = "pickup_booked_date")
  private String pickupBookedDate;

  @Column(name = "delivery_partner_order_id")
  private String deliveryPartnerOrderId;

  @Column(name = "shipment_id")
  private String shipmentId;

  @Column(name = "awb_code")
  private String awbCode;

  @Column(name = "courier_company_id")
  private String courierCompanyId;

  @Column(name = "courier_name")
  private String courierName;

  @Column(name = "displayed_tracking_data")
  private String displayedTrackingData;
}
