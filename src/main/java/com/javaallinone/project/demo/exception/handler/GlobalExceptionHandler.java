package com.javaallinone.project.demo.exception.handler;

import com.javaallinone.project.demo.exception.PersonNotFoundException;
import com.javaallinone.project.demo.exception.RenameNotPermittedException;
import com.javaallinone.project.demo.exception.dto.ErrResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RenameNotPermittedException.class)
    public ResponseEntity<ErrResponse> handleRenameNotPermittedException(RenameNotPermittedException rnpe){
        return new ResponseEntity<>( ErrResponse.of(HttpStatus.BAD_REQUEST.value(), rnpe.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrResponse> personNotFoundExceptionException(PersonNotFoundException rnpe){
        return new ResponseEntity<>( ErrResponse.of(HttpStatus.BAD_REQUEST.value(), rnpe.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrResponse> handlerRuntimeException(RuntimeException rnpe){
        return new ResponseEntity<>( ErrResponse.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), rnpe.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
