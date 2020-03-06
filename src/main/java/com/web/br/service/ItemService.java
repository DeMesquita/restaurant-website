package com.web.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.br.model.Item;
import com.web.br.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public void salvar(Item item) {
		itemRepository.save(item);
	}
	public void excluir(Long cod) {
		itemRepository.deleteById(cod);
	}
	public List<Item> listar( ){
		return itemRepository.findAll();
	}
}
