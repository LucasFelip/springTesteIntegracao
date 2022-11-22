package com.teste.integracao.spring.repository;

import com.teste.integracao.spring.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface FreteRepository extends JpaRepository<Frete, Integer> {
    @Override
    List<Frete> findAll();

    @Override
    Optional<Frete> findById(Integer integer);

    List<Frete> findByCliente_Id(Integer id);

    List<Frete> findByCliente_IdOrderByValcrAsc(Integer id);

    List<Frete> findByCidade_Id(Integer id);
}