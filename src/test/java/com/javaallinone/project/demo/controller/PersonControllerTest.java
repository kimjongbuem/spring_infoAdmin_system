package com.javaallinone.project.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaallinone.project.demo.dto.PersonDto;
import com.javaallinone.project.demo.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
class PersonControllerTest {
    @Autowired
    PersonController controller;
    private MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/1").contentType(MediaType.APPLICATION_JSON)
        ). andExpect(status().isOk());
    }



    @Test
    void postPerson() throws Exception {

        PersonDto personDto = new PersonDto("kjb", LocalDate.now(), "game","pangyo","010-2762-6870", "programmer");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/person")
                .contentType(MediaType.APPLICATION_JSON).content(toJsonString(personDto))
        ). andExpect(status().isCreated());
    }

    @Test
    void modifyPerson() throws Exception {

        PersonDto personDto = new PersonDto("kjb", LocalDate.now(), "game","pangyo","010-2762-6870", "programmer");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/person/put/1")
                .contentType(MediaType.APPLICATION_JSON).content(toJsonString(personDto))
        ). andExpect(status().isOk());


        assertAll(
                () -> assertEquals("game", personRepository.findById(1L).get().getHobby()),
                () -> assertEquals("programmer", personRepository.findById(1L).get().getJob()),
                () -> assertEquals("010-2762-6870", personRepository.findById(1L).get().getPhoneNumber()),
                () -> assertEquals("pangyo", personRepository.findById(1L).get().getAddress())
        );
    }

    @Test
    void modifyPersonifNameDifferent() throws Exception {

        PersonDto personDto = new PersonDto("kbj", LocalDate.now(), "game","pangyo","010-2762-6870", "programmer");

        assertThrows(NestedServletException.class, ()-> mockMvc.perform(MockMvcRequestBuilders.put("/api/person/put/1")
                .contentType(MediaType.APPLICATION_JSON).content(toJsonString(personDto))
        ). andExpect(status().isOk()));

    }


    @Test
    void modifyName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/person/patch/1")
                .param("name", "kbj")
        ). andExpect(status().isOk());

        assertEquals("kbj", personRepository.findById(1L).get().getName());
    }

    @Test
    void deletePerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/person/delete/1")
        ). andExpect(status().isOk());

        assertTrue((personRepository.findPeopleDeleted().stream().anyMatch(person -> person.getId() == 1L)));
    }

    private String toJsonString(PersonDto personDto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(personDto);
    }

}