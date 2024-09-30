
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.returnorder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnOrderResponse {

  private int status;
  private ReturenOrderPayload payload;
  private String message;
  private int status_code;

}
