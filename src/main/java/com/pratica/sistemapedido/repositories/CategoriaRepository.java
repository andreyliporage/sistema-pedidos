package com.pratica.sistemapedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.sistemapedido.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
