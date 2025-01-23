
package com.lgitsolution.switcheshopcommon.orderreturn.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnDetailDto {

  private int id;
  private Integer orderId;
  private Integer orderItemId;
  private Integer replaceOrderId;
  private Integer paymentId;
  private Integer status;
  private String reason;
  private Integer requestedFor;
  private Integer paymentStatus;
  private String itemId;
  private String deliveryPartnerResponse;
  private String trackingData;
  private Long pickupScheduledDate;
  private String shipmentId;
  private String awbCode;
  private String courierCompanyId;
  private String courierName;
  private Long createdAt;
  private float totalApprovedAmount;
  private String rejectReason;
}
