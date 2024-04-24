package com.pedidosonline.usuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidosonline.usuario.dto.UsuarioDTO;
import com.pedidosonline.usuario.entites.Usuario;
import com.pedidosonline.usuario.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> lista = usuarioService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{idUsuario}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer idUsuario) {
        UsuarioDTO usuarioDTO = usuarioService.findById(idUsuario);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
        usuario = usuarioService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping(value = "/{idUsuario}")
    public ResponseEntity<Usuario> update(@PathVariable Integer idUsuario, @RequestBody @Valid Usuario usuario) {
        usuario.setIdUsuario(idUsuario);
        Usuario novoUsuario = usuarioService.update(usuario);
        return ResponseEntity.ok().body(novoUsuario);
    }

    @DeleteMapping(value = "/{idUsuario}")
    public ResponseEntity<Usuario> delete(@PathVariable Integer idUsuario) {
    usuarioService.delete(idUsuario);
    return ResponseEntity.noContent().build();
    }
}
