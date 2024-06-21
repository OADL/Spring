package com.oadl.spring.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum GuestPrivilege {

  ALL_INCLUSIVE("allInclusive"),
  BREAKFAST("breakfast");

  private final String value;

  GuestPrivilege(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }

  @JsonCreator
  public static GuestPrivilege fromValue(String value) {
    return Arrays.stream(values()).filter(privilege -> privilege.value.equalsIgnoreCase(value)).findFirst().get();
  }
}
