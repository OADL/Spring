package com.oadl.spring.service;

import com.oadl.spring.entity.AppData;
import com.oadl.spring.exception.custom.NotFoundException;
import com.oadl.spring.repository.AppDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AppDataService {

    private final String applicationDomain;
    private final AppDataRepository appDataRepository;

    public AppDataService(String applicationDomain, AppDataRepository appDataRepository, SmallAppDataService smallAppDataService) {
        this.applicationDomain = applicationDomain;
        this.appDataRepository = appDataRepository;
    }

    public Long countAppData() {
        log.info(applicationDomain);
        return appDataRepository.count();
    }

    public AppData getAppData(Long id) {
        log.info(applicationDomain);
        Optional<AppData> appData = appDataRepository.findById(id);
        return appData.orElseThrow(() -> new NotFoundException("There isn't appData with id [" + id + "]"));
    }

    public List<AppData> getAll() {
        return appDataRepository.findAll();
    }

    public AppData createAppData(AppData appData) {
        return appDataRepository.save(appData);
    }
}
