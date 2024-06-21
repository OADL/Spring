package com.oadl.spring.service;

import com.oadl.spring.entity.SmallAppData;
import com.oadl.spring.repository.SmallAppDataRepository;
import org.springframework.stereotype.Service;

@Service
public class SmallAppDataService {

    private final SmallAppDataRepository smallAppDataRepository;

    public SmallAppDataService(SmallAppDataRepository smallAppDataRepository) {
        this.smallAppDataRepository = smallAppDataRepository;
    }

    public SmallAppData create(SmallAppData smallAppData) {
        return smallAppDataRepository.save(smallAppData);
    }
}
