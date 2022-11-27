package com.teste.integracao.spring.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Frete> fretes;

    @Size(max = 30)
    private String nome;

    @Size(max = 30)
    private String telefone;

    @Size(max = 30)
    private String endereco;
}
