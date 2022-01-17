package com.renanmela.filmes.dto;

import java.io.Serializable;

import com.renanmela.filmes.domain.Filme;

public class FilmeDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public FilmeDTO2() {		
	}
	
	public FilmeDTO2(Filme obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
