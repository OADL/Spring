package com.oadl.spring.controller;

import com.oadl.spring.entity.AppData;
import com.oadl.spring.service.AppDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("appData")
public class AppDataController {
    private final AppDataService appDataService;

    public AppDataController(AppDataService appDataService) {
        this.appDataService = appDataService;
    }

//    @ResponseBody
    @GetMapping("count")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(appDataService.countAppData());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<AppData> get(@PathVariable Long id) {
        return ResponseEntity.ok(appDataService.getAppData(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<AppData>> all() {
        return ResponseEntity.ok(appDataService.getAll());
    }

    @PostMapping("create")
    public ResponseEntity<AppData> create(@RequestBody AppData appData) {
//        return ResponseEntity.created(ServletUriComponentsBuilder
//                    .fromCurrentRequestUri()
//                    .replacePath("appData")
//                    .pathSegment("get", appData.getId().toString())
//                    .build()
//                    .toUri())
//                .body(appDataService.createAppData(appData));
        return new ResponseEntity<>(appDataService.createAppData(appData), HttpStatus.CREATED);
    }

}
