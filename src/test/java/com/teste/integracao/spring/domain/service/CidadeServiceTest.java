package com.teste.integracao.spring.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.teste.integracao.spring.domain.model.Cidade;

@Transactional
@SpringBootTest
public class CidadeServiceTest {
    
    @Autowired
    private CidadeService service;

    @Test
    void deveSalvarCidade(){
        String nomeCidade = "Null City";
        Cidade cidade = Cidade.builder().nome(nomeCidade).taxa(13).build();
        service.salva(cidade);

        var cidades = service.buscaPor(nomeCidade);
        cidades.forEach(city -> {
            assertEquals(nomeCidade, city.getNome());
        });
    }
    
    @Test
    void deveRemoverCidade(){
        int idCidadeRemovida = 1;
        service.removePelo(idCidadeRemovida);

        var cidade = service.buscaPor(idCidadeRemovida);
        assertTrue(cidade.isEmpty());
    }

}
