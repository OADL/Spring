package com.oadl.spring.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum PersonType {
  PERSON("person"),
  EMPLOYEE("employee"),
  GUEST("guest");

  private final String value;

  public static final String PERSON_VALUE = "person";
  public static final String EMPLOYEE_VALUE = "employee";
  public static final String GUEST_VALUE = "guest";

  PersonType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.value;
  }

  @JsonCreator
  public static PersonType fromValue(String value) {
    return Arrays.stream(values()).filter(person -> person.value.equalsIgnoreCase(value)).findFirst().get();
  }
}
