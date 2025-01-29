
package com.lgitsolution.switcheshopcommon.orderreturn.utility;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgitsolution.switcheshopcommon.orderreturn.dto.ReturnDetailDto;
import com.lgitsolution.switcheshopcommon.orderreturn.model.ReturnDetail;
import com.lgitsolution.switcheshopcommon.returnorderquestion.dto.ReturnOrderQuestionDto;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  public static ReturnDetailDto convertModelToDto(ReturnDetail model) {
    ReturnDetailDto dto = new ReturnDetailDto();
    dto.setId(model.getId());
    dto.setOrderId(model.getOrderId());
    dto.setOrderItemId(model.getOrderItemId());
    dto.setReplaceOrderId(model.getReplaceOrderId());
    dto.setPaymentId(model.getPaymentId());
    dto.setStatus(model.getStatus());
    dto.setReason(model.getReason());
    dto.setRequestedFor(model.getRequestedFor());
    dto.setPaymentStatus(model.getPaymentStatus());
    dto.setItemId(model.getItemId());
    dto.setDeliveryPartnerResponse(model.getDeliveryPartnerResponse());
    dto.setTrackingData(model.getTrackingData());
    dto.setPickupScheduledDate(CommonUtility.getLocalDateMillis(model.getPickupScheduledDate()));
    dto.setShipmentId(model.getShipmentId());
    dto.setAwbCode(model.getAwbCode());
    dto.setCourierCompanyId(model.getCourierCompanyId());
    dto.setCourierName(model.getCourierName());
    dto.setCreatedAt(CommonUtility.getLocalDateMillis(model.getCreatedAt()));
    dto.setTotalApprovedAmount(model.getTotalApprovedAmount());
    dto.setRejectReturnReason(model.getRejectReturnReason());
    dto.setReturnOrderQuestionAnswerDtoList(parseJsonToList(model
            .getReturnOrderQuestionAnswerDto()));
    dto.setOrderIdentificationNo(model.getOrderIdentificationNo());
    dto.setSkuName(model.getSkuName());
    dto.setRequestedSkuName(model.getRequestedSkuName());
    dto.setRequestedSkuId(model.getRequestedSkuId());
    return dto;
  }

  /**
   * Parse json string to address details list.
   * 
   * @param json string
   * @return the list of address details
   */
  private static List<ReturnOrderQuestionDto> parseJsonToList(String json) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(json, new TypeReference<List<ReturnOrderQuestionDto>>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to parse JSON to List<ReturnOrderQuestionDto>", e);
    }
  }

  public static ReturnDetail convertDtoToModel(ReturnDetailDto dto) {
    ReturnDetail model = new ReturnDetail();
    model.setId(dto.getId());
    model.setOrderId(dto.getOrderId());
    model.setOrderItemId(dto.getOrderItemId());
    model.setReplaceOrderId(dto.getReplaceOrderId());
    model.setPaymentId(dto.getPaymentId());
    model.setStatus(dto.getStatus());
    model.setReason(dto.getReason());
    model.setRequestedFor(dto.getRequestedFor());
    model.setPaymentStatus(dto.getPaymentStatus());
    model.setItemId(dto.getItemId());
    model.setDeliveryPartnerResponse(dto.getDeliveryPartnerResponse());
    model.setTrackingData(dto.getTrackingData());
    model.setPickupScheduledDate(CommonUtility.getLocalDate(dto.getPickupScheduledDate()));
    model.setShipmentId(dto.getShipmentId());
    model.setAwbCode(dto.getAwbCode());
    model.setCourierCompanyId(dto.getCourierCompanyId());
    model.setCourierName(dto.getCourierName());
    model.setCreatedAt(CommonUtility.getLocalDate(dto.getCreatedAt()));
    model.setTotalApprovedAmount(dto.getTotalApprovedAmount());
    model.setRejectReturnReason(dto.getRejectReturnReason());
    model.setReturnOrderQuestionAnswerDto(CommonUtility.ConvertObjectToJsonString(dto
            .getReturnOrderQuestionAnswerDtoList()));
    model.setOrderIdentificationNo(dto.getOrderIdentificationNo());
    model.setSkuName(dto.getSkuName());
    model.setRequestedSkuName(dto.getRequestedSkuName());
    model.setRequestedSkuId(dto.getRequestedSkuId());
    return model;
  }

  /**
   * Convert model list to DTO list
   * 
   * @param modelList
   * @return
   */
  public static List<ReturnDetailDto> convertModelToDto(List<ReturnDetail> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).toList();
  }

}
