
package com.lgitsolution.switcheshopcommon.paymentgateway.dto;

public class PaymentDetailConstants {

  public static final String PAYMENT_PROVIDER_CASHFREE = "Cashfree";

  /**
   * The constant holds 'SwitchEShop' as a payment provider. This value is used for provider column
   * when user will select COD as a payment method.
   */
  public static final String PAYMENT_PROVIDER_SWITCHESHOP = "SwitchEShop";

  /** The constant holds the in progress payment status value. */
  public static final Integer PAYMENT_STATUS_IN_PROGRESS = 0;

  /** The constant holds the paid payment status value. */
  public static final Integer PAYMENT_STATUS_PAID = 1;

  /** The constant holds the failed payment status value. */
  public static final Integer PAYMENT_STATUS_FAILED = 2;

}
