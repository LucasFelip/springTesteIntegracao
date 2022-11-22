package com.teste.integracao.spring.repository;

import com.teste.integracao.spring.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    List<Cidade> findByNomeContaining(String nome);

    Cidade findByFretes_Id(Integer id);

    List<Cidade> findByUf(String uf);

}