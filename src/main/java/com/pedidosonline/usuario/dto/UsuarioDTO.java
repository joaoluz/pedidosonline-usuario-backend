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

    public void setId_usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNo_usuario() {
        return noUsuario;
    }

    public void setNo_usuario(String noUsuario) {
        this.noUsuario = noUsuario;
    }
}
