package com.itaus.pagamento.api.servicos;

import java.util.List;

import com.itaus.pagamento.api.dto.PagamentoDto;

public interface PagamentosService {

	void pagamento(PagamentoDto dto);

	List<PagamentoDto> findByProdutoId(Long id);
}
