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

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

        StandardError erro = new StandardError();

        erro.setTimesTamp(LocalDateTime.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setError("Objeto não Encontrado");
        erro.setMessage(ex.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardError> rumtimeError(RuntimeException ex, HttpServletRequest request) {

        StandardError erro = new StandardError();

        erro.setTimesTamp(LocalDateTime.now());
        erro.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        erro.setError("Url não Encontrado");
        erro.setMessage(ex.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<StandardError> noResourceError(NoResourceFoundException ex, HttpServletRequest request) {

        StandardError erro = new StandardError();

        erro.setTimesTamp(LocalDateTime.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setError("Url não Encontrado");
        erro.setMessage(ex.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    
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
