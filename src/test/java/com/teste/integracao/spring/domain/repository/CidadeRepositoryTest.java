package com.teste.integracao.spring.domain.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CidadeRepositoryTest {

    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Test
    void deveBuscarCidadesQueContenhamNome(){
        String nome = "São";
        var cidades = cidadeRepository.findByNomeContaining(nome);

        cidades.forEach(cidade -> {
            assertTrue(cidade.getNome().contains(nome));
        });
    }
    
    @Test
    void deveBuscarCidadePorFretesId(){
        int expectedId = 1;
        var cidade = cidadeRepository.findByFretes_Id(expectedId);

        var frete = (cidade.getFretes().stream()
            .filter(fretes -> fretes.getId() == expectedId)
            .collect(Collectors.toList())
        );

        assertEquals(expectedId, frete.get(0).getId());
    }
    
    @Test
    void deveBuscarCidadesPorUf(){
        String uf = "MA";
        var cidades = cidadeRepository.findByUf(uf);

        cidades.forEach(cidade -> {
            assertTrue(cidade.getUf().equals(uf));
        });
    }

}
