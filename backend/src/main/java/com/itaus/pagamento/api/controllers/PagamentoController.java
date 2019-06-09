package com.itaus.pagamento.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itaus.pagamento.api.dto.PagamentoDto;
import com.itaus.pagamento.api.servicos.PagamentosService;

@CrossOrigin
@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentosService pagamentoService;

	@PostMapping("/salvar")
	public void salvar(@RequestBody PagamentoDto dto, HttpServletResponse response) {
		try {
			pagamentoService.pagamento(dto);
		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
		}
	}

	@GetMapping("/{produto}")
	public List<PagamentoDto> historicoPagamento(@PathVariable Long produto) {
		return pagamentoService.findByProdutoId(produto);
	}

}
