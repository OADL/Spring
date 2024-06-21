package com.oadl.spring.service;

import com.oadl.spring.dto.PersonDTO;
import com.oadl.spring.entity.Person;
import com.oadl.spring.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  @Autowired
  PersonRepository personRepository;

  public Person create(Person person) {
    return personRepository.save(person);
  }

  public List<PersonDTO> findAll() {
    return personRepository.findAllPersons();
  }

}
