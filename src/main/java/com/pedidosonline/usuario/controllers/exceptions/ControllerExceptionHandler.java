package com.pedidosonline.usuario.controllers.exceptions;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.pedidosonline.usuario.entites.Usuario;
import com.pedidosonline.usuario.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(NoResourceFoundException ex, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Url não Encontrado",
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<StandardError> objectNotFound(MethodArgumentNotValidException ex,
    //         HttpServletRequest request) {

    //     System.out.println(ex.getGlobalError().getDefaultMessage());

    //     StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
    //             request.getRequestURI());
    //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    // }

    public void validation() {

        Usuario usuario = new Usuario();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

        for (ConstraintViolation<Usuario> violation : violations) {
            System.out.println("erro:" + violation.getMessage());
        }
    }

}
