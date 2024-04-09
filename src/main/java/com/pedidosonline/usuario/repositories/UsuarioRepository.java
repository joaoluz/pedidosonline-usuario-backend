package com.pedidosonline.usuario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedidosonline.usuario.entites.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByNrCpf(String nrCpf);

}
