package com.itaus.pagamento.api.servicos.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaus.pagamento.api.entities.Produto;
import com.itaus.pagamento.api.repository.ProdutoRepository;
import com.itaus.pagamento.api.servicos.ProdutoService;

@Service
public class ProdutoServiceImp implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> findAll() {
		List<Produto> result = produtoRepository.findAll();
		if (result == null)
			result = new ArrayList<>();
		return result;
	}

	@Override
	public Produto findById(Long id) {
		return produtoRepository.findOne(id);
	}

	@Override
	public void decrementarParcela(Produto produto, Integer parcelas) {
		Integer quantidade = produto.getParcelas() - parcelas;
		produto.setParcelas(quantidade);
		produtoRepository.save(produto);
	}

}
