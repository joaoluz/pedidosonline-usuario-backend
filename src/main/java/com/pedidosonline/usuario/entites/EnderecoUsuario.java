package com.pedidosonline.usuario.entites;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Embeddable
@Table(name = "endereco_usuario", schema= "usuario")
public class EnderecoUsuario {

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne
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
