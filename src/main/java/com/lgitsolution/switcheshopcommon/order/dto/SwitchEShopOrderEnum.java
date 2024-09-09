package com.lgitsolution.switcheshopcommon.order.dto;


public enum SwitchEShopOrderEnum {

  Pending(0), Confirmed(1), Ready_To_Ship(2), Shipped(3), Out_For_Delivery(4), Deliverd(
          5), Order_Cancelled_By_Customer(6), Order_Cancelled_By_Company(7);

  private int value;

  private SwitchEShopOrderEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
