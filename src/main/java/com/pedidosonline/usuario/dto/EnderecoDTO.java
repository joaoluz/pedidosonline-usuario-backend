package com.pedidosonline.usuario.dto;

import com.pedidosonline.usuario.entites.Endereco;

public class EnderecoDTO {

    private Integer idEndereco;
    private String cep;

    public EnderecoDTO() {
        
    }
    
    public EnderecoDTO(Endereco endereco) {
        this.idEndereco = getIdEndereco();
        this.cep = getCep();
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    

    
}
