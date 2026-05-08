package com.oadl.spring.config;

import com.oadl.spring.entity.Person;
import com.oadl.spring.entity.Role;
import com.oadl.spring.entity.User;
import com.oadl.spring.entity.child.Employee;
import com.oadl.spring.entity.child.Guest;
import com.oadl.spring.enums.GuestPrivilege;
import com.oadl.spring.service.EmployeeService;
import com.oadl.spring.service.GuestService;
import com.oadl.spring.service.PersonService;
import com.oadl.spring.service.RoleService;
import com.oadl.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StartupConfig implements CommandLineRunner {

    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    PersonService personService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    GuestService guestService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Custom Log: Startup Config");
        Role role = new Role();
        role.setName("admin");
        roleService.create(role);

        User user = new User();
        user.setUsername("omar");
        user.setPassword("omar");
        user.addRole(role);
        userService.create(user);
    }
}
