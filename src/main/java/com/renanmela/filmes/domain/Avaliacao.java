package com.renanmela.filmes.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.renanmela.filmes.dto.FilmeDTO2;

@Document
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome_user;
	private String comentario;
	private FilmeDTO2 movie;
	
	
	public Avaliacao() {
	}

	public Avaliacao(String id, String nome_user, String comentario, FilmeDTO2 movie){
		super();
		this.id = id;
		this.nome_user = nome_user;
		this.comentario = comentario;
		this.movie = movie;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
