package com.itaus.pagamento.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itaus.pagamento.api.entities.Produto;
import com.itaus.pagamento.api.servicos.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/todos")
	public List<Produto> findAll() {
		return produtoService.findAll();
	}

}
