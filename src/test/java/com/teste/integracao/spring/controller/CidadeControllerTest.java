package com.teste.integracao.spring.controller;

import com.teste.integracao.spring.domain.model.Cidade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CidadeControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void deveListarTodasCidades() {
        ParameterizedTypeReference<List<Cidade>> tipoRetorno = new ParameterizedTypeReference<List<Cidade>>() {};

        ResponseEntity<List<Cidade>> response = testRestTemplate.exchange(
                "/cidades/", HttpMethod.GET,null, tipoRetorno
        );
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    // java.lang.IllegalArgumentException: The given id must not be null!
    // sout -> ######## 500 INTERNAL_SERVER_ERROR
    void deveBuscarCidadePorId() {
        int expectedId = 2;
        ResponseEntity<Cidade> response = testRestTemplate.exchange(
                "/cidades/id/{id}",HttpMethod.GET,null, Cidade.class, expectedId
        );
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deveBuscarCidadePorNome() {
        ParameterizedTypeReference<List<Cidade>> tipoRetorno = new ParameterizedTypeReference<List<Cidade>>() {};

        String expectedName = "Recife";
        ResponseEntity<List<Cidade>> response = testRestTemplate.exchange(
                "/cidades/nome/{nome}",HttpMethod.GET, null, tipoRetorno,expectedName
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deveBuscarCidadePorUf() {
        ParameterizedTypeReference<List<Cidade>> tipoRetorno = new ParameterizedTypeReference<List<Cidade>>() {};

        String expectedUf = "MA";
        ResponseEntity<List<Cidade>> response = testRestTemplate.exchange(
                "/cidades/uf/{uf}",HttpMethod.GET, null, tipoRetorno,expectedUf
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    // javax.persistence.NonUniqueResultException: query did not return a unique result: 27
    // sout -> ######## 500 INTERNAL_SERVER_ERROR
    void deveBuscarCidadePorFrete_id() {
        int expectedId = 1;
        ResponseEntity<Cidade> response = testRestTemplate.exchange(
                "/cidades/frete/{id}",HttpMethod.GET,null, Cidade.class, expectedId
        );
        System.out.println("######## " + response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deveSalvarCidade(){
        Cidade cidade = Cidade.builder().nome("Null City").build();
        HttpEntity<Cidade> httpEntity = new HttpEntity<>(cidade);

        ResponseEntity<Cidade> resposta = testRestTemplate.exchange(
                "/cidades", HttpMethod.POST, httpEntity, Cidade.class
        );
        System.out.println("######## " + resposta.getStatusCode());
        assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
    }

    @Test
    // java.lang.IllegalArgumentException: The given id must not be null!
    // sout -> ######## 500 INTERNAL_SERVER_ERROR
    void deveRemoverCidadePorId(){
        int expectedId = 10;
        ResponseEntity<?> resposta = testRestTemplate.exchange(
                "/cidades/", HttpMethod.DELETE, null, Cidade.class, expectedId
        );
        assertEquals(HttpStatus.NO_CONTENT,resposta.getStatusCode());
    }
}