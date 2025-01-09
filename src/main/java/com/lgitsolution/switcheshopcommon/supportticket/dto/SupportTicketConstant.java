package com.lgitsolution.switcheshopcommon.supportticket.dto;


public enum SupportTicketConstant {

  Open(0), InProgress(1), Closed(2);

  private int value;

  private SupportTicketConstant(int value) {
   this.value = value;
 }

  public int getValue() {
    return value;
  }
}
