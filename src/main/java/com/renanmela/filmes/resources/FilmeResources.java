package com.renanmela.filmes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renanmela.filmes.domain.Avaliacao;
import com.renanmela.filmes.domain.Filme;
import com.renanmela.filmes.dto.FilmeDTO;
import com.renanmela.filmes.services.FilmeService;


@RestController
@RequestMapping(value="/filmes")
public class FilmeResources {
	
	@Autowired
	private FilmeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<FilmeDTO>> findAll(){
		List<Filme> list = service.findALL();
		List<FilmeDTO> listDto = list.stream().map(x -> new FilmeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<FilmeDTO> findbyId(@PathVariable String id){
		Filme obj = service.findById(id);
		return ResponseEntity.ok().body(new FilmeDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody FilmeDTO objDto){
		Filme obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody FilmeDTO objDto , @PathVariable String id){
		Filme obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();	
	}
	
	@RequestMapping(value="/{id}/avaliacoes" , method=RequestMethod.GET)
	public ResponseEntity<List<Avaliacao>> findAvaliacoes(@PathVariable String id){
		Filme obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getAvaliacoes());
	}
}
