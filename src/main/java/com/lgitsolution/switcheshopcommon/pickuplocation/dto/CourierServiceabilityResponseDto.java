
package com.lgitsolution.switcheshopcommon.pickuplocation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourierServiceabilityResponseDto {

  String fromDate;

  String toDate;

  Boolean isCodAvailable;
}
