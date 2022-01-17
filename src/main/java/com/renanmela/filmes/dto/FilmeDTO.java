package com.renanmela.filmes.dto;

import java.io.Serializable;

import com.renanmela.filmes.domain.Filme;

public class FilmeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String sinopse;
	private double imdb;
	
	public FilmeDTO() {		
	}
	
	public FilmeDTO(Filme obj) {
		id = obj.getId();
		nome = obj.getNome();
		sinopse = obj.getSinopse();
		imdb = obj.getImdb();
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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public double getImdb() {
		return imdb;
	}

	public void setImdb(double imdb) {
		this.imdb = imdb;
	}
	
}
