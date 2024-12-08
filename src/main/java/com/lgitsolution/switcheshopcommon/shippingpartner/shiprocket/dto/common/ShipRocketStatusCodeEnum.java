package com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.common;


public enum ShipRocketStatusCodeEnum {

  OK(200),
  Accepted(202),
  BadRequest(400),
  Unauthorized(401),
  NotFound(404),
  MethodNotAllowed(405),
  InvalidIdPassword(403),
  UnprocessableEntity(422),
  TooManyRequests(429),
  ServerErrors(500);

  private int value;

  private ShipRocketStatusCodeEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

}
