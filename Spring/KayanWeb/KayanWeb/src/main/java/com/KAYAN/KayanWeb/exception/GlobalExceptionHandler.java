package com.KAYAN.KayanWeb.exception;

import com.KAYAN.KayanWeb.model.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException customException){
        return new ResponseEntity<>(new CustomResponse<>(02 , "very bad" , customException.getMessage()) , HttpStatus.BAD_REQUEST);
    }

}
