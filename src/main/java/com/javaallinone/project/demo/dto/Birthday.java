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

    @Min(1)
    @Max(12)
    private Integer birthday_month;

    @Min(1)
    @Max(31)
    private Integer birthday_day;

    public Birthday(LocalDate birthday){
        this.birthday_year = birthday.getYear();
        this.birthday_month = birthday.getMonthValue();
        this.birthday_day  = birthday.getDayOfMonth();
    }

}
