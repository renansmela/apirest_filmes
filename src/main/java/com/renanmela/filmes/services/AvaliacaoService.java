package com.renanmela.filmes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renanmela.filmes.domain.Avaliacao;
import com.renanmela.filmes.dto.AvaliacaoDTO;
import com.renanmela.filmes.repository.AvaliacaoRepository;
import com.renanmela.filmes.services.exception.ObjectNotFoundException;

@Service
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository repo;
	
	public Avaliacao findById(String id) {
		Optional<Avaliacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public List<Avaliacao> findALL(){
		return repo.findAll();
	}
	
	public Avaliacao insert(Avaliacao obj) {
		return repo.insert(obj);		
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Avaliacao fromDTO(AvaliacaoDTO objDto) {
		return new Avaliacao(objDto.getId(), objDto.getNome_user(), objDto.getComentario(), objDto.getMovie());
	}
}

