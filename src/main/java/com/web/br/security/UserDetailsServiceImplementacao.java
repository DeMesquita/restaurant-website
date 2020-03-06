package com.web.br.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.web.br.model.Pessoa;
import com.web.br.repository.PessoaRepository;


@Repository
@Transactional
public class UserDetailsServiceImplementacao implements UserDetailsService{ 

	
	@Autowired 
	PessoaRepository pessoaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
			Pessoa cli = pessoaRepository.findByLogin(login);//busca cliente pelo email
			
			if(cli == null) {
				throw new UsernameNotFoundException("Cliente não encontrado");
			}
		
		return new User(cli.getUsername(),cli.getPassword(),true,true,true,true,cli.getAuthorities());
	}
	

}
