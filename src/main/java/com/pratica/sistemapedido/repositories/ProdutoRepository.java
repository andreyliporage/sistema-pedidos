package com.pratica.sistemapedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.sistemapedido.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
