package com.teste.integracao.spring.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.integracao.spring.domain.model.Frete;
import com.teste.integracao.spring.domain.repository.FreteRepository;

@Service
public class FreteService {
    @Autowired
    private final FreteRepository repository;

    public FreteService(FreteRepository repository) {
        this.repository = repository;
    }

    public List<Frete> todos() {
        return repository.findAll();
    }

    public Optional<Frete> buscaPor(Integer id) {
        return repository.findById(id);
    }

    public List<Frete> buscaPorCliente_Id(Integer id) {
        return repository.findByCliente_Id(id);
    }

    public List<Frete> buscaPorCidade_Id(Integer id) {
        return repository.findByCidade_Id(id);
    }

    public List<Frete> buscarPorCliente_IdOrderByValcrAsc(Integer id) {
        return repository.findByCliente_IdOrderByValcrAsc(id);
    }

    @Transactional
    public Frete salva(Frete frete) {
        return repository.save(frete);
    }

    @Transactional
    public void removePelo(Integer id) {
        repository.deleteById(id);
    }
}
