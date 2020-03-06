package com.web.br.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.web.br.security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	UserDetailsServiceImplementacao userDetailServiceImp;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { //Controle de acesso as páginas
		http.csrf().disable().authorizeRequests() //Autorizando requisições abaixo
		
		.antMatchers("/prato/cadastrar").hasRole("GERENTE")
		.antMatchers("/prato/salvar").hasRole("GERENTE")
		.antMatchers("/prato/excluir/{codigo}").hasRole("GERENTE")
		.antMatchers("/prato/atualizar/{codigo}").hasRole("GERENTE")
		.antMatchers("/carrinho/comprar/{codigo}").hasRole("CLIENTE")
		.antMatchers("/carrinho/remover/{codigo}").hasRole("CLIENTE")
		.antMatchers("/carrinho/index").hasRole("CLIENTE")
		.antMatchers("/cliente/cadastrar").permitAll()
		.antMatchers("/cliente/logar").permitAll()
		.antMatchers("/cliente/salvar").permitAll()
		.antMatchers("/prato/listar").permitAll()
		
		.anyRequest().authenticated() //para outros acessos deve haver autenticação
		
		.and()
		.formLogin()
		.loginPage("/cliente/logar").defaultSuccessUrl("/prato/listar").permitAll()
		.permitAll()
		
		.and()
		.logout()
		.logoutSuccessUrl("/cliente/logar?logout")
		.permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**","/img/**", "/images/**");

	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailServiceImp).passwordEncoder(new BCryptPasswordEncoder());
	}

	

}
