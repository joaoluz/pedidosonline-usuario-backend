package com.pedidosonline.usuario.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

@Entity
//@Table
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String noUsuario;
    @Email
    private String email;
    private String senha;
    private LocalDate dtAniversario;
    private Integer nrDdd;
    private Integer nrTelefone;
    @CPF
    private String nrCpf;


    public Usuario() {
    
    }
    
    public Usuario(Integer idUsuario, String noUsuario, String email, String senha, String dtAniversario, Integer nrDdd, Integer nrTelefone, String nrCpf) {

        DateTimeFormatter dt_aniversario_formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        this.idUsuario = idUsuario;
        this.noUsuario = noUsuario;
        this.email = email;
        this.senha = senha;
        this.dtAniversario = LocalDate.parse(dtAniversario, dt_aniversario_formatter);
        this.nrDdd = nrDdd;
        this.nrTelefone = nrTelefone;
        this.nrCpf = nrCpf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDtAniversario() {
        return dtAniversario;
    }

    public void setDtAniversario(LocalDate dtAniversario) {
        this.dtAniversario = dtAniversario;
    }

    public Integer getNrDdd() {
        return nrDdd;
    }

    public void setNrDdd(Integer nrDdd) {
        this.nrDdd = nrDdd;
    }

    public Integer getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(Integer nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

} 