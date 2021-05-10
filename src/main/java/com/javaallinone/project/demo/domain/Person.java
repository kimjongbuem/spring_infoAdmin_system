package com.javaallinone.project.demo.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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

    private LocalDate birthday;

    private String bloodType;

    private String job;
    @NonNull
    private int age;

    @OneToOne(cascade =CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.EAGER)
    private Block block;
}
