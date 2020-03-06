package com.web.br.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	
	@Id
	String papel;
	@ManyToMany(mappedBy = "roles")
	private List<Pessoa> pessoas;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.papel;
	}

	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
	public Role() {
			
	}
	
	public Role(String papel, List<Pessoa> pessoas) {
		this.papel = papel;
		this.pessoas = pessoas;
	}
	
}
