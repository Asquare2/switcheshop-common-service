
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.serviceability;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceabilityResponseDto {

  private Boolean company_auto_shipment_insurance_setting;
  private String currency;
  private ListData data;
  private String message;
  private int status_code;
}
