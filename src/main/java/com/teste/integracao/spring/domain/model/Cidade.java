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
public class Cidade {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cidade")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable (joinColumns = @JoinColumn (name = "codigo_cidade"), inverseJoinColumns = @JoinColumn (name = "codigo_frete"))
    private List<Frete> fretes;

    @Size(max = 30)
    private String nome;

    @Size(max = 2)
    private String uf;

    @Size(max = 4)
    private float taxa;
}
