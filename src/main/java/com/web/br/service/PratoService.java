package com.web.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.br.model.Prato;
import com.web.br.repository.PratoRepository;
import com.web.br.util.ImagemFileUtils;

@Service
public class PratoService {

	@Autowired //Spring cria objeto quando necessário
	private PratoRepository pratoRepository;

	
	public void cadastrarPrato(Prato prato, MultipartFile imagem) {
		String caminho = "images/"+prato.getNome()+".png";
		ImagemFileUtils.salvarImagem(caminho, imagem);
		pratoRepository.save(prato);//Spring cria objeto que está sendo salvo no banco de dados

	}

	public List<Prato> listarPratos() {
		return pratoRepository.findAll();
	}
	
	public void excluir(Long codigo) {
		pratoRepository.deleteById(codigo);
		
	}

	public Prato buscarId(Long codigo) {
		return pratoRepository.getOne(codigo);
		
	}
	
	

}
