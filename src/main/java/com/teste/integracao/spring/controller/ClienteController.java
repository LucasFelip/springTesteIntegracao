package com.teste.integracao.spring.controller;

import com.teste.integracao.spring.domain.model.Cliente;
import com.teste.integracao.spring.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<Cliente> listarTodos(){
        var optional = service.todos();

        if (!optional.isEmpty()){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaPor(@PathVariable Integer id) {
        var optional = service.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Cliente> buscaPor(@PathVariable String nome) {
        var optional = service.buscaPor(nome);

        if (!optional.isEmpty()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/frete/{id}")
    public ResponseEntity<Cliente> buscarPorFretes_Id(@PathVariable Integer id) {
        var optional = service.buscarPorFretes_Id(id);

        if (optional != null) {
            return ResponseEntity.ok().build();
        } else {
          return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastro(@RequestBody @Valid Cliente cliente,
                                            UriComponentsBuilder builder) {

        final Cliente clienteSalvo = service.salva(cliente);
        final URI uri = builder
                .path("/clientes/{id}")
                .buildAndExpand(clienteSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(clienteSalvo );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualiza(@PathVariable Integer id,
                                            @RequestBody @Valid Cliente cliente) {
        Optional<Cliente> optional = service.buscaPor(id);

        if (optional.isPresent()) {
            cliente.setId(id);
            Cliente clienteAtualizado = service.salva(cliente);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Cliente> optional = service.buscaPor(id );

        if (optional.isPresent()) {
            service.removePelo(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
