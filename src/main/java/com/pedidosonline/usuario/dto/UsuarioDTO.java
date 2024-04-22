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
    

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNoUsuario() {
        return noUsuario;
    }

    public void setNoUsuario(String noUsuario) {
        this.noUsuario = noUsuario;
    }

}
