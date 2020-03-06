package com.web.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.br.model.Pessoa;
import com.web.br.model.Role;
import com.web.br.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired //Spring cria objeto quando necessário
	private PessoaRepository pessoaRepository;
	
	public void cadastrarCliente(Pessoa pessoa) {
		List<Role> roles =  new ArrayList<Role>();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa);
		Role role = new Role("ROLE_CLIENTE", pessoas);
		roles.add(role);		
		pessoa.setRoles(roles);
		pessoa.setSenha(new BCryptPasswordEncoder().encode(pessoa.getSenha()));//criptografando senha
		pessoaRepository.save(pessoa);//Spring cria objeto que está sendo salvo no banco de dados, tabela cliente

	}
	
}
