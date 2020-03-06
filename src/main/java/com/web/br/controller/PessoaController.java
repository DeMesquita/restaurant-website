package com.web.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.br.model.Pessoa;
import com.web.br.service.PessoaService;

@Controller
@RequestMapping("/cliente")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@RequestMapping("/cadastrar")
	public String cadastroCliente() {
		return "/cadastros/cadastrarCliente";
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCliente( @Validated Pessoa cli, BindingResult result) {
		
		ModelAndView mv = new ModelAndView("/cadastros/cadastrarCliente");
		if(result.hasErrors()) {
			return mv;
		}
		mv.addObject("mensagem", "Cadastro efetuado com sucesso!");
		pessoaService.cadastrarCliente(cli);
		return mv;
		
	}
	@RequestMapping("/logar")
	public ModelAndView formLogin() {
	    ModelAndView mv = new ModelAndView("/login/login");
	    return mv;
	}
	
			
		
	

}
