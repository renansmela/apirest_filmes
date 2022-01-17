package com.renanmela.filmes.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.renanmela.filmes.domain.Avaliacao;
import com.renanmela.filmes.domain.Filme;
import com.renanmela.filmes.dto.FilmeDTO2;
import com.renanmela.filmes.repository.AvaliacaoRepository;
import com.renanmela.filmes.repository.FilmeRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private FilmeRepository filmeRepository;
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Override
	public void run(String...  arg0) throws Exception {
		
		filmeRepository.deleteAll();
		avaliacaoRepository.deleteAll();
		
		Filme titanic = new Filme(null, "Titanic", "O barco afundou", 9.5);
		Filme matrix = new Filme(null, "Matrix", "Um programador enlouquecido", 9.0);
		Filme homem_aranha = new Filme(null, "Homem Aranha", "Muita teia e muita queda", 8.9);
		
		filmeRepository.saveAll(Arrays.asList(titanic, matrix, homem_aranha));
		
		Avaliacao avaliacao1 = new Avaliacao(null, "Marry Jane", "Perdi meu emprego no terceiro filme >:( ", new FilmeDTO2(homem_aranha));
		Avaliacao avaliacao2 = new Avaliacao(null, "Dicaprio", "Eu realmente achei que ia morrer na agua gelada", new FilmeDTO2(titanic));

		avaliacaoRepository.saveAll(Arrays.asList(avaliacao1, avaliacao2));
		
		homem_aranha.getAvaliacoes().addAll(Arrays.asList(avaliacao1));
		titanic.getAvaliacoes().addAll(Arrays.asList(avaliacao2));
		filmeRepository.saveAll(Arrays.asList(titanic, matrix, homem_aranha));
	}
	
}
