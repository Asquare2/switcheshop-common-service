package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.lgitsolution.switcheshopcommon.common.dto.CommonConstants;
import com.lgitsolution.switcheshopcommon.customer.dto.CustomerAddressDetails;
import com.lgitsolution.switcheshopcommon.order.dto.OrderDetailsDto;
import com.lgitsolution.switcheshopcommon.order.dto.OrderItemsDto;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.couriers.GenerateAWBRequest;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.labelandmanifest.LabelManifestRequestDto;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickupschedule.PickupScheduleRequestDto;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder.OrderCancelRequest;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder.OrderItem;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder.ShipmentOrderIRequestDto;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static ShipmentOrderIRequestDto createShipmentOrderRequestDto(
          OrderDetailsDto orderDetailsDto, String pickupLocation) {
    ShipmentOrderIRequestDto dto = new ShipmentOrderIRequestDto();
    dto.setOrder_id(orderDetailsDto.getItemId());
    dto.setOrder_date(CommonUtility.getLocalDate(orderDetailsDto.getCreatedAt()).toString());
    dto.setPickup_location(pickupLocation);
    dto.setPayment_method(orderDetailsDto.getPaymenMethod());
    dto.setSub_total(Math.round(orderDetailsDto.getTotalPayable()));
    Map<String, String> packageDimensionsMap = orderDetailsDto.getPackageDimensionsMap();
    dto.setLength(Integer.parseInt(packageDimensionsMap.get(
            CommonConstants.ORDER_PACKAGE_DIMENTION_LENGTH)));
    dto.setBreadth(Integer.parseInt(packageDimensionsMap.get(
            CommonConstants.ORDER_PACKAGE_DIMENTION_BREADTH)));
    dto.setHeight(Integer.parseInt(packageDimensionsMap.get(
            CommonConstants.ORDER_PACKAGE_DIMENTION_HEIGHT)));
    dto.setWeight(Integer.parseInt(packageDimensionsMap.get(
            CommonConstants.ORDER_PACKAGE_DIMENTION_WEIGHT)));
    List<OrderItem> srItemsList = new ArrayList<OrderItem>();
    List<OrderItemsDto> orderItemsDtoList = orderDetailsDto.getOrderItemsDtoList();

    orderItemsDtoList.forEach(o -> {
      OrderItem item = new OrderItem();
      item.setUnits(o.getQuantity());
      item.setName(o.getTitle());
      item.setSku(o.getSkuName());
      item.setSelling_price(o.getSellingPrice().toString());
      srItemsList.add(item);
    });

    dto.setOrder_items(srItemsList);
    CustomerAddressDetails address = orderDetailsDto.getCustomerAddressDetails();
    dto.setBilling_customer_name(address.getBilling_customer_name());
    dto.setBilling_last_name(address.getBilling_last_name());
    dto.setBilling_city(address.getBilling_city());
    dto.setBilling_country(address.getBilling_country());
    dto.setBilling_address(address.getBilling_address());
    dto.setBilling_alternate_phone(address.getBilling_alternate_phone());
    dto.setBilling_email(address.getBilling_email());
    dto.setBilling_phone(address.getBilling_phone());
    dto.setBilling_pincode(address.getBilling_pincode());
    dto.setBilling_state(address.getBilling_state());
    dto.setShipping_is_billing(address.isShipping_is_billing());
    if (!address.isShipping_is_billing()) {
      dto.setShipping_customer_name(address.getShipping_customer_name());
      dto.setShipping_last_name(address.getShipping_last_name());
      dto.setShipping_city(address.getShipping_city());
      dto.setShipping_country(address.getShipping_country());
      dto.setShipping_address(address.getShipping_address());
      dto.setShipping_alternate_phone(address.getShipping_alternate_phone());
      dto.setShipping_email(address.getShipping_email());
      dto.setShipping_phone(address.getShipping_phone());
      dto.setShipping_pincode(address.getShipping_pincode());
      dto.setShipping_state(address.getShipping_state());
    }

    return dto;
  }

  public static OrderCancelRequest createOrderCancelRequestDto(String awbCode) {
    OrderCancelRequest dto = new OrderCancelRequest();
    dto.setAwbs(Arrays.asList(awbCode));
    return dto;
  }

  public static GenerateAWBRequest createGenerateAWBCodeRequestDto(int shipmentId) {
    GenerateAWBRequest awbRequest = new GenerateAWBRequest();
    awbRequest.setShipment_id(shipmentId);
    return awbRequest;
  }

  public static PickupScheduleRequestDto createPickupScheduleRequestDto(int shipmentId) {
    PickupScheduleRequestDto request = new PickupScheduleRequestDto();
    request.setShipment_id(shipmentId);
    return request;
  }

  public static LabelManifestRequestDto createLabelManifestRequestDto(int shipmentId) {
    LabelManifestRequestDto request = new LabelManifestRequestDto();
    request.setShipment_id(Arrays.asList(shipmentId));
    return request;
  }
}