package com.javaallinone.project.demo.repository;

import com.javaallinone.project.demo.domain.Person;
import com.javaallinone.project.demo.dto.Birthday;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        List<Person> peoples = personRepository.findAll();
        assertThat(peoples.size()).isEqualTo(7);
        assertThat(peoples.get(0).getName()).isEqualTo("kjb");
    }


    @Test
    void findByName(){
        List<Person> persons = personRepository.findByName("ims");
        assertAll(
                ()->assertThat(persons.get(0).getName()).isEqualTo("ims"),
                ()->assertThat(persons.get(0).getBirthday()).isEqualTo(Birthday.of(LocalDate.of(1970 , 12, 28)))
        );
    }

    @Test
    void findByNameIsDeleted(){
        List<Person> persons = personRepository.findByName("kkk");
        assertThat(persons.size()).isEqualTo(0);
    }

    @Test
    void monthOfBirthDay(){
        List<Person> person = personRepository.findByBirthDayMonth(3);

        assertThat(person.size()).isEqualTo(3);
    }

    @Test
    void findPeopleDeleted(){
        List<Person> person = personRepository.findPeopleDeleted();
        assertThat(person.size()).isEqualTo(1);

        assertAll(
                ()->assertThat(person.get(0).getName()).isEqualTo("kkk")
        );
    }
}