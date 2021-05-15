package com.javaallinone.project.demo.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PersonDto {
    private String name;

    private LocalDate birthday;

    private String hobby;

    private String address;

    private String phoneNumber;

    private String job;
}
