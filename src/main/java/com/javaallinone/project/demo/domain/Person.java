package com.javaallinone.project.demo.domain;

import com.javaallinone.project.demo.dto.Birthday;
import com.javaallinone.project.demo.dto.PersonDto;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

import static org.springframework.util.StringUtils.isEmpty;

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

    public void set(PersonDto personDto){

        if(!name.equals(personDto.getName()))  throw new RuntimeException("이름이 같지 않습니다.");

        if(personDto.getAge() != 0) age = personDto.getAge();
        if(isEmpty(personDto.getAddress())) address = personDto.getAddress();
        if(isEmpty(personDto.getHobby())) hobby = personDto.getHobby();
        if(isEmpty(personDto.getJob())) address = personDto.getJob();
        if(isEmpty(personDto.getBlood())) address = personDto.getBlood();
    }
}
