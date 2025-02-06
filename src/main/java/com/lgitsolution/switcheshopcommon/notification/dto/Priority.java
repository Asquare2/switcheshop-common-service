package com.lgitsolution.switcheshopcommon.notification.dto;

public enum Priority {
  LOW("Low"),
  MEDIUM("Medium"),
  HIGH("High");

  private String value;

  Priority(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static Priority valueOfLabel(String value) {
    for (Priority priority : Priority.values()) {
      if (priority.value.equalsIgnoreCase(value)) {
        return priority;
      }
    }
    throw new IllegalArgumentException("Invalid priority: " + value);
  }
}
