package com.pedidosonline.usuario.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
//@Embeddable
@Table(name = "endereco_usuario", schema= "usuario")
public class EnderecoUsuario {

    @Id
    private Integer id;   // Não tem o Id no banco de dados

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    

    public EnderecoUsuario() {

    }

    public EnderecoUsuario(Usuario usuario, Endereco endereco) {
        this.usuario = usuario;
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
