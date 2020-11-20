package com.pratica.sistemapedido.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pagamento pendente"),
	QUITADO(2, "Pagamento quitado"),
	CANCELADO(3, "Pagamento cancelado");
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		
		for (EstadoPagamento estado : EstadoPagamento.values()) {
			if (id.equals(estado.getCod())) {
				return estado;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}
	
}
