
package com.lgitsolution.switcheshopcommon.subscriptionservice.dto;

public enum SubscriptionStatusEnum {
  free, active, expired, prepaid, paused, inprogress, failed

  // below status is only for calling by payment service
  , success
}
