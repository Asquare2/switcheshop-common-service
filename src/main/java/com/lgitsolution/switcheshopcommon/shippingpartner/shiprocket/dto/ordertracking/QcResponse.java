
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.ordertracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QcResponse {

  private String qc_image;
  private String qc_failed_reason;
}
