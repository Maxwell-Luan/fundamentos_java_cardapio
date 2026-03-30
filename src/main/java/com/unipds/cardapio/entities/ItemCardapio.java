package com.unipds.cardapio.entities;

import java.math.BigDecimal;

import com.unipds.cardapio.enums.CategoriaCardapio;

public record ItemCardapio(Long id, String nome, String descricao, CategoriaCardapio categoria, BigDecimal preco,
		BigDecimal precoComDesconto) {

	public ItemCardapio alterarPreco(BigDecimal novoPreco) {
		return new ItemCardapio(id, nome, descricao, categoria, novoPreco, precoComDesconto);
	}

}