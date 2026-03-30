package com.unipds.cardapio.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.unipds.cardapio.enums.CategoriaCardapio;

public class Database {

	private final Map<Long, ItemCardapio> itensPorId = new HashMap<>();
	private final Map<ItemCardapio, BigDecimal> auditoriaPrecos = new IdentityHashMap<>();

	public Database() {
		ItemCardapio refrescoDoChaves = new ItemCardapio(1L, "Refresco do Chaves",
				"Suco de Limão, que parece tamarindo mas tem gosto de groselha", CategoriaCardapio.BEBIDAS,
				new BigDecimal("2.99"), null);
		itensPorId.put(1L, refrescoDoChaves);

		ItemCardapio sanduicheDePresunto = new ItemCardapio(2L, "Sanduíche de Presunto",
				"O preferido do Chaves. Só não peça para dividir.", CategoriaCardapio.PRATOS_PRINCIPAIS,
				new BigDecimal("15.50"), null);
		itensPorId.put(2L, sanduicheDePresunto);

		ItemCardapio churrosDonaFlorinda = new ItemCardapio(3L, "Churros da Dona Florinda",
				"Feitos com açúcar e muito carinho (e o Seu Madruga que fritou).", CategoriaCardapio.SOBREMESA,
				new BigDecimal("8.00"), null);
		itensPorId.put(3L, churrosDonaFlorinda);

		ItemCardapio cafeDaDonaFlorinda = new ItemCardapio(4L, "Café do Não Seria Muita Incomodação?",
				"Acompanha um convite para entrar e tomar uma xícara.", CategoriaCardapio.BEBIDAS,
				new BigDecimal("4.50"), null);
		itensPorId.put(4L, cafeDaDonaFlorinda);

		ItemCardapio tortaDePresunto = new ItemCardapio(5L, "Torta de Presunto Especial",
				"A versão 'gourmet' do sanduíche, digna de um festival.", CategoriaCardapio.PRATOS_PRINCIPAIS,
				new BigDecimal("22.00"), null);
		itensPorId.put(5L, tortaDePresunto);

		ItemCardapio pezinhosDePorco = new ItemCardapio(6L, "Pezinhos de Porco à la Seu Madruga",
				"Um clássico das compras de última hora no mercado.", CategoriaCardapio.PRATOS_PRINCIPAIS,
				new BigDecimal("18.90"), null);
		itensPorId.put(6L, pezinhosDePorco);

		ItemCardapio boloDaDonaClotilde = new ItemCardapio(7L, "Bolo da Bruxa do 71",
				"Dizem que foi feito com feitiçaria, mas é só chocolate.", CategoriaCardapio.SOBREMESA,
				new BigDecimal("12.00"), null);
		itensPorId.put(7L, boloDaDonaClotilde);

		ItemCardapio pirulitoDoKiko = new ItemCardapio(8L, "Pirulito Gigante",
				"Tão grande que causa inveja em toda a vizinhança.", CategoriaCardapio.SOBREMESA,
				new BigDecimal("5.50"), null);
		itensPorId.put(8L, pirulitoDoKiko);

		ItemCardapio panquecasDoSeuMadruga = new ItemCardapio(9L, "Panquecas de 'Creme'",
				"Receita especial que ele aprendeu enquanto não trabalhava.", CategoriaCardapio.ENTRADAS,
				new BigDecimal("10.00"), null);
		itensPorId.put(9L, panquecasDoSeuMadruga);

		ItemCardapio leiteDeBurra = new ItemCardapio(10L, "Leite de Burra",
				"Dizem que é bom para os nervos (ou para o Chaves quando se assusta).", CategoriaCardapio.BEBIDAS,
				new BigDecimal("6.00"), null);
		itensPorId.put(10L, leiteDeBurra);
	}

	public List<ItemCardapio> listaDeItensCardapio() {
		return new ArrayList<>(itensPorId.values());
	}

	public Optional<ItemCardapio> itemCardapioPorId(Long id) {
		return Optional.ofNullable(itensPorId.get(id));
	}

	public boolean removerItemCardapio(Long id) {
		ItemCardapio removido = itensPorId.remove(id);
		return removido != null;
	}

	public boolean alterarPrecoItemCardapio(Long id, BigDecimal novoPreco) {
		ItemCardapio itemAntigo = itensPorId.get(id);
		if(id == null) {
			return false;	
		}else {
			ItemCardapio itemComPrecoAlterado = itemAntigo.alterarPreco(novoPreco);
			itensPorId.put(id, itemComPrecoAlterado);
			auditoriaPrecos.put(itemAntigo, novoPreco);
			return true;
		}
	}

	public void imprimirRastroAuditoriaPrecos() {
		System.out.println("\nAuditoria de preços: ");
		auditoriaPrecos.forEach((itemAntigo, novoPreco) -> System.out.printf("\n- %s: %s => %s", itemAntigo.nome(), itemAntigo.preco(), novoPreco));
		System.out.println();
	}
}
