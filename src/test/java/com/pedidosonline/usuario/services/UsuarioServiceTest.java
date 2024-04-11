package com.pedidosonline.usuario.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pedidosonline.usuario.dto.UsuarioDTO;
import com.pedidosonline.usuario.entites.Usuario;
import com.pedidosonline.usuario.repositories.UsuarioRepository;
import com.pedidosonline.usuario.services.exceptions.DataIntegratyViolationException;
import com.pedidosonline.usuario.services.exceptions.ObjectNotFoundException;

@SpringBootTest
public class UsuarioServiceTest {

    @InjectMocks   //  <-- Serve para injetar uma instância real
    private UsuarioService service;

    @Mock          //  <-- Serve para injetar uma instância "fake", onde eu não preciso acessar o banco de dados na prática
    private UsuarioRepository repository;

    private Usuario usuario;
    private Optional<Usuario> optionalUsuario;

    @BeforeEach     //  <-- Roda esse método antes de qualque coisa 
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsuario();
    }

    @Test
    void createRetornaUmUsuarioCriadoComSucesso() {

        when(repository.save(any())).thenReturn(usuario);

        Usuario response = service.create(usuario);

        assertNotNull(response);
        assertEquals(Usuario.class, response.getClass());
        assertEquals(1, response.getIdUsuario());
        assertEquals("Gil", response.getNoUsuario());
    }
    @Test
    void createRetornaUmDataIntegratyViolationExceptionDeEmail() {

        when(repository.findByEmail(anyString())).thenReturn(optionalUsuario);

        try {
            optionalUsuario.get().setIdUsuario(2);   // <-- Simula um Id diferente
            service.create(usuario);
        } catch (Exception e) {
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals("E-mail já cadastrado no sistema", e.getMessage());
        }
    }
    @Test
    void createRetornaUmDataIntegratyViolationExceptionDeCpf() {

        when(repository.findByNrCpf(anyString())).thenReturn(optionalUsuario);

        try {
            optionalUsuario.get().setIdUsuario(2);   // <-- Simula um Id diferente
            service.create(usuario);
        } catch (Exception e) {
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals("CPF já cadastrado no sistema", e.getMessage());
        }
    }



    @Test
    void deleteComSucesso() {
        when(repository.findById(anyInt())).thenReturn(optionalUsuario);
        doNothing().when(repository).deleteById(anyInt());
        service.delete(1);
        verify(repository, times(1)).deleteById(anyInt());
    }
    @Test
    void deleteRetornaUmObjectNotFoundException() {

        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try {
            service.delete(1);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado", ex.getMessage());
        }
    }



    @Test
    void findAllRetornaUmaListaDeUsuarios() {

        when(repository.findAll()).thenReturn(List.of(usuario));

        List<UsuarioDTO> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(UsuarioDTO.class, response.get(0).getClass());
        assertEquals(1, response.get(0).getId_usuario());
    }



    @Test
    void findByIdRetornaUmaInstanciaDeUsuario() {

        when(repository.findById(anyInt())).thenReturn(optionalUsuario);

        UsuarioDTO response = service.findById(1);

        assertNotNull(response);
        assertEquals(UsuarioDTO.class, response.getClass());
        assertEquals(1, response.getId_usuario());
        assertEquals("Gil", response.getNo_usuario());
    }
    @Test
    void findByIdRetornaUmObjectNotFoundException() {

        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try {
            service.findById(1);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado", ex.getMessage());
        }
    }



    @Test
    void updateRetornaUmUsuarioCriadoComSucesso() {

        when(repository.save(any())).thenReturn(usuario);

        Usuario response = service.create(usuario);

        assertNotNull(response);
        assertEquals(Usuario.class, response.getClass());
        assertEquals(1, response.getIdUsuario());
        assertEquals("Gil", response.getNoUsuario());
    }
    @Test
    void updateRetornaUmDataIntegratyViolationExceptionDeEmail() {

        when(repository.findByEmail(anyString())).thenReturn(optionalUsuario);

        try {
            optionalUsuario.get().setIdUsuario(2);   // <-- Simula um Id diferente
            service.create(usuario);
        } catch (Exception e) {
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals("E-mail já cadastrado no sistema", e.getMessage());
        }
    }
    @Test
    void updateRetornaUmDataIntegratyViolationExceptionDeCpf() {

        when(repository.findByNrCpf(anyString())).thenReturn(optionalUsuario);

        try {
            optionalUsuario.get().setIdUsuario(2);   // <-- Simula um Id diferente
            service.create(usuario);
        } catch (Exception e) {
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals("CPF já cadastrado no sistema", e.getMessage());
        }
    }



    private void startUsuario() {
        usuario = new Usuario(1, "Gil", "gil@gmail.com", "gil123", "27/10/1996", 61, 983480099, "05571541113");
        optionalUsuario = Optional.of(new Usuario(1, "Gil", "gil@gmail.com", "gil123", "27/10/1996", 61, 983480099, "05571541113"));

    }

}
