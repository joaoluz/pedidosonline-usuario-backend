package com.pedidosonline.usuario.dto;

import com.pedidosonline.usuario.entites.Usuario;

public class UsuarioDTO {

    private Integer id_usuario;
    private String no_usuario;

    public UsuarioDTO() {

    }

    public UsuarioDTO(Usuario usuario) {
        this.id_usuario = usuario.getId_usuario();
        this.no_usuario = usuario.getNo_usuario();
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNo_usuario() {
        return no_usuario;
    }

    public void setNo_usuario(String no_usuario) {
        this.no_usuario = no_usuario;
    }
}
