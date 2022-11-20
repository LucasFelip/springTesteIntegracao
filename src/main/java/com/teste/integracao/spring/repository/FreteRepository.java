package com.teste.integracao.spring.repository;

import com.teste.integracao.spring.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreteRepository extends JpaRepository<Frete, Integer> {
}