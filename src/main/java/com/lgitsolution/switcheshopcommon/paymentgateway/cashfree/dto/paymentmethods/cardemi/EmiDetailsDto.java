
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.cardemi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmiDetailsDto {

  private Double emi_amount;

  private Double emi_tenure;

  private Double emi_interest;

}
