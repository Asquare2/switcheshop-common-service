
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.app.PaymentMethodAppDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.banktransfer.PaymentMethodBankTransferDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.card.PaymentMethodCardDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.cardemi.PaymentMethodCardEmi;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.cardlessemi.PaymentMethodCardlessEmiDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.netbanking.PaymentMethodNetbankingDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.paylater.PaymentMethodPaylaterDto;
import com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto.paymentmethods.upi.PaymentMethodUpiDto;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPaymentsResponseDto {

  private String cf_payment_id;

  private String order_id;

  private String entity;

  private PaymentErrorDetailsDto error_details;

  private Boolean is_captured;

  private Double order_amount;

  private String payment_group;

  private String payment_currency;

  private Double payment_amount;

  private String payment_time;

  private String payment_completion_time;

  private String payment_status;

  private String payment_message;

  private String bank_reference;

  private String auth_id;

  private PaymentsAuthorizationDto authorization;

  private PaymentMethodCardDto card;

  private PaymentMethodNetbankingDto netbanking;

  private PaymentMethodUpiDto upi;

  private PaymentMethodAppDto app;

  private PaymentMethodCardlessEmiDto cardless_emi;

  private PaymentMethodPaylaterDto paylater;

  private PaymentMethodCardEmi emi;

  private PaymentMethodBankTransferDto banktransfer;

}
