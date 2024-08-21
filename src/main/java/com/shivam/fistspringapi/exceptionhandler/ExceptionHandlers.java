package com.shivam.fistspringapi.exceptionhandler;

import com.shivam.fistspringapi.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolution("Unfortunately nothing can be done now");

        ResponseEntity<ExceptionDto> responseEntity=new ResponseEntity<>(exceptionDto,
                HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolution("Please put a valid index");
        ResponseEntity<ExceptionDto> responseEntity=new ResponseEntity<>(exceptionDto,
                HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
