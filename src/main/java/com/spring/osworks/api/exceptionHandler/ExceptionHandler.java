package com.spring.osworks.api.exceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var exception = new Exception();
        var campos = new ArrayList<Campo>();

        for (ObjectError error: ex.getBindingResult().getAllErrors()) {
            String nome = ( (FieldError) error).getField();
            String mensagem = error.getDefaultMessage();
            campos.add(new Campo(nome,mensagem));
        }

        exception.setDataHora(OffsetDateTime.now());
        exception.setStatus(status.value());
        exception.setCampos(campos);
        exception.setTitulo("Um ou mais campos inválidos");
        return super.handleExceptionInternal(ex,exception, headers, status, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> HandlerDomain(DomainException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        var exception = new Exception();
        exception.setStatus(status.value());
        exception.setTitulo(ex.getMessage());
        exception.setDataHora(OffsetDateTime.now());

        return handleExceptionInternal(ex,exception,new HttpHeaders(),status,request);
    }
}
