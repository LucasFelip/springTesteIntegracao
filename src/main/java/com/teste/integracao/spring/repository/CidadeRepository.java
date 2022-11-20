package com.teste.integracao.spring.repository;

import com.teste.integracao.spring.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}