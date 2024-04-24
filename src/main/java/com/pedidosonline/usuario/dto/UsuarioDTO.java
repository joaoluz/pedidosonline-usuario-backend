package com.pedidosonline.usuario.dto;

import java.util.List;

public class UsuarioDTO {

    private Integer idUsuario;
    private String noUsuario;

    private List<EnderecoDTO> enderecos;


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

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecoDTO(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }
}


