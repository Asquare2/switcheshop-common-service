
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundSplitsDto {

  /** Vendor id created in Cashfree system */
  private String vendor_id;

  /** Amount which will be associated with this vendor */
  private Double amount;

  /** Percentage of order amount which shall get added to vendor account */
  private Double percentage;

  /**
   * Custom Tags in thr form of {"key":"value"} which can be passed for an order. A maximum of 10
   * tags can be added
   */
  private Map<String, String> tags;

}
