
package com.lgitsolution.switcheshopcommon.paymentgateway.cashfree.dto;

public class CashfreeConstants {

  /** The constant of the ACTIVE status of cashfree payment order. */
  public static final String CASHFREE_ORDER_STATUS_ACTIVE = "ACTIVE";

  /** The constant of the PAID status of cashfree payment order. */
  public static final String CASHFREE_ORDER_STATUS_PAID = "PAID";

  /** The constant of the currency type indian rupee. */
  public static final String CASHFREE_CURRENCY_TYPE_INDIAN_RUPEE = "INR";

  /** The constant of the supported payment methods. e.g. credit card, debit card etc. */
  public static final String CASHFREE_PAYMENT_METHODS = "cc,dc,upi";

  /* Error type constants */

  /** The constant of the invalid request error. */
  public static final String CASHFREE_INVALID_REQUEST_ERROR = "invalid_request_error";

  /** The constant of the authentication error. */
  public static final String CASHFREE_AUTHENTICATION_ERROR = "authentication_error";

  /** The constant of the idempotency error. */
  public static final String CASHFREE_IDEMPOTENCY_ERROR = "idempotency_error";

  /** The constant of the rate limit error. */
  public static final String CASHFREE_RATE_LIMIT_ERROR = "rate_limit_error";

}
