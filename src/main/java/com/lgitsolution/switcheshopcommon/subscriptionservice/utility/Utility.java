
package com.lgitsolution.switcheshopcommon.subscriptionservice.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionPlansDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionPlansPricingDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.model.Subscription;
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

  public static Subscription convertDtoToModel(SubscriptionDto dto) {
    Subscription model = new Subscription();
    model.setId(dto.getId());
    model.setClientDetailsId(dto.getClientDetailsId());
    model.setPromocodeName(dto.getPromocodeName());
    model.setPromocodeDiscount(dto.getPromocodeDiscount());
    model.setPromocodeId(dto.getPromocodeId());
    model.setPlanId(dto.getPlanId());
    model.setPricingPlanId(dto.getPricingPlanId());
    model.setStatus(dto.getStatus());
    model.setStartDate(CommonUtility.getLocalDate(dto.getStartDate()));
    model.setEndDate(CommonUtility.getLocalDate(dto.getEndDate()));
    model.setNotificationStartDays(CommonUtility.getLocalDate(dto.getNotificationStartDays()));
    model.setUpdatedAt(CommonUtility.getLocalDate(dto.getUpdatedAt()));
    model.setItemId(dto.getItemId());
    return model;
  }

  public static SubscriptionDto convertModelToDto(Subscription model) {
    SubscriptionDto dto = new SubscriptionDto();
    dto.setId(model.getId());
    dto.setClientDetailsId(model.getClientDetailsId());
    dto.setPromocodeId(model.getPromocodeId());
    dto.setPromocodeName(model.getPromocodeName());
    dto.setPromocodeDiscount(model.getPromocodeDiscount());
    dto.setPlanId(model.getPlanId());
    dto.setPricingPlanId(model.getPricingPlanId());
    dto.setStatus(model.getStatus());
    dto.setStartDate(CommonUtility.getLocalDateMillis(model.getStartDate()));
    dto.setEndDate(CommonUtility.getLocalDateMillis(model.getEndDate()));
    dto.setNotificationStartDays(CommonUtility.getLocalDateMillis(model
            .getNotificationStartDays()));
    dto.setUpdatedAt(CommonUtility.getLocalDateMillis(model.getUpdatedAt()));
    dto.setItemId(model.getItemId());
    return dto;
  }
}
