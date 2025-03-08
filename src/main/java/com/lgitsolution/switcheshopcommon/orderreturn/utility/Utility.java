
package com.lgitsolution.switcheshopcommon.orderreturn.utility;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgitsolution.switcheshopcommon.order.dto.OrderDetailsDto;
import com.lgitsolution.switcheshopcommon.order.dto.OrderItemsDto;
import com.lgitsolution.switcheshopcommon.order.dto.OrderPaymentMethod;
import com.lgitsolution.switcheshopcommon.order.dto.OrderStatusConstants;
import com.lgitsolution.switcheshopcommon.order.dto.OrderStatusDetail;
import com.lgitsolution.switcheshopcommon.order.dto.OrderTrackingDetailsDto;
import com.lgitsolution.switcheshopcommon.order.dto.SwitchEShopOrderEnum;
import com.lgitsolution.switcheshopcommon.orderreturn.dto.OrderReturnConstants;
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
    dto.setDisplayedTrackingList(parseJsonToList(model.getDisplayedTrackingData(), true));
    dto.setOrderStatusDetail(getOrderStatusDetailObj(dto.getStatus()));
    dto.setRefundMode(model.getRefundMode());
    return dto;
  }

  /**
   * Parse json string to OrderTrackingDetailsDto list.
   * 
   * @param json string
   * @return the list of OrderTrackingDetailsDto details
   */
  public static List<OrderTrackingDetailsDto> parseJsonToList(String json, boolean isTrack) {
    if (json == null || json.isBlank()) {
      return null;
    }
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(json, new TypeReference<List<OrderTrackingDetailsDto>>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to parse JSON to List<OrderTrackingDetailsDto>", e);
    }
  }

  /**
   * Parse json string to address details list.
   * 
   * @param json string
   * @return the list of address details
   */
  private static List<ReturnOrderQuestionDto> parseJsonToList(String json) {
    if (json == null || json.isBlank()) {
      return null;
    }
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
    model.setDisplayedTrackingData(CommonUtility.ConvertObjectToJsonString(dto
            .getDisplayedTrackingList()));
    model.setRefundMode(dto.getRefundMode());
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

  /**
   * Gets the order status list.
   * 
   * @param isReturn is for return order.
   * @param trackingList the tracking list
   * @return the tracking data list.
   */
  public static List<OrderTrackingDetailsDto> getOrderTrackingDetailsList(int requestedFor) {
    List<OrderTrackingDetailsDto> trackingList = new ArrayList<OrderTrackingDetailsDto>();

    OrderTrackingDetailsDto pending = new OrderTrackingDetailsDto();
    pending.setStepNumber(0);
    pending.setStatusName(OrderStatusConstants.PENDING_ORDER_STATUS);
    pending.setStatusCode(SwitchEShopOrderEnum.Return_Pending.getValue());

    OrderTrackingDetailsDto confirmed = new OrderTrackingDetailsDto();
    confirmed.setStepNumber(1);
    confirmed.setStatusName(OrderStatusConstants.APPROVED_Initiated_ORDER_STATUS);
    confirmed.setStatusCode(SwitchEShopOrderEnum.Return_Approved_Initiated.getValue());

    OrderTrackingDetailsDto pickedUp = new OrderTrackingDetailsDto();
    pickedUp.setStepNumber(2);
    pickedUp.setStatusName(OrderStatusConstants.Picked_Up_ORDER_STATUS);
    pickedUp.setStatusCode(SwitchEShopOrderEnum.Return_Picked_Up.getValue());

    trackingList.add(pending);
    trackingList.add(confirmed);
    trackingList.add(pickedUp);

    if (requestedFor == OrderReturnConstants.REQUESTED_FOR_RETURN) {
      OrderTrackingDetailsDto refundInitiated = new OrderTrackingDetailsDto();
      refundInitiated.setStepNumber(3);
      refundInitiated.setStatusName(OrderStatusConstants.Refund_Initiated_ORDER_STATUS);
      refundInitiated.setStatusCode(SwitchEShopOrderEnum.Return_Picked_Up.getValue());

      OrderTrackingDetailsDto completed = new OrderTrackingDetailsDto();
      completed.setStepNumber(4);
      completed.setStatusName(OrderStatusConstants.COMPLETED_ORDER_STATUS);
      completed.setStatusCode(SwitchEShopOrderEnum.Return_Completed.getValue());

      trackingList.add(refundInitiated);
      trackingList.add(completed);
    } else {

      OrderTrackingDetailsDto shipped = new OrderTrackingDetailsDto();
      shipped.setStepNumber(3);
      shipped.setStatusName(OrderStatusConstants.SHIPPED_ORDER_STATUS);
      shipped.setStatusCode(SwitchEShopOrderEnum.Shipped.getValue());
      trackingList.add(shipped);

      OrderTrackingDetailsDto outForDelivery = new OrderTrackingDetailsDto();
      outForDelivery.setStepNumber(4);
      outForDelivery.setStatusName(OrderStatusConstants.OUT_FOR_DELIVERY_ORDER_STATUS);
      outForDelivery.setStatusCode(SwitchEShopOrderEnum.Out_For_Delivery.getValue());
      trackingList.add(outForDelivery);

      OrderTrackingDetailsDto delivered = new OrderTrackingDetailsDto();
      delivered.setStepNumber(5);
      delivered.setStatusName(OrderStatusConstants.DELIVERED_ORDER_STATUS);
      delivered.setStatusCode(SwitchEShopOrderEnum.Return_Completed.getValue());
      trackingList.add(delivered);
    }
    return trackingList;
  }

  /**
   * Gets updated tracking list.
   * 
   * @param trackingList the tracking list
   * @param statusCode the status code
   * @param date the date
   * @return the updated tracking list.
   */
  public static List<OrderTrackingDetailsDto> updateTrackingDatalist(
          List<OrderTrackingDetailsDto> trackingList, int statusCode, long date) {
    if (statusCode == SwitchEShopOrderEnum.Return_Delivered_To_Company.getValue()) {
      return trackingList;
    }
    if (statusCode == SwitchEShopOrderEnum.Return_Request_Canceled_by_Company.getValue()
            || statusCode == SwitchEShopOrderEnum.Return_Request_Canceled_by_Customer.getValue()) {
      trackingList.removeIf(obj -> (obj
              .getStatusCode() != SwitchEShopOrderEnum.Return_Approved_Initiated.getValue() || obj
                      .getStatusCode() != SwitchEShopOrderEnum.Return_Pending.getValue()));
      OrderTrackingDetailsDto cancel = new OrderTrackingDetailsDto();
      cancel.setStepNumber(2);
      cancel.setStatusName(OrderStatusConstants.CANCEL_STATUS);
      cancel.setStatusCode(statusCode);
      cancel.setIsDone(1);
      cancel.setStatusDate(System.currentTimeMillis());
      trackingList.add(cancel);
    } else {
      trackingList.forEach(o -> {
        if (o.getStatusCode() == statusCode && o.getIsDone() != 1) {
          o.setStatusDate(date);
          o.setIsDone(1);
        }
      });
    }
    return trackingList;
  }

  public static OrderDetailsDto getOrderDetails(ReturnDetailDto returnDetailDto,
          OrderDetailsDto existingOrderDetailsDto) {
    OrderDetailsDto newOrderDetailsDto = new OrderDetailsDto();
    newOrderDetailsDto.setCreatedAt(System.currentTimeMillis());
    newOrderDetailsDto.setCustomerAddressDetails(existingOrderDetailsDto
            .getCustomerAddressDetails());
    newOrderDetailsDto.setCustomerDetailsId(existingOrderDetailsDto.getCustomerDetailsId());
    List<OrderItemsDto> orderItemsDtoList = existingOrderDetailsDto.getOrderItemsDtoList();
    OrderItemsDto orderItemsDto = orderItemsDtoList.stream().filter(obj -> obj
            .getId() == returnDetailDto.getOrderItemId()).findFirst().get();
    newOrderDetailsDto.setOrderItemsDtoList(List.of(orderItemsDto));
    newOrderDetailsDto.setReturnDetailId(returnDetailDto.getId());
    newOrderDetailsDto.setTotalPayable(orderItemsDto.getSellingPrice());
    newOrderDetailsDto.setTotalAmount(orderItemsDto.getSellingPrice());
    newOrderDetailsDto.setPaymentMethod(OrderPaymentMethod.Prepaid);
    newOrderDetailsDto.setPickupLocation(existingOrderDetailsDto.getPickupLocation());
    return newOrderDetailsDto;
  }

  public static OrderStatusDetail getOrderStatusDetailObj(int status) {
    OrderStatusDetail orderStatusDetail = new OrderStatusDetail();
    orderStatusDetail.setStatusCode(status);
    String statusName = "";
    if (status == SwitchEShopOrderEnum.Return_Pending.getValue()) {
      statusName = OrderStatusConstants.PENDING_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Return_Approved_Initiated.getValue()) {
      statusName = OrderStatusConstants.APPROVED_Initiated_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Return_Picked_Up.getValue()) {
      statusName = OrderStatusConstants.Picked_Up_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Return_Completed.getValue()) {
      statusName = OrderStatusConstants.COMPLETED_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Return_Request_Canceled_by_Company.getValue()) {
      statusName = OrderStatusConstants.CANCEL_BY_COMPANY_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Return_Request_Canceled_by_Customer.getValue()) {
      statusName = OrderStatusConstants.CANCEL_BY_CUSTOMER_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Return_Delivered_To_Company.getValue()) {
      statusName = OrderStatusConstants.DELIVERED_TO_COMPANY_ORDER_STATUS;
    }
    orderStatusDetail.setName(statusName);
    return orderStatusDetail;
  }

}
