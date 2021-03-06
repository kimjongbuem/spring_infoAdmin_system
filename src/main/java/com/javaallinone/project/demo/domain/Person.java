package com.javaallinone.project.demo.domain;

import com.javaallinone.project.demo.dto.Birthday;
import com.javaallinone.project.demo.dto.PersonDto;
import com.javaallinone.project.demo.exception.RenameNotPermittedException;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
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
@Where(clause = "deleted = false")
public class Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @Embedded
    @Valid
    private Birthday birthday;

    private String hobby;

    private String address;

    private String phoneNumber;

    private String job;

    @ColumnDefault("0")
    private boolean deleted = false;

    public void set(PersonDto personDto){

        if(name == null) name= personDto.getName();
        if(!name.equals(personDto.getName()))  throw new RenameNotPermittedException();

        address = personDto.getAddress();
        hobby = personDto.getHobby();
        address = personDto.getAddress();
        job     = personDto.getJob();
        phoneNumber = personDto.getPhoneNumber();
        Birthday.of(personDto.getBirthday());
    }


    public Integer getAge(){
        if(this.birthday != null)  return LocalDate.now().getYear() - this.birthday.getBirthday_year() + 1;
        return null;
    }

    public boolean isBirthdayToday(){
        return LocalDate.now().equals(LocalDate.of(birthday.getBirthday_year(), birthday.getBirthday_month(), birthday.getBirthday_day()));
    }
}
