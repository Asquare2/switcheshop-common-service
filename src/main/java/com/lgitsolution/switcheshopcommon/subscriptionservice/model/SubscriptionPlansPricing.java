package com.lgitsolution.switcheshopcommon.subscriptionservice.model;

import java.time.LocalDate;

import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.BillingCycleEnum;

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
@Table(name = "subscription_plans_pricing", schema = "public")
public class SubscriptionPlansPricing {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "plan_id")
  private Integer planId;

  @Column(name = "original_price")
  private Float originalPrice;

  @Column(name = "discounted_price")
  private Float discountedPrice;

  @Column(name = "billing_cycle")
  @Enumerated(EnumType.STRING)
  private BillingCycleEnum billingCycle;

  @Column(name = "created_at")
  private LocalDate createdAt;

}
