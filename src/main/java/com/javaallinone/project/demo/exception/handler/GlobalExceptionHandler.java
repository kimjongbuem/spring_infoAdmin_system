package com.javaallinone.project.demo.exception.handler;

import com.javaallinone.project.demo.exception.PersonNotFoundException;
import com.javaallinone.project.demo.exception.RenameNotPermittedException;
import com.javaallinone.project.demo.exception.dto.ErrResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RenameNotPermittedException.class)
    public ResponseEntity<ErrResponse> handleRenameNotPermittedException(RenameNotPermittedException rnpe){
        return new ResponseEntity<>( ErrResponse.of(HttpStatus.BAD_REQUEST, rnpe.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrResponse> handlerPersonNotFoundExceptionException(PersonNotFoundException rnpe){
        return new ResponseEntity<>( ErrResponse.of(HttpStatus.BAD_REQUEST, rnpe.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrResponse> hanlderMethodArgumentNotValidException(MethodArgumentNotValidException rnpe){
        return new ResponseEntity<>( ErrResponse.of(HttpStatus.BAD_REQUEST, rnpe.getBindingResult().getFieldError()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrResponse> handlerRuntimeException(RuntimeException rnpe){
        return new ResponseEntity<>( ErrResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, rnpe.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
