package com.itaus.pagamento.api.dto;

import java.math.BigDecimal;

import com.itaus.pagamento.api.entities.Produto;

public class PagamentoDto {
	public Long produtoId;
	public Integer parcelas;
	public Produto produto;
	public BigDecimal valor;
	public String data;
}
