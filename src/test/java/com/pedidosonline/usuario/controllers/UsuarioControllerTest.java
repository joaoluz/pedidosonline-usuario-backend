package com.pedidosonline.usuario.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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
    void createERetornaCriadoComSucesso() {
        when(service.create(any())).thenReturn(usuario);

        ResponseEntity<Usuario> response = controller.create(usuario);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void testDelete() {

    }

    @Test
    void findAllRetornaUmaListaDeUsuarioDTO() {
        when(service.findAll()).thenReturn(List.of(usuarioDTO));

        ResponseEntity<List<UsuarioDTO>> response = controller.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UsuarioDTO.class, response.getBody().get(0).getClass());

        assertEquals(1, response.getBody().get(0).getId_usuario());

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
    void updateRetornaComSucesso() throws Exception {

        when(service.update(usuario)).thenReturn(usuario);

        ResponseEntity<Usuario> response = controller.update(1, usuario);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Usuario.class, response.getBody().getClass());

        assertEquals(1, response.getBody().getIdUsuario());
    }

    private void startUsuario() {

        usuario = new Usuario(1, "Gil", "gil@gmail.com", "gil123", "27/10/1996", 61, 983480099, "05571541113");
        usuarioDTO = new UsuarioDTO(usuario);
    }
}
