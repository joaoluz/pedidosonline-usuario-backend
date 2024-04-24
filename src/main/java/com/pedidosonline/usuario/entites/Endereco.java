package com.pedidosonline.usuario.entites;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "endereco", schema = "usuario")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @NotEmpty(message = "O Lagradouro não pode ser vazio")
    private String logradouro;

    @NotEmpty(message = "O CEP não ser vazio")
    @Size(min = 8, max = 8, message = "O CEP deve conter 8 dígitos")
    private String cep;

    @NotEmpty(message = "O Bairro não pode ser vazio")
    private String bairro;

    private String complemento;

    @NotEmpty(message = "O Número não pode ser vazio")
    private String numero;

    @ManyToMany(mappedBy = "enderecos", fetch = FetchType.EAGER)
    private List<Usuario> usuarios;


    public Endereco() {

    }

    public Endereco(Integer idEndereco, String logradouro, String cep, String bairro, String complemento, String numero) {

        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;

    }

    public Integer getIdEndereco() {
        return idEndereco;
    }
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
