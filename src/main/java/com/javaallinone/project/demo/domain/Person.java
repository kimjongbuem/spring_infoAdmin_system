package com.javaallinone.project.demo.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Person {

    @GeneratedValue
    @Id
    private long id;

    @NonNull
    private String name;

    @ToString.Exclude
    private String hobby;

    private String address;

    private String birthday;

    private String job;

    private int age;
}
