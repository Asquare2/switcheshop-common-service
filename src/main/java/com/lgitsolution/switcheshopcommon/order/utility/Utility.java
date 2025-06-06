
package com.lgitsolution.switcheshopcommon.order.utility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgitsolution.switcheshopcommon.customer.dto.CustomerAddressDetails;
import com.lgitsolution.switcheshopcommon.customer.dto.CustomerDetailsDto;
import com.lgitsolution.switcheshopcommon.order.dto.OrderDetailsDto;
import com.lgitsolution.switcheshopcommon.order.dto.OrderItemsDto;
import com.lgitsolution.switcheshopcommon.order.dto.OrderStatusConstants;
import com.lgitsolution.switcheshopcommon.order.dto.OrderStatusDetail;
import com.lgitsolution.switcheshopcommon.order.dto.OrderTrackingDetailsDto;
import com.lgitsolution.switcheshopcommon.order.dto.SwitchEShopOrderEnum;
import com.lgitsolution.switcheshopcommon.order.model.OrderDetails;
import com.lgitsolution.switcheshopcommon.order.model.OrderItems;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.OrderMetaDataDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.PaymentOrderRequestDto;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility;

  /**
   * 
   * @param orderDetilsDto
   * @return
   */
  public static OrderDetails convertDtoToModel(OrderDetailsDto orderDetilsDto) {
    OrderDetails orderDetails = new OrderDetails();
    orderDetails.setId(orderDetilsDto.getId());
    orderDetails.setCustomerDetailsId(orderDetilsDto.getCustomerDetailsId());
    orderDetails.setTotalAmount(orderDetilsDto.getTotalAmount());
    orderDetails.setTotalPayable(orderDetilsDto.getTotalPayable());
    orderDetails.setStatus(orderDetilsDto.getStatus());
    orderDetails.setOrderNotes(orderDetilsDto.getOrderNotes());
    orderDetails.setDeliveryCharge(orderDetilsDto.getDeliveryCharge());
    orderDetails.setWalletUsed(orderDetilsDto.getWalletUsed());
    orderDetails.setPromocodeName(orderDetilsDto.getPromocodeName());
    orderDetails.setPromocodeDiscount(orderDetilsDto.getPromocodeDiscount());
    orderDetails.setCreatedAt(CommonUtility.getLocalDate(orderDetilsDto.getCreatedAt()));
    orderDetails.setModifiedAt(CommonUtility.getLocalDate(orderDetilsDto.getModifiedAt()));
    orderDetails.setDeliveryPartnerResponse(orderDetilsDto.getDeliveryPartnerResponse());
    List<OrderItemsDto> orderItemsDtoList = orderDetilsDto.getOrderItemsDtoList();
    orderDetails.setItemId(orderDetilsDto.getItemId());
    orderDetails.setPackageDimensions(CommonUtility.convertMapToJsonString(orderDetilsDto
            .getPackageDimensionsMap()));
    orderItemsDtoList.forEach(dto -> orderDetails.getOrderItemsList().add(convertDtoToModel(dto)));
    orderDetails.setTrackingData(orderDetilsDto.getTrackingData());
    orderDetails.setPaymentMethod(orderDetilsDto.getPaymentMethod());
    orderDetails.setAddress(com.lgitsolution.switcheshopcommon.common.util.Utility
            .ConvertObjectToJsonString(orderDetilsDto.getCustomerAddressDetails()));
    orderDetails.setPickupBookedDate(orderDetilsDto.getPickupBookedDate());
    orderDetails.setPickupScheduledDate(CommonUtility.getLocalDate(orderDetilsDto
            .getPickupScheduledDate()));
    orderDetails.setDeliveryPartnerOrderId(orderDetilsDto.getDeliveryPartnerOrderId());
    orderDetails.setShipmentId(orderDetilsDto.getShipmentId());
    orderDetails.setAwbCode(orderDetilsDto.getAwbCode());
    orderDetails.setCourierCompanyId(orderDetilsDto.getCourierCompanyId());
    orderDetails.setCourierName(orderDetilsDto.getCourierName());
    orderDetails.setDisplayedTrackingData(CommonUtility.ConvertObjectToJsonString(orderDetilsDto
            .getDisplayedTrackingList()));
    orderDetails.setPickupLocation(orderDetilsDto.getPickupLocation());
    orderDetails.setReturnDetailId(orderDetilsDto.getReturnDetailId());
    orderDetails.setOrderTrackingUrl(orderDetilsDto.getOrderTrackingUrl());

    return orderDetails;
  }

  /**
   * 
   * @param orderDetails
   * @return
   */
  public static OrderDetailsDto convertModelToDto(OrderDetails orderDetails) {
    OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
    orderDetailsDto.setId(orderDetails.getId());
    orderDetailsDto.setCustomerDetailsId(orderDetails.getCustomerDetailsId());
    orderDetailsDto.setTotalAmount(orderDetails.getTotalAmount());
    orderDetailsDto.setTotalPayable(orderDetails.getTotalPayable());
    orderDetailsDto.setStatus(orderDetails.getStatus());
    orderDetailsDto.setOrderNotes(orderDetails.getOrderNotes());
    orderDetailsDto.setDeliveryCharge(orderDetails.getDeliveryCharge());
    orderDetailsDto.setWalletUsed(orderDetails.getWalletUsed());
    orderDetailsDto.setPromocodeName(orderDetails.getPromocodeName());
    orderDetailsDto.setPromocodeDiscount(orderDetails.getPromocodeDiscount());
    if (orderDetails.getCreatedAt() != null) {
      orderDetailsDto.setCreatedAt(CommonUtility.getLocalDateMillis(orderDetails.getCreatedAt()));
    }
    if (orderDetails.getModifiedAt() != null) {
      orderDetailsDto.setModifiedAt(CommonUtility.getLocalDateMillis(orderDetails.getModifiedAt()));
    }
    orderDetailsDto.setDeliveryPartnerResponse(orderDetails.getDeliveryPartnerResponse());
    if (orderDetails.getPackageDimensions() != null) {
      orderDetailsDto.setPackageDimensionsMap(CommonUtility.convertJsonStringToMap(orderDetails
              .getPackageDimensions()));
    }
    orderDetailsDto.setItemId(orderDetails.getItemId());
    List<OrderItems> orderItemsList = orderDetails.getOrderItemsList();
    if (orderItemsList != null && !orderItemsList.isEmpty()) {
      orderItemsList.forEach(o -> orderDetailsDto.getOrderItemsDtoList().add(convertModelToDto(o)));
    }
    orderDetailsDto.setTrackingData(orderDetails.getTrackingData());
    orderDetailsDto.setPaymentMethod(orderDetails.getPaymentMethod());
    if (orderDetails.getAddress() != null) {
      orderDetailsDto.setCustomerAddressDetails(CommonUtility.convertJsonToObject(orderDetails
              .getAddress(), new CustomerAddressDetails()));
    }
    orderDetailsDto.setPickupBookedDate(orderDetails.getPickupBookedDate());
    if (orderDetails.getPickupScheduledDate() != null) {
      orderDetailsDto.setPickupScheduledDate(CommonUtility.getLocalDateMillis(orderDetails
              .getPickupScheduledDate()));
    }
    orderDetailsDto.setDeliveryPartnerOrderId(orderDetails.getDeliveryPartnerOrderId());
    orderDetailsDto.setShipmentId(orderDetails.getShipmentId());
    orderDetailsDto.setAwbCode(orderDetails.getAwbCode());
    orderDetailsDto.setCourierCompanyId(orderDetails.getCourierCompanyId());
    orderDetailsDto.setCourierName(orderDetails.getCourierName());
    if (orderDetails.getStatus() != null) {
      orderDetailsDto.setOrderStatusDetail(getOrderStatusDetailObj(orderDetails.getStatus()));
    }
    if (orderDetails.getDisplayedTrackingData() != null) {
      orderDetailsDto.setDisplayedTrackingList(parseJsonToList(orderDetails
              .getDisplayedTrackingData()));
    }
    orderDetailsDto.setPickupLocation(orderDetails.getPickupLocation());
    OrderTrackingDetailsDto deliveredTrackingData = getTrackingDetailByStatus(
            SwitchEShopOrderEnum.Deliverd, orderDetailsDto.getDisplayedTrackingList());

    if (deliveredTrackingData != null && deliveredTrackingData.getIsDone() == 1) {
      LocalDate deliveredDate = CommonUtility.getLocalDate(deliveredTrackingData.getStatusDate());
      LocalDate currentDate = com.lgitsolution.switcheshopcommon.common.util.Utility.getLocalDate(
              System.currentTimeMillis());
      long daysDifference = ChronoUnit.DAYS.between(deliveredDate, currentDate);
      daysDifference = Math.abs(daysDifference);
      if (daysDifference <= orderDetailsDto.getNoOfAllowdReturableDays()) {
        orderDetailsDto.setApplicableForReturn(true);
      }
    }

    boolean isApplicableForCancel = true;
    boolean isToShowInvoiceButton = false;
    List<OrderTrackingDetailsDto> displayedTrackingList = orderDetailsDto
            .getDisplayedTrackingList();

    for (OrderTrackingDetailsDto displayTrackDto : displayedTrackingList) {
      int statusCode = displayTrackDto.getStatusCode();
      if ((statusCode == SwitchEShopOrderEnum.Shipped.getValue() && displayTrackDto
              .getIsDone() == 1) || (statusCode == SwitchEShopOrderEnum.Out_For_Delivery.getValue()
                      && displayTrackDto.getIsDone() == 1)
              || (statusCode == SwitchEShopOrderEnum.Deliverd.getValue() && displayTrackDto
                      .getIsDone() == 1)
              || (statusCode == SwitchEShopOrderEnum.Order_Cancelled_By_Company.getValue()
                      && displayTrackDto.getIsDone() == 1)
              || (statusCode == SwitchEShopOrderEnum.Order_Cancelled_By_Customer.getValue()
                      && displayTrackDto.getIsDone() == 1)
              || (statusCode == SwitchEShopOrderEnum.Paid_Order_Cancelled_By_Customer.getValue()
                      && displayTrackDto.getIsDone() == 1)) {
        isApplicableForCancel = false;
      }

      if (statusCode == SwitchEShopOrderEnum.Pending.getValue() && displayTrackDto
              .getIsDone() == 1) {
        OrderTrackingDetailsDto confirmedStatus = getTrackingDetailByStatus(
                SwitchEShopOrderEnum.Confirmed, displayedTrackingList);
        if (confirmedStatus.getIsDone() == 0) {
          isApplicableForCancel = false;
        }
      }

      if (statusCode == SwitchEShopOrderEnum.Deliverd.getValue() && displayTrackDto
              .getIsDone() == 1) {
        isToShowInvoiceButton = true;
      }
    }
    orderDetailsDto.setApplicableForCancel(isApplicableForCancel);
    orderDetailsDto.setReturnDetailId(orderDetails.getReturnDetailId());
    orderDetailsDto.setToShowInvoiceButton(isToShowInvoiceButton);
    orderDetailsDto.setOrderTrackingUrl(orderDetails.getOrderTrackingUrl());
    return orderDetailsDto;
  }

  public static OrderStatusDetail getOrderStatusDetailObj(int status) {
    OrderStatusDetail orderStatusDetail = new OrderStatusDetail();
    orderStatusDetail.setStatusCode(status);
    String statusName = "";
    if (status == SwitchEShopOrderEnum.Confirmed.getValue()) {
      statusName = OrderStatusConstants.NEW_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Shipped.getValue()) {
      statusName = OrderStatusConstants.SHIPPED_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Pending.getValue()) {
      statusName = OrderStatusConstants.PENDING_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Prepared.getValue()) {
      statusName = OrderStatusConstants.PREPARED_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Processing.getValue()) {
      statusName = OrderStatusConstants.PROCESSING_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Out_For_Delivery.getValue()) {
      statusName = OrderStatusConstants.OUT_FOR_DELIVERY_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Deliverd.getValue()) {
      statusName = OrderStatusConstants.DELIVERED_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Order_Cancelled_By_Customer.getValue()
            || status == SwitchEShopOrderEnum.Paid_Order_Cancelled_By_Customer.getValue()) {
      statusName = OrderStatusConstants.CANCEL_BY_CUSTOMER_ORDER_STATUS;
    } else if (status == SwitchEShopOrderEnum.Order_Cancelled_By_Company.getValue()) {
      statusName = OrderStatusConstants.CANCEL_BY_COMPANY_ORDER_STATUS;
    }
    orderStatusDetail.setName(statusName);
    return orderStatusDetail;
  }

  /**
   * 
   * @param modelList
   * @return
   */
  public static List<OrderDetailsDto> convertModelToDto(List<OrderDetails> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).toList();
  }

  /**
   * 
   * @param dto
   * @return
   */
  public static OrderItems convertDtoToModel(OrderItemsDto dto) {
    OrderItems orderItems = new OrderItems();
    orderItems.setId(dto.getId());
    orderItems.setSkuId(dto.getSkuId());
    orderItems.setQuantity(dto.getQuantity());
    orderItems.setOrderDetailId(dto.getOrderDetailId());
    orderItems.setIdentificationNumber(dto.getIdentificationNumber());
    orderItems.setSkuName(dto.getSkuName());
    orderItems.setTitle(dto.getTitle());
    orderItems.setOriginalPrice(dto.getOriginalPrice());
    orderItems.setSellingPrice(dto.getSellingPrice());
    orderItems.setSaleId(dto.getSaleId());
    orderItems.setHsnCode(dto.getHsnCode());
    return orderItems;
  }

  /**
   * 
   * @param orderItems
   * @return
   */
  public static OrderItemsDto convertModelToDto(OrderItems orderItems) {
    OrderItemsDto orderItemsDto = new OrderItemsDto();
    orderItemsDto.setId(orderItems.getId());
    orderItemsDto.setSkuId(orderItems.getSkuId());
    orderItemsDto.setQuantity(orderItems.getQuantity());
    if (orderItems.getOrderDetailId() != null) {
      orderItemsDto.setOrderDetailId(orderItems.getOrderDetailId());
    }
    orderItemsDto.setIdentificationNumber(orderItems.getIdentificationNumber());
    orderItemsDto.setSkuName(orderItems.getSkuName());
    orderItemsDto.setTitle(orderItems.getTitle());
    orderItemsDto.setOriginalPrice(orderItems.getOriginalPrice());
    orderItemsDto.setSellingPrice(orderItems.getSellingPrice());
    orderItemsDto.setSaleId(orderItems.getSaleId());
    orderItemsDto.setHsnCode(orderItems.getHsnCode());
    return orderItemsDto;
  }

  /**
   * 
   * @param itemModelList
   * @return
   */
  public static List<OrderItemsDto> convertModelToDtoList(List<OrderItems> itemModelList) {
    return itemModelList.stream().map(model -> convertModelToDto(model)).toList();
  }

  /**
   * 
   * @param customerDetailsDto
   * @param orderDetilsDto
   * @return
   */
  public static PaymentOrderRequestDto createPaymentOrderRequestDto(
          CustomerDetailsDto customerDetailsDto, OrderDetailsDto orderDetilsDto) {
    PaymentOrderRequestDto orderRequestDto = new PaymentOrderRequestDto();
    orderRequestDto.setOrder_amount((double) orderDetilsDto.getTotalPaymentGatwayPayable());
    orderRequestDto.setOrderItemId(orderDetilsDto.getItemId());
    orderRequestDto.getCustomer_details().setCustomer_id(customerDetailsDto.getId() + "");
    orderRequestDto.getCustomer_details().setCustomer_email(customerDetailsDto.getEmail());
    orderRequestDto.getCustomer_details().setCustomer_phone(customerDetailsDto.getMobile());
    orderRequestDto.setOrder_expiry_time(CommonUtility.addMinutesToCurrentTime(18, ZoneId.of(
            "Asia/Kolkata")));
    /* Order Meta data details. */
    OrderMetaDataDto orderMetaDataDto = new OrderMetaDataDto();
    orderMetaDataDto.setReturn_url(
            "https://localhost:8081/order-details/get-update-order-status?orderItemId="
                    + orderDetilsDto.getItemId());
    orderRequestDto.setOrder_meta(orderMetaDataDto);
    return orderRequestDto;
  }

  /**
   * Gets the order status list.
   * 
   * @param isReturn is for return order.
   * @param trackingList the tracking list
   * @return the tracking data list.
   */
  public static List<OrderTrackingDetailsDto> getOrderTrackingDetailsList() {
    List<OrderTrackingDetailsDto> trackingList = new ArrayList<OrderTrackingDetailsDto>();

    OrderTrackingDetailsDto pending = new OrderTrackingDetailsDto();
    pending.setStepNumber(0);
    pending.setStatusName(OrderStatusConstants.PENDING_ORDER_STATUS);
    pending.setStatusCode(SwitchEShopOrderEnum.Pending.getValue());
    trackingList.add(pending);

    OrderTrackingDetailsDto confirmed = new OrderTrackingDetailsDto();
    confirmed.setStepNumber(1);
    confirmed.setStatusCode(SwitchEShopOrderEnum.Confirmed.getValue());
    confirmed.setStatusName(OrderStatusConstants.CONFIRMED_STATUS);
    trackingList.add(confirmed);

    OrderTrackingDetailsDto shipped = new OrderTrackingDetailsDto();
    shipped.setStepNumber(2);
    shipped.setStatusName(OrderStatusConstants.SHIPPED_ORDER_STATUS);
    shipped.setStatusCode(SwitchEShopOrderEnum.Shipped.getValue());
    trackingList.add(shipped);

    OrderTrackingDetailsDto outForDelivery = new OrderTrackingDetailsDto();
    outForDelivery.setStepNumber(3);
    outForDelivery.setStatusName(OrderStatusConstants.OUT_FOR_DELIVERY_ORDER_STATUS);
    outForDelivery.setStatusCode(SwitchEShopOrderEnum.Out_For_Delivery.getValue());
    trackingList.add(outForDelivery);

    OrderTrackingDetailsDto delivered = new OrderTrackingDetailsDto();
    delivered.setStepNumber(4);
    delivered.setStatusName(OrderStatusConstants.DELIVERED_ORDER_STATUS);
    delivered.setStatusCode(SwitchEShopOrderEnum.Deliverd.getValue());
    trackingList.add(delivered);

    return trackingList;
  }

  /**
   * Parse json string to OrderTrackingDetailsDto list.
   * 
   * @param json string
   * @return the list of OrderTrackingDetailsDto details
   */
  public static List<OrderTrackingDetailsDto> parseJsonToList(String json) {
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
   * Gets updated tracking list.
   * 
   * @param trackingList the tracking list
   * @param statusCode the status code
   * @param date the date
   * @return the updated tracking list.
   */
  public static List<OrderTrackingDetailsDto> updateTrackingDatalist(
          List<OrderTrackingDetailsDto> trackingList, int statusCode, long date) {
    if (statusCode == SwitchEShopOrderEnum.Order_Cancelled_By_Customer.getValue()
            || statusCode == SwitchEShopOrderEnum.Order_Cancelled_By_Company.getValue()) {
      trackingList.removeIf(obj -> obj.getStatusCode() != SwitchEShopOrderEnum.Confirmed
              .getValue());
      OrderTrackingDetailsDto cancel = new OrderTrackingDetailsDto();
      cancel.setStepNumber(2);
      cancel.setStatusName(OrderStatusConstants.CANCEL_STATUS);
      cancel.setStatusCode(statusCode);
      cancel.setIsDone(1);
      cancel.setStatusDate(System.currentTimeMillis());
      trackingList.add(cancel);
    } else if (statusCode == SwitchEShopOrderEnum.Paid_Order_Cancelled_By_Customer.getValue()) {
      trackingList.removeIf(obj -> obj.getStatusCode() != SwitchEShopOrderEnum.Confirmed
              .getValue());
      OrderTrackingDetailsDto cancel = new OrderTrackingDetailsDto();
      cancel.setStepNumber(2);
      cancel.setStatusName(OrderStatusConstants.CANCEL_STATUS);
      cancel.setStatusCode(statusCode);
      cancel.setIsDone(1);
      cancel.setStatusDate(System.currentTimeMillis());
      trackingList.add(cancel);

      OrderTrackingDetailsDto refundInitiated = new OrderTrackingDetailsDto();
      refundInitiated.setStepNumber(3);
      refundInitiated.setStatusName(OrderStatusConstants.APPROVED_Initiated_ORDER_STATUS);
      refundInitiated.setStatusCode(SwitchEShopOrderEnum.Return_Approved_Initiated.getValue());
      refundInitiated.setIsDone(0);
      refundInitiated.setStatusDate(System.currentTimeMillis());
      trackingList.add(refundInitiated);

      OrderTrackingDetailsDto returCompleted = new OrderTrackingDetailsDto();
      returCompleted.setStepNumber(4);
      returCompleted.setStatusName(OrderStatusConstants.COMPLETED_ORDER_STATUS);
      returCompleted.setStatusCode(SwitchEShopOrderEnum.Return_Completed.getValue());
      returCompleted.setIsDone(0);
      returCompleted.setStatusDate(System.currentTimeMillis());
      trackingList.add(returCompleted);

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

  public static OrderTrackingDetailsDto getTrackingDetailByStatus(SwitchEShopOrderEnum orderEnum,
          List<OrderTrackingDetailsDto> trackinglist) {
    OrderTrackingDetailsDto trackingDetails = null;
    try {
      trackingDetails = trackinglist.stream().filter(obj -> obj.getStatusCode() == orderEnum
              .getValue()).findFirst().get();
    } catch (Exception e) {
      trackingDetails = null;
    }
    return trackingDetails;
  }

}
