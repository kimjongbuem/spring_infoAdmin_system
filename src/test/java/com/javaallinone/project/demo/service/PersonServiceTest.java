package com.javaallinone.project.demo.service;

import com.javaallinone.project.demo.domain.Person;
import com.javaallinone.project.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void getPeopleByName(){
        List<Person> people = personService.getPeopleByName("kcb");
        System.out.println(people.size()+" "+people.get(0).getName() + " "+ people.get(0).getAge());
    }

    @Test
    void getPerson(){
        Person person = personService.getPerson(3L);
        assertThat(person.getName()).isEqualTo("kcb");
    }

    @Test
    void getPeopleByBirthDayOfMonth(){
        List<Person> people = personService.getPeopleByBirthDayOfMonth(3);
        assertThat(people.size()).isEqualTo(3);
    }
}