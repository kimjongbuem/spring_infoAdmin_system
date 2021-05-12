package com.javaallinone.project.demo.service;

import com.javaallinone.project.demo.domain.Block;
import com.javaallinone.project.demo.domain.Person;
import com.javaallinone.project.demo.dto.Birthday;
import com.javaallinone.project.demo.dto.PersonDto;
import com.javaallinone.project.demo.repository.BlockRepository;
import com.javaallinone.project.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlocks(){
        return personRepository.findByBlockIsNull();
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> getPeopleByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> getPeopleByBloodType(String bloodType) {
        return personRepository.findByBlood(bloodType);
    }

    public List<Person> getPeopleByBirthDayOfMonth(int month){
        return personRepository.findByBirthDayMonth(month);
    }

    @Transactional
    public void put(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, PersonDto person) {
        Person personDB = personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디 존재 x"));

        personDB.set(person);

        personRepository.save(personDB);
    }

    @Transactional
    public void modify(Long id, String name) {
        Person personDB = personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디 존재 x"));

        personDB.setName(name); // 이름만 수정.

        personRepository.save(personDB);
    }
}
