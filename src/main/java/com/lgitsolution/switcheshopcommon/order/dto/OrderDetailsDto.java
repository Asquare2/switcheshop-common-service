
package com.lgitsolution.switcheshopcommon.order.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.customer.dto.CustomerAddressDetails;
import com.lgitsolution.switcheshopcommon.orderreturn.dto.ReturnDetailDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.PaymentDetailDto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailsDto {

  public static final String ID = "id";
  public static final String CUSTOMER_DETAILS_ID = "customerDetailsId";
  public static final String TOTAL_AMOUNT = "totalAmount";
  public static final String TOTAL_PAYABLE = "totalPayable";
  public static final String TOTAL_PAYMENT_GATWAY_PAYABLE = "totalPaymentGatwayPayable";
  public static final String STATUS = "status";
  public static final String ORDER_STATUS_DETAIL = "orderStatusDetail";
  public static final String ORDER_NOTES = "orderNotes";
  public static final String DELIVERY_CHARGE = "deliveryCharge";
  public static final String WALLET_USED = "walletUsed";
  public static final String PROMOCODE_NAME = "promocodeName";
  public static final String PROMOCODE_DISCOUNT = "promocodeDiscount";
  public static final String PROMOCODE_ID = "promocodeId";
  public static final String CREATED_AT = "createdAt";
  public static final String MODIFIED_AT = "modifiedAt";
  public static final String DELIVERY_PARTNER_RESPONSE = "deliveryPartnerResponse";
  public static final String PACKAGE_DIMENSIONS_MAP = "packageDimensionsMap";
  public static final String ITEM_ID = "itemId";
  public static final String TRACKING_DATA = "trackingData";
  public static final String ORDER_ITEMS_DTO_LIST = "orderItemsDtoList";
  public static final String PAYMENT_METHOD = "paymentMethod";
  public static final String PAYMENT_DETAIL_DTO = "paymentDetailDto";
  public static final String CUSTOMER_ADDRESS_DETAILS = "customerAddressDetails";
  public static final String OUT_OF_STOCK = "outOfStock";
  public static final String PICKUP_SCHEDULED_DATE = "pickupScheduledDate";
  public static final String PICKUP_BOOKED_DATE = "pickupBookedDate";
  public static final String DELIVERY_PARTNER_ORDER_ID = "deliveryPartnerOrderId";
  public static final String SHIPMENT_ID = "shipmentId";
  public static final String AWB_CODE = "awbCode";
  public static final String COURIER_COMPANY_ID = "courierCompanyId";
  public static final String COURIER_NAME = "courierName";
  public static final String DISPLAYED_TRACKING_LIST = "displayedTrackingList";
  public static final String PICKUP_LOCATION = "pickupLocation";
  public static final String PICKUP_LOCATION_NAME = "pickupLocationName";
  public static final String IS_APPLICABLE_FOR_RETURN = "isApplicableForReturn";
  public static final String IS_TO_SHOW_INVOICE_BUTTON = "isToShowInvoiceButton";
  public static final String NO_OF_ALLOWED_RETURNABLE_DAYS = "noOfAllowdReturableDays";
  public static final String RETURN_DETAIL_ID = "returnDetailId";
  public static final String IS_APPLICABLE_FOR_CANCEL = "isApplicableForCancel";
  public static final String RETURN_DETAILS_LIST = "returnDetailsList";

  /*--------------------------------------------------------------------------------------*/

  private Integer id;

  private Integer customerDetailsId;

  private Float totalAmount;

  private Float totalPayable;

  private Float totalPaymentGatwayPayable;

  private Integer status;

  private OrderStatusDetail orderStatusDetail;

  private String orderNotes;

  private Float deliveryCharge;

  private Float walletUsed;

  private String promocodeName;

  private Float promocodeDiscount;

  private Integer promocodeId;

  private Long createdAt;

  private Long modifiedAt;

  private String deliveryPartnerResponse;

  private Map<String, String> packageDimensionsMap;

  private String itemId;

  private String trackingData;

  private List<OrderItemsDto> orderItemsDtoList = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  private OrderPaymentMethod paymentMethod;

  private PaymentDetailDto paymentDetailDto;

  private CustomerAddressDetails customerAddressDetails;

  private int outOfStock = 0;

  private Long pickupScheduledDate;

  private String pickupBookedDate;

  private String deliveryPartnerOrderId;

  private String shipmentId;

  private String awbCode;

  private String courierCompanyId;

  private String courierName;

  private List<OrderTrackingDetailsDto> displayedTrackingList;

  private Long pickupLocation;

  private String pickupLocationName;

  private boolean isApplicableForReturn;

  private boolean isToShowInvoiceButton;

  // will soft code it
  private Integer noOfAllowdReturableDays = 7;

  private Integer returnDetailId;

  private boolean isApplicableForCancel;

  private List<ReturnDetailDto> returnDetailsList = null;

}
