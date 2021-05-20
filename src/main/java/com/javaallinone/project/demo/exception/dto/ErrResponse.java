package com.javaallinone.project.demo.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrResponse {
    int code;
    String message;

    public static ErrResponse of(int value, String message) {
        return new ErrResponse(value, message);
    }
}
