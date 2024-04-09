package com.pedidosonline.usuario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedidosonline.usuario.entites.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email); // Busca o email no banco de dados e joga para validaçãoDeEmailECpf()

    Optional<Usuario> findByNrCpf(String nrCpf); // Busca o cpf no banco de dados e joga para validaçãoDeEmailECpf()

}
