package com.javaallinone.project.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Block {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String name;
    private String reason;
    private LocalDate sD;
    private LocalDate eD;

}
