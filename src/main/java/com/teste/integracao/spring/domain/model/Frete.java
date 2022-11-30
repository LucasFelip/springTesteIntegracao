package com.teste.integracao.spring.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Frete {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_frete")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "codigo_cidade")
    private Cidade cidade;

    @Size(max = 30)
    private String descricao;

    private float peso;

    private float valcr;
}
