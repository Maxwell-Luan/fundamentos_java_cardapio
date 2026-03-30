package com.unipds.cardapio;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import com.unipds.cardapio.entities.Database;
import com.unipds.cardapio.entities.ItemCardapio;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CardapioApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CardapioApplication.class, args);

		Database database = new Database();
		
		ItemCardapio item = database.itemCardapioPorId(1L).orElseThrow();
		System.out.printf("\n%s (%d) R$ %s", item.nome(), item.id(), item.preco());
		
		database.alterarPrecoItemCardapio(1L, new BigDecimal("3.99")); //2.99 => 3.99
		database.alterarPrecoItemCardapio(1L, new BigDecimal("2.99")); //3.99 => 2.99
		database.alterarPrecoItemCardapio(1L, new BigDecimal("4.99")); //2.99 => 4.99
				
		database.imprimirRastroAuditoriaPrecos();
	}

}
