package com.oadl.spring.controller;

import com.oadl.spring.entity.child.Employee;
import com.oadl.spring.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @GetMapping("all")
  public ResponseEntity<List<Employee>> findAll() {
    return ResponseEntity.ok(employeeService.findAll());
  }

}
