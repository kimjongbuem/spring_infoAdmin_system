package com.javaallinone.project.demo.controller;

import com.javaallinone.project.demo.domain.Person;
import com.javaallinone.project.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/api/person/{id}")
    public Person getPerson(@PathVariable("id") long id){
        return personService.getPerson(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/api/person")
    public void postPerson(Person person){
        personService.put(person);
    }

}
