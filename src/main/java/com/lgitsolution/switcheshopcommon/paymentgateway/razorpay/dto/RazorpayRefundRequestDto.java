
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayRefundRequestDto {

  /**
   * The amount to be refunded. Amount should be in the smallest unit of the currency in which the
   * payment was made. In the case of three decimal currencies, such as KWD, BHD and OMR, to refund
   * a payment of 295.991, pass the value as 295990. And in the case of zero decimal currencies such
   * as JPY, to refund a payment of 295, pass the value as 295. For a partial refund, enter a value
   * lesser than the payment amount. For example, if the payment amount is ₹1,500.00 and you want to
   * refund only ₹500.00, you must pass 50000. For full refund, enter the entire payment amount. If
   * the amount parameter is not passed, the entire payment amount will be refunded.
   */
  private Integer amount;

  /**
   * The speed at which the refund is to be processed. The default value is normal. Refund will be
   * processed via the normal speed, and the customer will receive the refund within 5-7 working
   * days.
   */
  private RazorpayRefundModeEnum speed;

  /**
   * Key-value pairs used to store additional information. A maximum of 15 key-value pairs can be
   * included.
   */
  private Map<String, String> notes;

  /** A unique identifier provided by you for your internal reference. */
  private String receipt;

  public Double getAmount() {
    return Double.valueOf(this.amount / 100);
  }

}
