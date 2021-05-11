package com.javaallinone.project.demo.repository;

import com.javaallinone.project.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    List<Person> findByBlockIsNull();

    @Query(value = "select person from Person person where person.birthday.birthday_month = ?1")
    List<Person> findByBirthDayMonth(int month);

//    @Query(value = "select person from Person person where person.birthday.month = ?1 and person.birthday.day = ?2" ) // ,nativeQuery = true
//    List<Person> findByMonth(int month, int day);

    List<Person> findByBlood(String bloodType);
}
