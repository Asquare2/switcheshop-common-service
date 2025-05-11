
package com.lgitsolution.switcheshopcommon.subscriptionservice.utility;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderMetaDataDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.PaymentOrderRequestDto;
import com.lgitsolution.switcheshopcommon.promocode.dto.CustomerPromoCodeDetails;
import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionPlansDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionPlansPricingDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.dto.SubscriptionPromoCodeDto;
import com.lgitsolution.switcheshopcommon.subscriptionservice.model.Subscription;
import com.lgitsolution.switcheshopcommon.subscriptionservice.model.SubscriptionPlans;
import com.lgitsolution.switcheshopcommon.subscriptionservice.model.SubscriptionPlansPricing;
import com.lgitsolution.switcheshopcommon.subscriptionservice.model.SubscriptionPromoCode;
import com.lgitsolution.switcheshopcommon.user.dto.SystemUserDto;

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

  /**
   * 
   * @param customerDetailsDto
   * @param orderDetilsDto
   * @return
   */
  public static PaymentOrderRequestDto createPaymentOrderRequestDtoForSubsciption(
          SubscriptionDto subscriptionDto, SystemUserDto systemUserDto) {
    PaymentOrderRequestDto orderRequestDto = new PaymentOrderRequestDto();
    orderRequestDto.setOrder_amount((double) subscriptionDto.getTotalPaymentGatwayPayable());
    orderRequestDto.setOrderItemId(subscriptionDto.getItemId());
    orderRequestDto.getCustomer_details().setCustomer_id(subscriptionDto.getClientDetailsId() + "");
    orderRequestDto.getCustomer_details().setCustomer_email(systemUserDto.getEmail());
    orderRequestDto.getCustomer_details().setCustomer_phone(systemUserDto.getMobile());
    orderRequestDto.setOrder_expiry_time(CommonUtility.addMinutesToCurrentTime(18, ZoneId.of(
            "Asia/Kolkata")));
    /* Order Meta data details. */
    OrderMetaDataDto orderMetaDataDto = new OrderMetaDataDto();
    /*
     * orderMetaDataDto.setReturn_url(
     * "https://localhost:8081/order-details/get-update-order-status?orderItemId=" +
     * orderDetilsDto.getItemId());
     */
    orderRequestDto.setOrder_meta(orderMetaDataDto);
    return orderRequestDto;
  }

  /**
   * Converts the dto object to model object.
   * 
   * @param promocodeDto the promocode dto object
   * @return the promocode model object
   */
  public static SubscriptionPromoCode convertDtoToModel(SubscriptionPromoCodeDto promocodeDto) {
    SubscriptionPromoCode promocode = new SubscriptionPromoCode();
    promocode.setName(promocodeDto.getName());
    promocode.setMessage(promocodeDto.getMessage());
    promocode.setIsReusable(promocodeDto.getIsReusable());
    promocode.setUseCount(promocodeDto.getUseCount());
    promocode.setMultiMedia(CommonUtility.getMultiMediaJsonString(promocodeDto.getMultiMedia()));
    promocode.setMinimumPurchaseAmount(promocodeDto.getMinimumPurchaseAmount());
    promocode.setDiscountType(promocodeDto.getDiscountType());
    promocode.setDiscountAmount(promocodeDto.getDiscountAmount());
    promocode.setStatus(promocodeDto.getStatus());
    promocode.setCreatedAt(CommonUtility.getLocalDate(promocodeDto.getCreatedAt()));
    promocode.setModifiedAt(CommonUtility.getLocalDate(promocodeDto.getModifiedAt()));
    return promocode;
  }

  /**
   * Converts the model to dto object.
   * 
   * @param promocode the promocode model class object
   * @return the promocode dto class object
   */
  public static SubscriptionPromoCodeDto convertModelToDto(SubscriptionPromoCode promocode) {
    SubscriptionPromoCodeDto promocodeDto = new SubscriptionPromoCodeDto();
    promocodeDto.setId(promocode.getId());
    promocodeDto.setName(promocode.getName());
    promocodeDto.setMessage(promocode.getMessage());
    promocodeDto.setIsReusable(promocode.getIsReusable());
    promocodeDto.setUseCount(promocode.getUseCount());
    promocodeDto.setMultiMedia(CommonUtility.getMultiMediaObject(promocode.getMultiMedia()));
    promocodeDto.setMinimumPurchaseAmount(promocode.getMinimumPurchaseAmount());
    promocodeDto.setDiscountType(promocode.getDiscountType());
    promocodeDto.setDiscountAmount(promocode.getDiscountAmount());
    promocodeDto.setStatus(promocode.getStatus());
    promocodeDto.setCreatedAt(CommonUtility.getLocalDateMillis(promocode.getCreatedAt()));
    promocodeDto.setModifiedAt(CommonUtility.getLocalDateMillis(promocode.getModifiedAt()));
    return promocodeDto;
  }

  /**
   * Converts the list of promocode model object to list of promocode dto object.
   * 
   * @param promocodeList the list of promocode model object
   * @return the list of promocode dto object
   */
  public static List<SubscriptionPromoCodeDto> convertModelToDto(
          List<SubscriptionPromoCode> promocodeList) {
    List<SubscriptionPromoCodeDto> promocodeDtoList = new ArrayList<>();
    for (SubscriptionPromoCode promocode : promocodeList) {
      SubscriptionPromoCodeDto promocodeDto = convertModelToDto(promocode);
      promocodeDtoList.add(promocodeDto);
    }
    return promocodeDtoList;
  }

  public static boolean isEligibleForPromoCode(
          Map<Integer, CustomerPromoCodeDetails> promocodeDetailsMap, Integer promocodeId) {
    boolean isEligibleForPromoCode = false;
    if (promocodeDetailsMap == null || promocodeDetailsMap.isEmpty() || !promocodeDetailsMap
            .containsKey(promocodeId)) {
      isEligibleForPromoCode = true;
    } else {
      CustomerPromoCodeDetails customerPromoCodeDetails = promocodeDetailsMap.get(promocodeId);
      if (customerPromoCodeDetails.getIsReusable() == 1) {
        if (customerPromoCodeDetails.getNoOfUsage() < customerPromoCodeDetails.getMaxCount()) {
          isEligibleForPromoCode = true;
        }
      }
    }
    return isEligibleForPromoCode;
  }
}
