package com.jogocatalogo.jogo_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(length = 50)
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "CPF é obrigatório")
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 20)
    private String telefone;

    public Cliente() {}

    public Cliente(Long id, String nome, String email, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
