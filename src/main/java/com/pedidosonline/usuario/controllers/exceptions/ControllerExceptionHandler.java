package com.pedidosonline.usuario.controllers.exceptions;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pedidosonline.usuario.entites.Usuario;
import com.pedidosonline.usuario.services.exceptions.DataIntegratyViolationException;
import com.pedidosonline.usuario.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)   //caso o objeto não seja encontrado
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

        StandardError erro = new StandardError();

        erro.setTimesTamp(LocalDateTime.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setError(ex.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(DataIntegratyViolationException.class)  // caso o e-mail e cpf sejam repetidos
    public ResponseEntity<StandardError> dataIntegratyViolation(DataIntegratyViolationException ex, HttpServletRequest request) {

        StandardError erro = new StandardError();

        erro.setTimesTamp(LocalDateTime.now());
        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setError(ex.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }


    //Para mostrar os erros de validação de dados no terminal
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
