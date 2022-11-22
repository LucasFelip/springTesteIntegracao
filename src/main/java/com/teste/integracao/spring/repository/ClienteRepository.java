package com.teste.integracao.spring.repository;

import com.teste.integracao.spring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNomeContaining(String nome);

    Cliente findByFretes_Id(Integer id);


}