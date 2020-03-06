package com.web.br.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.web.br.model.Prato;
import com.web.br.service.PratoService;

@Controller
@RequestMapping("/prato")
public class PratoController {


	@Autowired
	private PratoService pratoService;
	
	
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrarPrato() {
		ModelAndView mv = new ModelAndView("/cadastros/cadastrarPrato");
		mv.addObject(new Prato());
		return mv;
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarPrato(@Validated Prato prato, @RequestParam(value = "imagem") MultipartFile imagem) {
		pratoService.cadastrarPrato(prato, imagem);
		ModelAndView mv = new ModelAndView("redirect:/prato/cadastrar");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarPratos() {
		List<Prato> listaPratos = pratoService.listarPratos();
		ModelAndView mv = new ModelAndView("index/index");
		mv.addObject("listaDePratos", listaPratos);
		return mv;
	}
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluirPratos(@PathVariable Long codigo) {
		pratoService.excluir(codigo);
		ModelAndView mv = new ModelAndView("redirect:/prato/listar");
		return mv;

	}
	@RequestMapping("/atualizar/{codigo}")
	public ModelAndView atualizarPratos(@PathVariable Long codigo) {
		Prato prato = pratoService.buscarId(codigo);
		ModelAndView mv = new ModelAndView("/cadastros/cadastrarPrato");
		mv.addObject("prato", prato);
		return mv;

	}
	
	
	

	
}
