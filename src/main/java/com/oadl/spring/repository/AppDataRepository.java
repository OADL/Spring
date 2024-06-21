package com.oadl.spring.repository;

import com.oadl.spring.entity.AppData;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppDataRepository extends JpaRepository<AppData, Long> {

    @Override
    @EntityGraph(attributePaths = {"smallAppData"})
    Optional<AppData> findById(Long id);

}
