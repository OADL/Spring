package com.oadl.spring.repository;

import com.oadl.spring.entity.SmallAppData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmallAppDataRepository extends JpaRepository<SmallAppData, Long> {
}
