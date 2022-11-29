package com.teste.integracao.spring.controller;

import com.teste.integracao.spring.domain.model.Frete;
import com.teste.integracao.spring.domain.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/fretes")
public class FreteController {
    @Autowired
    private FreteService service;

    @GetMapping
    public ResponseEntity<Frete> listarTodos(){
        var optional = service.todos();

        if (!optional.isEmpty()){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Frete> buscaPor(@PathVariable Integer id) {
        var optional = service.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Frete> buscaPorCliente_Id(@PathVariable Integer id) {
        var optional = service.buscaPorCliente_Id(id);

        if (optional != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cidade/{id}")
    public ResponseEntity<Frete> buscaPorCidade_Id(@PathVariable Integer id) {
        var optional = service.buscaPorCidade_Id(id);

        if (optional != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cliente/order/{id}")
    public ResponseEntity<Frete> buscarPorCliente_IdOrderByValcrAsc(@PathVariable Integer id) {
        var optional = service.buscarPorCliente_IdOrderByValcrAsc(id);

        if (optional != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Frete> cadastro(@RequestBody @Valid Frete frete, UriComponentsBuilder builder) {
        final Frete freteSalvo = service.salva(frete);
        final URI uri = builder
                .path("/clientes/{id}")
                .buildAndExpand(freteSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(freteSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Frete> atualiza(@PathVariable Integer id,
                                          @RequestBody @Valid Frete frete) {
        var optional = service.buscaPor(id);

        if(optional.isPresent()){
            frete.setId(id);
            Frete freteAtualizado = service.salva(frete);
            return ResponseEntity.ok(freteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        var optional = service.buscaPor(id);

        if (optional.isPresent()) {
            service.removePelo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}