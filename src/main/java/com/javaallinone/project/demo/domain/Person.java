package com.javaallinone.project.demo.domain;

import com.javaallinone.project.demo.dto.Birthday;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
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

    @NonNull
    private String bloodType;

    @NonNull
    @Min(0)
    private int age;

    @Embedded
    @Valid
    private Birthday birthday;

    private String hobby;

    private String address;

    private String job;

    @OneToOne(cascade =CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.EAGER)
    private Block block;
}
