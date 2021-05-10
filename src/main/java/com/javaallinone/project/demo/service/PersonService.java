package com.javaallinone.project.demo.service;

import com.javaallinone.project.demo.domain.Block;
import com.javaallinone.project.demo.domain.Person;
import com.javaallinone.project.demo.repository.BlockRepository;
import com.javaallinone.project.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
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
        return personRepository.findById(id).get();
    }

    public List<Person> getPeopleByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> getPeopleByBloodType(String bloodType) {
        return personRepository.findByBloodType(bloodType);
    }
//    public List<Person> getPeopleByBirthDayOfMonth(int month){
//        return personRepository.findByMonth(month);
//    }
}
