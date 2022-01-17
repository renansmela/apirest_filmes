package com.renanmela.filmes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.renanmela.filmes.domain.Filme;

@Repository
public interface FilmeRepository extends MongoRepository<Filme, String> {

}
