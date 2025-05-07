
package com.lgitsolution.switcheshopcommon.subscriptionservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionDto {

  private int id;
  private int clientDetailsId;
  private int planId;
  private int pricingPlanId;
  @Enumerated(EnumType.STRING)
  private SubscriptionStatusEnum status;
  private Long startDate;
  private Long endDate;
  private Long notificationStartDays;
  private Long updatedAt;
  private String promocodeName;
  private Float promocodeDiscount;
  private Integer promocodeId;

  // Only in DTO
  boolean isToPoke = false;
  Long subsRemainingDays;
}
