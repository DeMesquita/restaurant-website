package com.web.br.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.br.model.Item;
import com.web.br.model.Prato;
import com.web.br.service.PratoService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@Autowired
	PratoService pratoServic;
	
	@RequestMapping("/index")
	public String index() {
		return "/carrinho/indexcarrinho.html";
	}
	
	@RequestMapping("/comprar/{codigo}")
	public ModelAndView comprar(@PathVariable Long codigo, HttpSession session) {	
		if (session.getAttribute("carrinho") == null) {
			List<Item> carrinho = new ArrayList<Item>();
			Prato prato = pratoServic.buscarId(codigo);
			Item item = new Item(prato, 1);
			carrinho.add(item);
			System.out.println(item.getPrato().getNome()+" "+item.getPrato().getValor()+" "+item.getQuantidade());
			session.setAttribute("carrinho", carrinho);
		} else {
			List<Item> carrinho = (List<Item>) session.getAttribute("carrinho");
			int index = this.exists(codigo, carrinho);//teste equals
			if (index == -1) {//novo produto
				Prato prato = pratoServic.buscarId(codigo);
				Item item = new Item(prato, 1);
				System.out.println(item.getPrato().getNome()+" "+item.getPrato().getValor()+" "+item.getQuantidade());
				carrinho.add(item);
			} else {//produto existente, incrementa em um
				int qtd = carrinho.get(index).getQuantidade() + 1;
				carrinho.get(index).setQuantidade(qtd);
				
			}
			session.setAttribute("carrinho", carrinho);

		}
		ModelAndView mv = new ModelAndView("redirect:/carrinho/index");
		return mv;
		
	}

	@RequestMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable Long codigo, HttpSession session) {
		List<Item> carrinho = (List<Item>) session.getAttribute("carrinho");
		int index = this.exists(codigo, carrinho);
		carrinho.remove(index);
		session.setAttribute("carrinho", carrinho);
		ModelAndView mv = new ModelAndView("redirect:/carrinho/index");
		return mv;
	}
	
	//vendo se prato já está adicionado
	private int exists(Long codigo, List<Item> carrinho) {
		for (int i = 0; i < carrinho.size(); i++) {
			if (carrinho.get(i).getPrato().getCod().equals(codigo)) {
				return i;
			}
		}
		return -1;
	}
	
}
