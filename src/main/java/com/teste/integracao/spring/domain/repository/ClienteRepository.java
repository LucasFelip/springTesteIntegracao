package com.teste.integracao.spring.domain.repository;

import com.teste.integracao.spring.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNomeContaining(String nome);

    Cliente findByFretes_Id(Integer id);
}