package com.javaallinone.project.demo.controller;

import com.javaallinone.project.demo.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
class PersonControllerTest {
    @Autowired
    PersonController controller;
    private MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/1").contentType(MediaType.APPLICATION_JSON)
        .content( "{\"id\":1,\"name\":\"kjb\",\"age\":26,\"blood\":\"B\",\"birthday\":{\"birthday_year\":1996,\"birthday_month\":3,\"birthday_day\":7},\"hobby\":null,\"address\":null,\"job\":null,\"block\":{\"id\":1,\"name\":\"kjb\",\"reason\":null,\"sd\":null,\"ed\":null}")
        ). andExpect(status().isOk());
    }



    @Test
    void putPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/person?name=kjb&age=20&blood=A")
        .contentType(MediaType.APPLICATION_JSON).content("{\"name\" : \"kjb\" , \"age\":\"20\", \"blood\" : \"A\"}")
        ). andExpect(status().isCreated());
    }

    @Test
    void modifyPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/person/put/1")
                .contentType(MediaType.APPLICATION_JSON).content("{\"name\" : \"kjb\" , \"age\":\"20\"}")
        ). andExpect(status().isOk());
    }

    @Test
    void modifyName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/person/patch/1")
                .param("name", "kbj")
        ). andExpect(status().isOk());
    }

    @Test
    void deletePerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/person/delete/1")
        ). andExpect(status().isOk());

        System.out.println(personRepository.findPeopleDeleted().size());

    }
}