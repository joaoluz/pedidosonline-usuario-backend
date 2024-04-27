package com.pedidosonline.usuario.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


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
    @Column(unique = true)
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
    @Column(name = "nr_cpf", unique = true)
    private String nrCpf;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @Transient
    // private List<Endereco> enderecos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "endereco_usuario",schema= "usuario", 
                joinColumns = @JoinColumn(name = "id_usuario"), 
                inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private List<Endereco> enderecos;

    

} 