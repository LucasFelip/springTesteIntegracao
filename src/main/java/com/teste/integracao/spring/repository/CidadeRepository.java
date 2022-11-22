package com.teste.integracao.spring.repository;

import com.teste.integracao.spring.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    Cidade findByNomeContaining(String nome);

    Cidade findByFretes_Id(Integer id);

    List<Cidade> findByUf(String uf);
}