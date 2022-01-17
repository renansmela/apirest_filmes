package com.renanmela.filmes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.renanmela.filmes.domain.Avaliacao;

@Repository
public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String> {

}
