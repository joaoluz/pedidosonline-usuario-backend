package com.pedidosonline.usuario.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pedidosonline.usuario.dto.UsuarioDTO;
import com.pedidosonline.usuario.entites.Usuario;
import com.pedidosonline.usuario.repositories.UsuarioRepository;
import com.pedidosonline.usuario.services.exceptions.ObjectNotFoundException;

@SpringBootTest
public class UsuarioServiceTest {

    @InjectMocks   //  <-- Serve para injetar uma instância real
    private UsuarioService service;

    @Mock          //  <-- Serve para injetar uma instância "fake", onde eu não preciso acessar o banco de dados na prática
    private UsuarioRepository repository;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;
    private Optional<Usuario> optionalUsuario;

    @BeforeEach     //  <-- Roda esse método antes de qualque coisa 
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
    void buscaTodosERetornaUmaListaDeUsuarios() {

        when(repository.findAll()).thenReturn(List.of(usuario));

        List<UsuarioDTO> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(UsuarioDTO.class, response.get(0).getClass());
        assertEquals(1, response.get(0).getId_usuario());

    }

    @Test
    void buscaPorIdERetornaUmaInstanciaDeUsuario() {

        when(repository.findById(anyInt())).thenReturn(optionalUsuario);

        UsuarioDTO response = service.findById(1);

        assertNotNull(response);
        assertEquals(UsuarioDTO.class, response.getClass());
        assertEquals(1, response.getId_usuario());
        assertEquals("Gil", response.getNo_usuario());

    }
    @Test
    void buscaPorIdERetornaUmObjectNotFoundException() {

        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try {
            service.findById(1);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado", ex.getMessage());
        }
    }

    @Test
    void testUpdate() {

    }

    private void startUsuario() {
        usuario = new Usuario(1, "Gil", "gil@gmail.com", "gil123", "27/10/1996", 61, 983480099, "05571541113");
        usuarioDTO = new UsuarioDTO();
        optionalUsuario = Optional.of(new Usuario(1, "Gil", "gil@gmail.com", "gil123", "27/10/1996", 61, 983480099, "05571541113"));

    }

}
