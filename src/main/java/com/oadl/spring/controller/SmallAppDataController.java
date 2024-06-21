package com.oadl.spring.controller;

import com.oadl.spring.entity.SmallAppData;
import com.oadl.spring.service.SmallAppDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("smallAppData")
public class SmallAppDataController {

    private final SmallAppDataService smallAppDataService;

    public SmallAppDataController(SmallAppDataService smallAppDataService) {
        this.smallAppDataService = smallAppDataService;
    }

    @PostMapping("create")
    ResponseEntity<SmallAppData> create(@RequestBody SmallAppData smallAppData) {
        return new ResponseEntity<>(smallAppDataService.create(smallAppData), HttpStatus.CREATED);
    }
}
