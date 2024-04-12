package com.pedidosonline.usuario.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.pedidosonline.usuario.dto.UsuarioDTO;
import com.pedidosonline.usuario.entites.Usuario;
import com.pedidosonline.usuario.services.UsuarioService;

@SpringBootTest
public class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController controller;

    @Mock   
    private UsuarioService service;


    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

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
    void findByIdRetornaComSucesso() {
        
        when(service.findById(anyInt())).thenReturn(usuarioDTO);

        ResponseEntity<UsuarioDTO> response = controller.findById(1);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UsuarioDTO.class, response.getBody().getClass());

        assertEquals(1, response.getBody().getId_usuario());
        assertEquals("Gil", response.getBody().getNo_usuario());

    }

    @Test
    void testUpdate() {

    }

    private void startUsuario() {

        usuario = new Usuario(1, "Gil", "gil@gmail.com", "gil123", "27/10/1996", 61, 983480099, "05571541113");
        usuarioDTO = new UsuarioDTO(usuario);
    }
}
