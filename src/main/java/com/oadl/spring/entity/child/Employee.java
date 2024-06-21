package com.oadl.spring.entity.child;

import com.oadl.spring.entity.Person;
import com.oadl.spring.enums.PersonType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(PersonType.EMPLOYEE_VALUE)
public class Employee extends Person {

  String department;

}
