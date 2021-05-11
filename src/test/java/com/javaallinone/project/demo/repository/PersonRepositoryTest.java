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
    void monthOfBirthDay(){
        List<Person> person = personRepository.findByBirthDayMonth(3);

        assertThat(person.size()).isEqualTo(3);
        assertThat(person.get(0).getBlood()).isEqualTo("B");

        for (Person p : person) {
            System.out.println("name: " + p.getName() + " " + "age: " + p.getAge() +
                    "blood : " + p.getBlood() + " " + "BirthDay: " + p.getBirthday());
        }
    }
}