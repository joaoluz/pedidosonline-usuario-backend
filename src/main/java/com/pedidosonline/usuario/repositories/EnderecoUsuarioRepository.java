// package com.pedidosonline.usuario.repositories;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.pedidosonline.usuario.entites.Endereco;
// import com.pedidosonline.usuario.entites.EnderecoUsuario;

// public interface EnderecoUsuarioRepository extends JpaRepository<EnderecoUsuario, Integer> {

//     //Criar a query
//     @Query("SELECT eu.endereco FROM EnderecoUsuario eu WHERE eu.usuario.idUsuario = :idUsuario")
//     List<Endereco> findAllByUsuario(@Param("idUsuario")Integer idUsuario);

// }
