
package com.lgitsolution.switcheshopcommon.subscriptionservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.order.dto.OrderStatusDetail;
import com.lgitsolution.switcheshopcommon.subscriptionservice.payment.dto.SubscriptionPaymentDetailDto;

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
  private Integer promocodeId = -1;
  private String itemId = "";

  // Only in DTO
  boolean isToPoke = false;
  private Long subsRemainingDays;

  private SubscriptionPaymentDetailDto subscriptionPaymentDetailDto;
  private String companyId;
  private Float totalPaymentGatwayPayable = 0.0f;
  private String planName;
  OrderStatusDetail paymentStatus;

}
