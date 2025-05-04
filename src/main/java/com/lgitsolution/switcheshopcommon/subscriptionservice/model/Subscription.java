
package com.lgitsolution.switcheshopcommon.subscriptionservice.model;

import java.time.LocalDate;

import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionStatusEnum;

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
@Table(name = "subscriptions", schema = "public ")
public class Subscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "client_details_id")
  private int clientDetailsId;

  @Column(name = "plan_id")
  private int planId;

  @Column(name = "pricing_plan_id")
  private int pricingPlanId;

  @Column(name = "discount_id")
  private int discountId;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private SubscriptionStatusEnum status;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(name = "notification_start_date")
  private LocalDate notificationStartDays;

  @Column(name = "updated_at")
  private LocalDate updatedAt;
}
