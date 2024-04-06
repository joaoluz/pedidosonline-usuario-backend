package com.pedidosonline.usuario.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuario", schema = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotEmpty(message = "Campo NOME obrigatório")
    @Length(min = 3, max = 100, message = "O nome deve conter entre 3 e 100 caracteres")
    @Column(name = "no_usuario")
    private String noUsuario;

    @Email(message = "Email incorreto")
    @NotEmpty(message = "Campo E-MAIL obrigatório")
    //@Column(unique = true) descomentar após os testes, incluir unique no atributo cpf
    private String email;

    @NotEmpty(message = "Campo SENHA obrigatório")
    @Length(min = 6, message = "Insira no mínimo 6 caracteres")
    private String senha;

    @Column(name = "dt_aniversario")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtAniversario;

    @NotNull(message = "Campo DDD obrigatório")
    @Max(value = 99, message = "DDD inválido")
    @Column(name = "nr_ddd")
    private Integer nrDdd;

    @NotNull(message = "Campo NÚMERO obrigatório")
    //@Max(value = 9, message = "Número de telefone deve conter 9 dígitos")
    @Column(name = "nr_telefone")
    private Integer nrTelefone;

    @CPF(message = "CPF incorreto")
    @NotEmpty(message = "Campo CPF obrigatório")
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