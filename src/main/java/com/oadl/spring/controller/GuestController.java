package com.oadl.spring.controller;

import com.oadl.spring.entity.child.Guest;
import com.oadl.spring.service.GuestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("guest")
public class GuestController {

  @Autowired
  GuestService guestService;

  @GetMapping("all")
  public ResponseEntity<List<Guest>> findAll() {
    return ResponseEntity.ok(guestService.findAll());
  }

}
