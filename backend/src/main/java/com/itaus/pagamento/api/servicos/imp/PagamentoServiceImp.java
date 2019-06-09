package com.itaus.pagamento.api.servicos.imp;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaus.pagamento.api.dto.PagamentoDto;
import com.itaus.pagamento.api.entities.Pagamento;
import com.itaus.pagamento.api.entities.Produto;
import com.itaus.pagamento.api.repository.PagamentoRepository;
import com.itaus.pagamento.api.servicos.PagamentosService;
import com.itaus.pagamento.api.servicos.ProdutoService;

@Service
public class PagamentoServiceImp implements PagamentosService {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Override
	public void pagamento(PagamentoDto dto) {
		Produto produto = produtoService.findById(dto.produtoId);

		if (produto != null) {
			if (produto.getParcelas() == 0)
				return;

			BigDecimal valorParcela = produto.getValor()
					.divide(new BigDecimal(dto.parcelas), new MathContext(2, RoundingMode.HALF_EVEN));
			
			
			Pagamento pagamento = new Pagamento(valorParcela, produto);
			pagamentoRepository.save(pagamento);
			produtoService.decrementarParcela(produto, dto.parcelas);
		}

	}

	@Override
	public List<PagamentoDto> findByProdutoId(Long id) {
		List<Pagamento> result = pagamentoRepository.findByProdutoId(id);
		List<PagamentoDto> pagamentos = new ArrayList<>();
		if(result == null) result = new ArrayList<>();

		result.forEach(r -> pagamentos.add(r.buildDto()));
		return pagamentos;
	}

}
