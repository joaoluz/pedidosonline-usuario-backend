// package com.pedidosonline.usuario.entites;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor


// @Entity
// //@Embeddable
// @Table(name = "endereco_usuario", schema= "usuario")
// public class EnderecoUsuario {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     @ManyToMany
//     @JoinColumn(name = "id_usuario")
//     private Usuario usuario;

//     @ManyToMany
//     @JoinColumn(name = "id_endereco")
//     private Endereco endereco;

// }
