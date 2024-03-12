package com.pedidosonline.usuario.dto;

import com.pedidosonline.usuario.entites.Usuario;

public class UsuarioDTO {

    private Integer idUsuario;
    private String noUsuario;

    public UsuarioDTO() {

    }

    public UsuarioDTO(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.noUsuario = usuario.getNoUsuario();
    }

    public Integer getId_usuario() {
        return idUsuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.idUsuario = id_usuario;
    }

    public String getNo_usuario() {
        return noUsuario;
    }

    public void setNo_usuario(String no_usuario) {
        this.noUsuario = no_usuario;
    }
}
