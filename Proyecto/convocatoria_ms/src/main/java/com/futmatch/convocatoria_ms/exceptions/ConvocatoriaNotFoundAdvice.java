package com.futmatch.convocatoria_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ConvocatoriaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ConvocatoriaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(ConvocatoriaNotFoundException ex){
        return ex.getMessage();
    }
}
