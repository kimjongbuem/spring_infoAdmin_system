package com.javaallinone.project.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String name;

    private LocalDate birthday;

    private String hobby;

    private String address;

    private String phoneNumber;

    private String job;
}
