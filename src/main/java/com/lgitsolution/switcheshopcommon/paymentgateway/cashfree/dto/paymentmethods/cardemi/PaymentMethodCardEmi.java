
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.cardemi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodCardEmi {

  private String channel;

  private String card_number;

  private String card_network;

  private String card_type;

  private String card_country;

  private String card_bank_name;

  private String card_network_reference_id;

  private Double emi_tenure;

  private EmiDetailsDto emi_details;

}
