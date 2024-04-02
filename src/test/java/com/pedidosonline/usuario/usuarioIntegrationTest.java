package com.pedidosonline.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.pedidosonline.usuario.entites.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) //parâmetro para rodar em uma porta aleatória para não dar conflitos
@ActiveProfiles("test")  // Informa que é para utilizar o DB de teste (application-test.properties)
public class usuarioIntegrationTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    //UsuarioService usuarioService;

    @Test
    public void create() {
        Usuario novoUsuario = new Usuario(1, "gil", "araujo.gil27@gmail.com", "1234", "27/10/1996", 61, 983480099, "05571541113");
        
        Usuario usuarios = restTemplate.postForObject("/usuario", novoUsuario, Usuario.class);
        
        assertNotNull(usuarios);
        assertEquals("gil", novoUsuario.getNoUsuario());
    }

}

