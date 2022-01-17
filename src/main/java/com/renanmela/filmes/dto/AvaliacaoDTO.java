package com.renanmela.filmes.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.renanmela.filmes.domain.Avaliacao;

@Document
public class AvaliacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome_user;
	private String comentario;
	private FilmeDTO2 movie;
	
	
	public AvaliacaoDTO() {
	}

	public AvaliacaoDTO(Avaliacao obj) {
		id = obj.getId();
		nome_user = obj.getNome_user();
		comentario = obj.getComentario();
		movie = obj.getMovie();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome_user() {
		return nome_user;
	}

	public void setNome_user(String nome_user) {
		this.nome_user = nome_user;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public FilmeDTO2 getMovie() {
		return movie;
	}

	public void setMovie(FilmeDTO2 movie) {
		this.movie = movie;
	}

	
	
	
}
