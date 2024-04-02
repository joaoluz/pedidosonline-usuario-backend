package com.pedidosonline.usuario.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "usuario", schema = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "no_usuario")
    private String noUsuario;
    @Email
    private String email;
    private String senha;
    @Column(name = "dt_aniversario")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtAniversario;
    @Column(name = "nr_ddd")
    private Integer nrDdd;
    @Column(name = "nr_telefone")
    private Integer nrTelefone;
    @CPF
    @Column(name = "nr_cpf")
    private String nrCpf;


    public Usuario() {
    
    }
    
    public Usuario(Integer idUsuario, String noUsuario, String email, String senha, String dtAniversario, Integer nrDdd, Integer nrTelefone, String nrCpf) {

        DateTimeFormatter dtAniversarioFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        this.idUsuario = idUsuario;
        this.noUsuario = noUsuario;
        this.email = email;
        this.senha = senha;
        this.dtAniversario = LocalDate.parse(dtAniversario, dtAniversarioFormatter);
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