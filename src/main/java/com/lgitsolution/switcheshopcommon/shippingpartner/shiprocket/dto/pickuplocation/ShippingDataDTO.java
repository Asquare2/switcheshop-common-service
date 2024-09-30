
package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickuplocation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingDataDTO {

  private List<ShippingAddressDTO> shipping_address;
  private String allow_more;
  private boolean is_blackbox_seller;
  private String company_name;
  private List<Object> recent_addresses;
}
