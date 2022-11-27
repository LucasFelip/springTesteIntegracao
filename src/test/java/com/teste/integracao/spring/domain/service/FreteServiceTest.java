package com.teste.integracao.spring.domain.service;

import com.teste.integracao.spring.domain.model.Frete;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class FreteServiceTest {
    @Autowired
    private FreteService service;

    @Test
    void deveSalvarFrete() {
        Frete frete = Frete.builder().peso(10).valcr(10).build();
        service.salva(frete);

        var fretes = service.buscaPor(frete.getId());
        assertEquals(frete.getId(), fretes.get().getId());
    }

    @Test
    void deveRemoverFrete() {
        int idFreteRemovido = 1;
        service.removePelo(idFreteRemovido);

        var frete = service.buscaPor(idFreteRemovido);
        assertTrue(frete.isEmpty());
    }
}
