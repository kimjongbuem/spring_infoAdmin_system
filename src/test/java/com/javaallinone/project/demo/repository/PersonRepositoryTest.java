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
        Person person = new Person("martin" , "A", 10);

        personRepository.save(person);
        System.out.println(personRepository.findAll());
        List<Person> peoples = personRepository.findAll();
        assertThat(peoples.size()).isEqualTo(1);
        assertThat(peoples.get(0).getName()).isEqualTo("martin");
    }

    @Test
    void monthOfBirthDay(){
        givenPerson("kjb",26,"B", LocalDate.of(1996, 3, 7));
        givenPerson("kcb",54,"B", LocalDate.of(1968, 3, 24));
        givenPerson("kej",24,"O", LocalDate.of(1998, 3, 25));
        givenPerson("lms",52,"A", LocalDate.of(1970, 12, 28));

        List<Person> person = personRepository.findByMonth(3 , 24);

        for (Person p : person) {
            System.out.println("name: " + p.getName() + " " + "age: " + p.getAge() +
                    "blood : " + p.getBloodType() + " " + "BirthDay: " + p.getBirthday());
        }
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate localDate){
        Person person = new Person(name,  bloodType, age);
        person.setBirthday(new Birthday(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()));
        personRepository.save(person);
    }
}