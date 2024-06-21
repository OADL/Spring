package com.oadl.spring.repository;

import com.oadl.spring.dto.PersonDTO;
import com.oadl.spring.entity.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  @Query("select p.id as id, p.name as name, p.age as age from Person p")
  List<PersonDTO> findAllPersons();

}
