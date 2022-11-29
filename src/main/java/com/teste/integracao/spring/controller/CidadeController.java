package com.teste.integracao.spring.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.teste.integracao.spring.domain.model.Cidade;
import com.teste.integracao.spring.domain.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    private CidadeService service;

    @GetMapping("/")
    public ResponseEntity<List<Cidade>> todos() {
        var cidades = service.todos();

        if(cidades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscaPor(Integer id) {
        var optional = service.buscaPor(id);
        
        if(optional.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(optional.get());
    }
    
    @GetMapping("/{nome}")
    public ResponseEntity<List<Cidade>> buscaPor(String nome) {
        var cidades = service.buscaPor(nome);
        
        if(cidades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cidades);
    }
    
    @GetMapping("/{uf}")
    public ResponseEntity<List<Cidade>> buscaPorUf(String uf) {
        var cidades = service.buscaPor(uf);
        
        if(cidades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/frete/{id}")
    public ResponseEntity<Cidade> buscarPorFrete_id(Integer id){
        var optional = service.buscarPorFrete_id(id);
        
        if(optional == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(optional);
    }

    @PostMapping
    public ResponseEntity<Cidade> salva(@RequestBody @Valid Cidade cidade, UriComponentsBuilder URIBuilder) {

        var cidadeSalva = service.salva(cidade);
        URI uri = (URIBuilder
            .path("cidades/inserir/{id}")
            .buildAndExpand(cidadeSalva.getId())
            .toUri()
        );

        return ResponseEntity.created(uri).body(cidadeSalva);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(Integer id) {

        Optional<Cidade> optional = service.buscaPor(id);
        if(optional.isPresent()){
            service.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
