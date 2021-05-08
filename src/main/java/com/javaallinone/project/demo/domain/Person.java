package com.javaallinone.project.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString(exclude = "hobby")
public class Person {

    @GeneratedValue
    @Id
    private long id;

    private String name;

    @ToString.Exclude
    private String hobby;

    private String address;

    private String birthday;

    private String job;

    private int age;
}
