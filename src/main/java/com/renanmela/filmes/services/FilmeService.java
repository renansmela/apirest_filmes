package com.renanmela.filmes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanmela.filmes.domain.Filme;
import com.renanmela.filmes.dto.FilmeDTO;
import com.renanmela.filmes.repository.FilmeRepository;
import com.renanmela.filmes.services.exception.ObjectNotFoundException;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository repo;
	
	public List<Filme> findALL(){
		return repo.findAll();
	}
	
	public Filme findById(String id) {
		Optional<Filme> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public Filme insert(Filme obj) {
		return repo.insert(obj);		
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Filme update(Filme obj) {
		Filme newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Filme newObj, Filme obj) {
		newObj.setNome(obj.getNome());
		newObj.setSinopse(obj.getSinopse());
		newObj.setImdb(obj.getImdb());
	}

	public Filme fromDTO(FilmeDTO objDto) {
		return new Filme(objDto.getId(), objDto.getNome(), objDto.getSinopse(), objDto.getImdb());
	}
}

