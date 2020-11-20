package com.pratica.sistemapedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.sistemapedido.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
