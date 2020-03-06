package com.web.br.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Item {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cod;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)    
    @JoinColumn(name = "prato_id")
	private Prato prato;
	/*
	 * @Id private Long cod;
	 * 
	 * @OneToOne(fetch = FetchType.LAZY)
	 * 
	 * @MapsId private Prato prato;
	 */
	
	private int quantidade;
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Item() {
		
	}
	public Item(Prato prato, int quantidade) {
		this.prato = prato;
		this.quantidade = quantidade;
	}
	
}
