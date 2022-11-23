package com.teste.integracao.spring.controller;

import com.teste.integracao.spring.domain.model.Cidade;
import com.teste.integracao.spring.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    private final CidadeService service;

    public CidadeController(CidadeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cidade> todos() {
        return service.todos();
    }

    @GetMapping("/{id}")
    public Optional<Cidade> buscaPor(Integer id) {
        return service.buscaPor(id);
    }

    @GetMapping("/{nome}")
    public List<Cidade> buscaPor(String nome) {
        return service.buscaPor(nome);
    }

    @GetMapping("/{uf}")
    public List<Cidade> buscaPorUf(String uf) {
        return service.buscaPor(uf);
    }

    @GetMapping("/frete/{id}")
    public Cidade buscarPorFrete_id(Integer id){
        return service.buscarPorFrete_id(id);
    }

    @PostMapping
    public Cidade salva(Cidade cidade) {
        return service.salva(cidade);
    }

    @DeleteMapping
    public void delete(Integer id) {
        service.removePelo(id);
    }
}
