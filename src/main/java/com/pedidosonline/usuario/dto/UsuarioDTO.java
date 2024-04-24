package com.pedidosonline.usuario.dto;

import java.util.List;

import lombok.Data;

@Data


public class UsuarioDTO {

    private Integer idUsuario;
    private String noUsuario;

    private List<EnderecoDTO> enderecos;

}


