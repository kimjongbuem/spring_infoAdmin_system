package com.javaallinone.project.demo.controller;

import com.javaallinone.project.demo.domain.Person;
import com.javaallinone.project.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/api/person/{id}")
    public Person getPerson(@PathVariable("id") long id){
        return personService.getPerson(id);
    }
}
