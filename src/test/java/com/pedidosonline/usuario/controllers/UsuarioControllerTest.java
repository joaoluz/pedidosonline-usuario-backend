package com.pedidosonline.usuario.controllers;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pedidosonline.usuario.entites.Usuario;
import com.pedidosonline.usuario.repositories.UsuarioRepository;
import com.pedidosonline.usuario.services.UsuarioService;

@SpringBootTest
public class UsuarioControllerTest {

    @InjectMocks   //  <-- Serve para injetar uma instância real
    private UsuarioService service;

    @Mock          //  <-- Serve para injetar uma instância "fake", onde eu não preciso acessar o banco de dados na prática
    private UsuarioRepository repository;

    private Usuario usuario;
    private Optional<Usuario> optionalUsuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsuario();
    }
    @Test
    void testCreate() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testUpdate() {

    }

    private void startUsuario() {

        usuario = new Usuario(1, "Gil", "gil@gmail.com", "gil123", "27/10/1996", 61, 983480099, "05571541113");
        optionalUsuario = Optional.of(new Usuario(1, "Gil", "gil@gmail.com", "gil123", "27/10/1996", 61, 983480099, "05571541113"));
    }
}
