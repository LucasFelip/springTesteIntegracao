package com.teste.integracao.spring.domain.service;

import com.teste.integracao.spring.domain.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class ClienteServiceTest {
    @Autowired
    private ClienteService service;

    @Test
    void deveSalvarCliente() {
        String nomeCliente = "Fernando Pessoa";
        Cliente cliente = Cliente.builder().nome(nomeCliente).build();
        service.salva(cliente);

        var clientes = service.buscaPor(nomeCliente);
        clientes.forEach(user -> {
            assertEquals(nomeCliente, user.getNome());
        });
    }

    @Test
    void deveRemoverCliente() {
        int idClienteRemovido = 1;
        service.removePelo(idClienteRemovido);

        var cliente = service.buscaPor(idClienteRemovido);
        assertTrue(cliente.isEmpty());
    }
}
