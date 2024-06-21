package com.oadl.spring.service;

import com.oadl.spring.entity.child.Guest;
import com.oadl.spring.repository.GuestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

  @Autowired
  GuestRepository guestRepository;

  public Guest create(Guest guest) {
    return guestRepository.save(guest);
  }

  public List<Guest> findAll() {
    return guestRepository.findAll();
  }

}
