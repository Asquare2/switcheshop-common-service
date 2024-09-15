
package com.lgitsolution.switcheshopcommon.slider.dto;

public enum SliderTypeEnum {

  FILTER(1), LINK(2);

  private int value;

  private SliderTypeEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

}
