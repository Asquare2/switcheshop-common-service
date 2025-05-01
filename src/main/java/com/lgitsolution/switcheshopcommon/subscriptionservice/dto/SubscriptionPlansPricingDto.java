
package com.lgitsolution.switcheshopcommon.subscriptionservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionPlansPricingDto {

  private Integer id;

  private Integer planId;

  private Float originalPrice;

  private Float discountedPrice;

  @Enumerated(EnumType.STRING)
  private BillingCycleEnum billingCycle;

  private Long createdAt;

}
