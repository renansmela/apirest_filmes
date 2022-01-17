package com.renanmela.filmes.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renanmela.filmes.domain.Avaliacao;
import com.renanmela.filmes.dto.AvaliacaoDTO;
import com.renanmela.filmes.services.AvaliacaoService;

@RestController
@RequestMapping(value="/avaliacoes")
public class AvaliacaoResources {
	
	@Autowired
	private AvaliacaoService service;
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<Avaliacao> findbyId(@PathVariable String id){
		Avaliacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody AvaliacaoDTO objDto){
		Avaliacao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
