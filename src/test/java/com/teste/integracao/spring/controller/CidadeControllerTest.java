package com.teste.integracao.spring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.teste.integracao.spring.domain.model.Cidade;

@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CidadeControllerTest {

    @Autowired
	private TestRestTemplate testRestTemplate;

    @Test
    public void deveSalvarCidade(){

        Cidade cidade = Cidade.builder().nome("Null City").build();
        HttpEntity<Cidade> httpEntity = new HttpEntity<Cidade>(cidade);

        ResponseEntity<Cidade> resposta = testRestTemplate.exchange(
            "/cidades", HttpMethod.POST, httpEntity, Cidade.class
        );

        assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
    }
}
