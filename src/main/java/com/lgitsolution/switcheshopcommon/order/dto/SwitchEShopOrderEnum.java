
package com.lgitsolution.switcheshopcommon.order.dto;

public enum SwitchEShopOrderEnum {

  // forward shipment
  Pending(0), Confirmed(1), Processing(2), Prepared(3), Shipped(4), Out_For_Delivery(5), Deliverd(
          6), Order_Cancelled_By_Customer(7), Order_Cancelled_By_Company(8),

  // return shipment
  Return_Pending(9), Return_Approved_Initiated(10), Return_Picked_Up(11), Return_Completed(
          12), Return_Request_Canceled_by_Company(13), Return_Request_Canceled_by_Customer(
                  14), Return_Delivered_To_Company(15);

  private int value;

  private SwitchEShopOrderEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
