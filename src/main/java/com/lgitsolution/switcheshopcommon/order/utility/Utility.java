
package com.lgitsolution.switcheshopcommon.order.utility;

import java.util.List;

import com.lgitsolution.switcheshopcommon.order.dto.OrderDetailsDto;
import com.lgitsolution.switcheshopcommon.order.dto.OrderItemsDto;
import com.lgitsolution.switcheshopcommon.order.model.OrderDetails;
import com.lgitsolution.switcheshopcommon.order.model.OrderItems;

public class Utility {

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
    orderDetails.setCreatedAt(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getLocalDateTime(orderDetilsDto.getCreatedAt()));
    orderDetails.setModifiedAt(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getLocalDateTime(orderDetilsDto.getModifiedAt()));
    orderDetails.setDeliveryPartnerResponse(orderDetilsDto.getDeliveryPartnerResponse());
    List<OrderItemsDto> orderItemsDtoList = orderDetilsDto.getOrderItemsDtoList();
    orderDetails.setItemId(orderDetilsDto.getItemId());
    orderDetails.setPackageDimensions(com.lgitsolution.switcheshopcommon.common.util.Utility
            .convertMapToJsonString(orderDetilsDto.getPackageDimensionsMap()));
    orderItemsDtoList.forEach(dto -> orderDetails.getOrderItemsList().add(convertDtoToModel(dto)));
    orderDetails.setTrackingData(orderDetilsDto.getTrackingData());
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
    orderDetailsDto.setCreatedAt(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getLocalDateTimeMillis(orderDetails.getCreatedAt()));
    orderDetailsDto.setModifiedAt(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getLocalDateTimeMillis(orderDetails.getModifiedAt()));
    orderDetailsDto.setDeliveryPartnerResponse(orderDetails.getDeliveryPartnerResponse());
    orderDetailsDto.setPackageDimensionsMap(com.lgitsolution.switcheshopcommon.common.util.Utility
            .convertJsonStringToMap(orderDetails.getPackageDimensions()));
    orderDetailsDto.setItemId(orderDetails.getItemId());
    List<OrderItems> orderItemsList = orderDetails.getOrderItemsList();
    if (orderItemsList != null && !orderItemsList.isEmpty()) {
      orderItemsList.forEach(o -> orderDetailsDto.getOrderItemsDtoList().add(convertModelToDto(o)));
    }
    orderDetailsDto.setTrackingData(orderDetails.getTrackingData());
    return orderDetailsDto;
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
    orderItems.setCreatedAt(com.lgitsolution.switcheshopcommon.common.util.Utility.getLocalDateTime(
            dto.getCreatedAt()));
    orderItems.setModifiedAt(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getLocalDateTime(dto.getModifiedAt()));
    orderItems.setOrderDetailId(dto.getOrderDetailId());
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
    orderItemsDto.setCreatedAt(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getLocalDateTimeMillis(orderItems.getCreatedAt()));
    orderItemsDto.setModifiedAt(com.lgitsolution.switcheshopcommon.common.util.Utility
            .getLocalDateTimeMillis(orderItems.getModifiedAt()));
    if (orderItems.getOrderDetailId() != null) {
      orderItemsDto.setOrderDetailId(orderItems.getOrderDetailId());
    }
    return orderItemsDto;
  }

}
