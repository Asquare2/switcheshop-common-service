
package com.lgitsolution.switcheshopcommon.subscriptionservice.model;

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
@Table(name = "subscription_plans", schema = "public")
public class SubscriptionPlans {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "title")
  private String title;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "trial_days")
  private Integer trialDays;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "plan_id", referencedColumnName = "id")
  private List<SubscriptionPlansPricing> subscriptionPlansPricingList =
          new ArrayList<SubscriptionPlansPricing>();

  @Column(name = "created_at")
  private LocalDate createdAt;

}
