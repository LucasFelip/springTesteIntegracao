package com.teste.integracao.spring.service;

import com.teste.integracao.spring.domain.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreteService {
    @Autowired
    private final FreteRepository repository;

    public FreteService(FreteRepository repository) {
        this.repository = repository;
    }

    
}
