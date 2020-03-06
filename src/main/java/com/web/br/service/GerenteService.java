package com.web.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.br.model.Gerente;
import com.web.br.repository.GerenteRepository;

@Service
public class GerenteService {
	@Autowired
	private GerenteRepository repositorioGerente;
	
	public void cadastrarGerente(Gerente gerente) {
		repositorioGerente.save(gerente);
	}

}
