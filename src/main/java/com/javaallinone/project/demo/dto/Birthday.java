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
    private Integer year;

    @Min(1)
    @Max(12)
    private Integer month;

    @Min(1)
    @Max(31)
    private Integer day;

    public Birthday(LocalDate birthday){
        this.year = birthday.getYear();
        this.month = birthday.getMonthValue();
        this.day  = birthday.getDayOfMonth();
    }

}
