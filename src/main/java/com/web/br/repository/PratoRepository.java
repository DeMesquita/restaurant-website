package com.web.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.br.model.Prato;
@Repository
public interface PratoRepository extends JpaRepository<Prato, Long>{

}
