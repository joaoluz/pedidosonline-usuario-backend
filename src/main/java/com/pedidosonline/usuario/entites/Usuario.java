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
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String no_usuario;
    @Email
    private String email;
    private String senha;
    private LocalDate dt_aniversario;
    private Integer nr_ddd;
    private Integer nr_telefone;
    @CPF
    private String nr_cpf;
    

    public Usuario() {
    
    }
    

    public Usuario(Integer id_usuario, String no_usuario, String email, String senha, String dt_aniversario, Integer nr_ddd, Integer nr_telefone, String nr_cpf) {

        DateTimeFormatter dt_aniversario_formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.id_usuario = id_usuario;
        this.no_usuario = no_usuario;
        this.email = email;
        this.senha = senha;
        this.dt_aniversario = LocalDate.parse(dt_aniversario, dt_aniversario_formatter);
        this.nr_ddd = nr_ddd;
        this.nr_telefone = nr_telefone;
        this.nr_cpf = nr_cpf;
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


    public LocalDate getDt_aniversario() {
        return dt_aniversario;
    }


    public void setDt_aniversario(LocalDate dt_aniversario) {
        this.dt_aniversario = dt_aniversario;
    }


    public Integer getNr_ddd() {
        return nr_ddd;
    }


    public void setNr_ddd(Integer nr_ddd) {
        this.nr_ddd = nr_ddd;
    }


    public Integer getNr_telefone() {
        return nr_telefone;
    }


    public void setNr_telefone(Integer nr_telefone) {
        this.nr_telefone = nr_telefone;
    }


    public String getNr_cpf() {
        return nr_cpf;
    }


    public void setNr_cpf(String nr_cpf) {
        this.nr_cpf = nr_cpf;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (id_usuario == null) {
            if (other.id_usuario != null)
                return false;
        } else if (!id_usuario.equals(other.id_usuario))
            return false;
        return true;
    }

}
