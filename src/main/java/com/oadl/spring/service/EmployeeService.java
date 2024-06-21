package com.oadl.spring.service;

import com.oadl.spring.entity.child.Employee;
import com.oadl.spring.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;

  public Employee create(Employee employee) {
    return employeeRepository.save(employee);
  }

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

}
