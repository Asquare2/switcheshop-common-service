
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetailsDto {

  private String customer_id;

  private String customer_email;

  private String customer_phone;

  private String customer_name;

  private String customer_bank_account_number;

  private String customer_bank_ifsc;

  private String customer_bank_code;

  private String customer_uid;

}
