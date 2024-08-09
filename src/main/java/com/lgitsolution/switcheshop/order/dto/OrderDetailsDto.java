
package com.lgitsolution.switcheshop.order.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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

  private Long createdAt;

  private Long modifiedAt;

  private List<OrderItemsDto> orderItemsDtoList;

  private String deliveryPartnerResponse;

}
