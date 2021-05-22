package com.javaallinone.project.demo.controller;

import com.javaallinone.project.demo.domain.Person;
import com.javaallinone.project.demo.dto.PersonDto;
import com.javaallinone.project.demo.exception.PersonNotFoundException;
import com.javaallinone.project.demo.exception.RenameNotPermittedException;
import com.javaallinone.project.demo.exception.dto.ErrResponse;
import com.javaallinone.project.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/api/person")
    public Page<Person> getAll(@PageableDefault Pageable pageable){
        return personService.getAll(pageable);
    }

    @GetMapping(value = "/api/person/{id}")
    public Person getPerson(@PathVariable("id") long id){
        return personService.getPerson(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/api/person/post")
    public void postPerson(@RequestBody @Valid PersonDto personDto){
        personService.put(personDto);
    }

    @PutMapping(value = "/api/person/put/{id}")
    public void modifyPerson(@PathVariable("id") Long id, @RequestBody PersonDto personDto){
        personService.modify(id, personDto);

    }

    @PatchMapping(value = "/api/person/patch/{id}")
    public void patchPerson(@PathVariable("id") Long id, String name){
        personService.modify(id, name);
    }

    @DeleteMapping(value = "/api/person/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id){
        personService.delete(id);
    }

}
