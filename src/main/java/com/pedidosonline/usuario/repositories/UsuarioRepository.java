package com.pedidosonline.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedidosonline.usuario.entites.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
