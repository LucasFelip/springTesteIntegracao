package com.teste.integracao.spring.controller;

import com.teste.integracao.spring.domain.model.Cidade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CidadeControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CidadeController controller;

    @Test
    void deveListarTodasCidades() {
        ResponseEntity<List<Cidade>> response = controller.todos();
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deveBuscarCidadePorId() {
        int expectedId = 1;
        ResponseEntity<Cidade> response = controller.buscaPor(expectedId);
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deveBuscarCidadePorNome() {
        String nome = "Recife";
        ResponseEntity<List<Cidade>> response = controller.buscaPor(nome);
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deveBuscarCidadePorUf() {
        String uf = "MA";
        ResponseEntity<List<Cidade>> response = controller.buscaPorUf(uf);
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deveBuscarCidadePorFrete_id() {
        int expectedId = 1;
        ResponseEntity<Cidade> response = controller.buscarPorFrete_id(expectedId);
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deveSalvarCidade(){
        Cidade cidade = Cidade.builder().nome("Null City").taxa(10).build();

        ResponseEntity<Cidade> response = controller.salva(cidade, UriComponentsBuilder.fromUri(URI.create("/cidades/inserir/")));
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void deveRemoverCidadePorId(){
        int expectedId = 1;
        ResponseEntity<?> response = controller.delete(expectedId);
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}