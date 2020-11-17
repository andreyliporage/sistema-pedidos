package com.pratica.sistemapedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.sistemapedido.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
