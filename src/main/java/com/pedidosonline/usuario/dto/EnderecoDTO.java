package com.pedidosonline.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class EnderecoDTO {

    private Integer idEndereco;
    private String cep;

}
