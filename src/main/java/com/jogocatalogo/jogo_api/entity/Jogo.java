package com.jogocatalogo.jogo_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name="jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Título é obrigatório")
    @Column(name = "titulo")
    private String titulo;

    @NotBlank(message = "Gênero é obrigatório")
    @Column(name = "genero")
    private String genero;

    @Column(name = "plataforma")
    private String plataforma;

    @Positive(message = "Ano de lançamento deve ser positivo")
    @Column(name = "ano_Lancamento")
    private Integer anoLancamento;

    @Column(name = "descricao")
    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    @Column(name = "preco")
    private BigDecimal preco;

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
