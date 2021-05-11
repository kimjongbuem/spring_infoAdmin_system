package com.javaallinone.project.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PersonControllerTest {
    @Autowired
    PersonController controller;
    private MockMvc mockMvc;

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
}