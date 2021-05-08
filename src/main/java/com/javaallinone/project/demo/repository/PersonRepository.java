package com.javaallinone.project.demo.repository;

import com.javaallinone.project.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
