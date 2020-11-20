package com.pratica.sistemapedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.sistemapedido.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

} 
