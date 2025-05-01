
package com.lgitsolution.switcheshopcommon.subscriptionservice.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionPlansDto {

  private Integer id;
  private String name;
  private String title;
  private List<String> descriptionList;
  private Integer trialDays;
  private List<SubscriptionPlansPricingDto> subscriptionPlansPricingList =
          new ArrayList<SubscriptionPlansPricingDto>();
  private Long createdAt;
}
