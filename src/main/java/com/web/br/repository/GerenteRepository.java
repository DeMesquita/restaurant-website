package com.web.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.br.model.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long>{

}
