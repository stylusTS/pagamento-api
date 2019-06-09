package com.itaus.pagamento.api.servicos;

import java.util.List;

import com.itaus.pagamento.api.entities.Produto;

public interface ProdutoService {

	List<Produto> findAll();

	Produto findById(Long id);

	void decrementarParcela(Produto produto, Integer parcelas);
	
}
