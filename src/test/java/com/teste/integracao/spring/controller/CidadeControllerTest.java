package com.teste.integracao.spring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.integracao.spring.domain.repository.CidadeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;

import com.teste.integracao.spring.domain.model.Cidade;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CidadeController.class)
public class CidadeControllerTest {
    @MockBean
    private CidadeRepository repository;

    @Autowired
	private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveSalvarCidade() throws Exception {
        Cidade cidade = Cidade.builder().nome("Null City").taxa(10).build();

        mockMvc.perform(post("/cidades").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(cidade)))
                .andExpect(status().isCreated())
                .andDo(print());
/*
        HttpEntity<Cidade> httpEntity = new HttpEntity<Cidade>(cidade);

        ResponseEntity<Cidade> resposta = testRestTemplate.exchange(
            "/cidades", HttpMethod.POST, httpEntity, Cidade.class
        );

        assertEquals(HttpStatus.CREATED, resposta.getStatusCode());*/
    }
}
