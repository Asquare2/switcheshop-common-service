
package com.lgitsolution.switcheshopcommon.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTrackingDetailsDto {

  private Long statusDate;

  private String statusName;

  private Integer isDone = 0;

  private Integer stepNumber;

  private int statusCode;

}
