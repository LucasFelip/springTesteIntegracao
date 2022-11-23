package com.teste.integracao.spring.domain.service;

import com.teste.integracao.spring.domain.model.Cliente;
import com.teste.integracao.spring.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> todos() {
        return repository.findAll();
    }

    public Optional<Cliente> buscaPor(Integer id) {
        return repository.findById(id);
    }

    public List<Cliente> buscaPor(String nome) {
        return repository.findByNomeContaining(nome);
    }

    public Cliente buscarPorFretes_Id(Integer id) {
        return repository.findByFretes_Id(id);
    }

    @Transactional
    public Cliente salva(Cliente cliente) {
        return repository.save(cliente);
    }


    @Transactional
    public void removePelo(Integer id) {
        repository.deleteById(id);
    }
}
