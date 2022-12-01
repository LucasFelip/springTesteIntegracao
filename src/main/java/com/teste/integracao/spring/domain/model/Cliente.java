package com.teste.integracao.spring.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente")
    private Integer id;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Frete> fretes;

    @Size(max = 30)
    private String nome;

    @Size(max = 30)
    private String telefone;

    @Size(max = 30)
    private String endereco;
}
