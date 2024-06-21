package com.oadl.spring.entity.child;

import com.oadl.spring.entity.Person;
import com.oadl.spring.enums.GuestPrivilege;
import com.oadl.spring.enums.PersonType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(PersonType.GUEST_VALUE)
public class Guest extends Person {

  @Enumerated(EnumType.STRING)
  GuestPrivilege privilege;

}
