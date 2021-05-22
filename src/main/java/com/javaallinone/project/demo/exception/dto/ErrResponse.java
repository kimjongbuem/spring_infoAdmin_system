package com.javaallinone.project.demo.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.lang.reflect.Field;

@Data
@AllArgsConstructor
public class ErrResponse {
    int code;
    String message;

    public static ErrResponse of(HttpStatus httpStatus, String message) {
        return new ErrResponse(httpStatus.value(), message);
    }

    public static ErrResponse of(HttpStatus httpStatus, FieldError fieldError) {
        if(fieldError == null)
            return new ErrResponse(httpStatus.value(), "invalid Params");
        return new ErrResponse(httpStatus.value(), fieldError.getDefaultMessage());
    }

}
