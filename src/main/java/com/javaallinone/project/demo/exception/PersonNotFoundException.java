package com.javaallinone.project.demo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonNotFoundException extends RuntimeException {

    private static final String message = "Person Entity가 존재하지 않습니다.";

    public PersonNotFoundException(){
        super(message);
        log.info("Person Entity가 존재하지 않습니다.");
    }
}
