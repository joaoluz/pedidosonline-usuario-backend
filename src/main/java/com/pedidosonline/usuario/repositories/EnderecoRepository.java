package com.pedidosonline.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedidosonline.usuario.entites.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
