package com.javaallinone.project.demo.service;

import com.javaallinone.project.demo.domain.Block;
import com.javaallinone.project.demo.domain.Person;
import com.javaallinone.project.demo.repository.BlockRepository;
import com.javaallinone.project.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks(){
        givenPeople();
        List<Person> lists = personService.getPeopleExcludeBlocks();
        for (Person list : lists) System.out.println(list.getName());
    }

    @Test
    void getPeopleByName(){
        givenPeople();
        List<Person> people = personService.getPeopleByName("martin");
        System.out.println(people.size()+" "+people.get(0).getName() + " "+ people.get(0).getAge());
    }

    @Test
    void getPeopleByBloodType(){
        givenPeople();
        List<Person> people = personService.getPeopleByBloodType("A");
        System.out.println(people.size()+" "+people.get(0).getName() + " "+ people.get(0).getAge());

        people = personService.getPeopleByBloodType("B");
        System.out.println(people.size()+" "+people.get(0).getName() + " "+ people.get(0).getAge());
    }

    @Test
    void cascadeTest(){
        givenPeople();
        List<Person> lists = personRepository.findAll();

        Person person = lists.get(0);
        person.getBlock().setSD(LocalDate.now());
        person.getBlock().setED(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(
                persons -> System.out.println(persons.getName() +" " +persons.getAge()+" "+persons.getBlock())
        );
//        personRepository.delete(person);
//        personRepository.findAll().forEach(
//                persons -> System.out.println(persons.getName() +" " +persons.getAge()+" "+persons.getBlock())
//        );
//        blockRepository.findAll().forEach(
//                blocks -> System.out.println(blocks.getED() + " " + blocks.getSD())
//        );
        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(
                persons -> System.out.println(persons.getName() +" " +persons.getAge()+" "+persons.getBlock())
        );
        blockRepository.findAll().forEach(
                blocks -> System.out.println(blocks.getED() + " " + blocks.getSD())
        );
    }

    @Test
    void getPerson(){
        givenPeople();
        Person person = personService.getPerson(3L);
        personRepository.findAll().forEach(
                persons -> System.out.println(persons.getId()+ " "+persons.getName() +" " +persons.getAge()+" "+persons.getBlock())
        );
    }

    private void givenBlockPerson(String name , int age){
        Person blockPerson = new Person(name, "B",age);
        blockPerson.setBlock(new Block(name));
        personRepository.save(blockPerson);
    }

    private void givenPeople() {
        givenBlockPerson("martin", 10 );
        givenPerson("david", 13 );
        givenPerson("denis", 12 );
        givenPerson("denis", 9 );
    }

    private void givenPerson(String name, int age) {
        Person person = new Person(name,"A", age);
        personRepository.save(person);

    }
}