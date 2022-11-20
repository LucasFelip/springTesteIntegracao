package com.teste.integracao.spring.repository;

import com.teste.integracao.spring.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreteRepository extends JpaRepository<Frete, Integer> {
    @Override
    List<Frete> findAll();

    Frete findById(Iterable<Integer> codigo_frete);

    //List<Frete> findByCidade();
}