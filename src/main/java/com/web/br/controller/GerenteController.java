package com.web.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.br.model.Gerente;
import com.web.br.service.GerenteService;

@Controller
public class GerenteController {
	
	@Autowired
	private GerenteService serviçoGerente;
	
	@RequestMapping("/cadastrar")
	public String cadastroGerente(){
		return "/cadastros/cadastrarGerente";
	}
	
	@RequestMapping("/salvar")
	public String salvarGerente(Gerente gerente) {
		serviçoGerente.cadastrarGerente(gerente);
		return "/mensagens/sucessoGerenteCadastrado";
		
	}
}
