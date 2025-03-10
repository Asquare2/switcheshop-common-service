
package com.lgitsolution.switcheshopcommon.order.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderStatusDetail {

  private String name = "";

  private int count = 0;

  private int statusCode = -1;

  // this list we are creating because if any additional code then we can put here example :
  // Paid_Order_Cancelled_By_Customer(16)
  private List<Integer> additionalStatusCodeList = null;

  private int id;
}
