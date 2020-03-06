package com.web.br.model;



import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.web.br.model.Role;


@Entity
public class Pessoa implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long cod;
	
	@NotBlank(message = "O campo não pode ficar em branco")
	private String nome;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String cpf;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String data;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String email;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String login;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String senha;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String rua;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String numero;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String bairro;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String complemento;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String cidade;
	@NotBlank(message = "O campo não pode ficar em branco")
	private String estado;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( 
	        name = "pessoa_roles", 
	        joinColumns = @JoinColumn(
	          name = "pessoa_codigo", referencedColumnName = "cod"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_codigo", referencedColumnName = "papel")) 
	private List<Role> roles;
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.roles;
	}
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.login;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
