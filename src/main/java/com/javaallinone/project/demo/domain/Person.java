package com.javaallinone.project.demo.domain;

import com.javaallinone.project.demo.dto.Birthday;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NonNull
    @Min(0)
    private int age;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String blood;

    @Embedded
    @Valid
    private Birthday birthday;

    private String hobby;

    private String address;

    private String job;

    @OneToOne(cascade =CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.EAGER)
    private Block block;
}
