package com.teste.integracao.spring.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Frete {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_frete")
    private Integer id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo_cliente")
    private Cliente cliente;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "codigo_cidade", referencedColumnName = "codigo_cidade")
    private Cidade cidade;

    @Size(max = 30)
    private String descricao;

    @Size(max = 4)
    private float peso;

    @Size(max = 4)
    private float valcr;
}
