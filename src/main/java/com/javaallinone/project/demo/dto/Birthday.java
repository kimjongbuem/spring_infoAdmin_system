package com.javaallinone.project.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Birthday {
    private Integer birthday_year;
    private Integer birthday_month;
    private Integer birthday_day;

    private Birthday(LocalDate birthday){
        this.birthday_year = birthday.getYear();
        this.birthday_month = birthday.getMonthValue();
        this.birthday_day  = birthday.getDayOfMonth();
    }

    public static Birthday of(LocalDate birthday){
        return new Birthday(birthday);
    }
}
