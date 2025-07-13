
package com.lgitsolution.switcheshopcommon.paymentgateway.razorpay.Utility;

public class RazorpayUtility {

  /**
   * Converts a Float rupee amount to Integer paise amount for Razorpay.
   *
   * @param amountRupees Float value in rupees (e.g., 123.45f)
   * @return Integer value in paise (e.g., 12345)
   */
  public static Integer toRazorpayAmount(Float amountRupees) {
    // Multiply by 100 and round to nearest integer
    return Math.round(amountRupees * 100);
  }

}
