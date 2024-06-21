package com.oadl.spring.controller;

import com.oadl.spring.dto.PersonDTO;
import com.oadl.spring.entity.Person;
import com.oadl.spring.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {

  @Autowired
  PersonService personService;

  @GetMapping("all")
  public ResponseEntity<List<PersonDTO>> findAll() {
    return ResponseEntity.ok(personService.findAll());
  }

}
