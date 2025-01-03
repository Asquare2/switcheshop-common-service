
package com.lgitsolution.switcheshopcommon.order.dto;

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
}
