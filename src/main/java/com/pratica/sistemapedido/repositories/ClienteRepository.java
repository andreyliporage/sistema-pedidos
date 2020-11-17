package com.pratica.sistemapedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.sistemapedido.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
