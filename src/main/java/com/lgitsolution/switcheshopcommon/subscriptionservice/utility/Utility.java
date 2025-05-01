
package com.lgitsolution.switcheshopcommon.subscriptionservice.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionPlansDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionPlansPricingDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.model.SubscriptionPlans;
import com.lgitsolution.switcheshopcommon.subscriptionservice.model.SubscriptionPlansPricing;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  public static SubscriptionPlansPricing convertDtoToModel(SubscriptionPlansPricingDto dto) {
    SubscriptionPlansPricing model = new SubscriptionPlansPricing();

    model.setId(dto.getId());
    model.setPlanId(dto.getPlanId());
    model.setOriginalPrice(dto.getOriginalPrice());
    model.setDiscountedPrice(dto.getDiscountedPrice());
    model.setBillingCycle(dto.getBillingCycle());
    model.setCreatedAt(CommonUtility.getLocalDate(dto.getCreatedAt()));

    return model;
  }

  public static SubscriptionPlansPricingDto convertModelToDto(SubscriptionPlansPricing model) {
    SubscriptionPlansPricingDto dto = new SubscriptionPlansPricingDto();

    dto.setId(model.getId());
    dto.setPlanId(model.getPlanId());
    dto.setOriginalPrice(model.getOriginalPrice());
    dto.setDiscountedPrice(model.getDiscountedPrice());
    dto.setBillingCycle(model.getBillingCycle());
    dto.setCreatedAt(CommonUtility.getLocalDateMillis(model.getCreatedAt()));

    return dto;
  }

  public static SubscriptionPlans convertDtoToModel(SubscriptionPlansDto dto) {
    SubscriptionPlans model = new SubscriptionPlans();

    model.setId(dto.getId());
    model.setName(dto.getName());
    model.setTitle(dto.getTitle());
    model.setDescription(CommonUtility.ConvertObjectToJsonString(dto.getDescriptionList()));
    model.setTrialDays(dto.getTrialDays());
    model.setCreatedAt(CommonUtility.getLocalDate(dto.getCreatedAt()));
    List<SubscriptionPlansPricingDto> pricingList = dto.getSubscriptionPlansPricingList();
    pricingList.forEach(obj -> model.getSubscriptionPlansPricingList().add(convertDtoToModel(obj)));
    return model;
  }

  public static SubscriptionPlansDto convertModelToDto(SubscriptionPlans model) {
    SubscriptionPlansDto dto = new SubscriptionPlansDto();

    dto.setId(model.getId());
    dto.setName(model.getName());
    dto.setTitle(model.getTitle());
    dto.setDescriptionList(CommonUtility.convertJsonToObject(model.getDescription(),
            new ArrayList<String>()));
    dto.setTrialDays(model.getTrialDays());
    dto.setCreatedAt(CommonUtility.getLocalDateMillis(model.getCreatedAt()));
    List<SubscriptionPlansPricing> pricingList = model.getSubscriptionPlansPricingList();
    pricingList.forEach(obj -> dto.getSubscriptionPlansPricingList().add(convertModelToDto(obj)));
    return dto;
  }

}
