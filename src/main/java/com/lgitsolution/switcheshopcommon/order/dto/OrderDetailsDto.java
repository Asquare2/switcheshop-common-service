
package com.lgitsolution.switcheshopcommon.order.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.customer.dto.CustomerAddressDetails;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.PaymentDetailDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailsDto {

  private Integer id;

  private Integer customerDetailsId;

  private Float totalAmount;

  private Float totalPayable;

  private Integer status;

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

  private String paymenMethod;

  private PaymentDetailDto paymentDetailDto;

  private CustomerAddressDetails customerAddressDetails;

  private int saleId;

  private int outOfStock = 0;

  private String pickupScheduledDate;

  private String pickupBookedDate;

  private String deliveryPartnerOrderId;

  private String shipmentId;

  private String awbCode;

  private String courierCompanyId;

  private String courierName;

}
