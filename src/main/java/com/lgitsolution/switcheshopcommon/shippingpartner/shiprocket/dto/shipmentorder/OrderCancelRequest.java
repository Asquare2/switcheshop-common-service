
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.shipmentorder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCancelRequest {

  private List<String> awbs;
}
