package com.learningcucumber.locadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import com.learningcucumberwithjava.entity.Movie;
import com.learningcucumberwithjava.entity.NotaAluguel;
import com.learningcucumberwithjava.service.AluguelService;

import cucumber.api.java8.En;

public class LocadoraApiStepDefs implements En{
	
	private Movie movie;
	private AluguelService service = new AluguelService();
	private NotaAluguel notaAluguel = new NotaAluguel();
	
	public LocadoraApiStepDefs() {
		
		Given("^existem (\\d+) filmes em estoque$", (Integer qtdEstoque) -> {
		   movie = new Movie();
		   movie.setQtdEstoque(qtdEstoque);
		});

		Given("^o preco do aluguel for (\\d+) reais$", (Integer valorAluguel) -> {
		    movie.setAluguel(valorAluguel.intValue());
		});

		When("^quando o filme for alugado$", () -> {
		    notaAluguel = service.alugar(movie);
		});
		Then("^o preco do aluguel sera (\\d+) reais$", (Integer preco) -> {
			assertEquals(preco.intValue(), notaAluguel.getPreco());
		});

		Then("^a data de entrega sera no dia seguinte$", () -> {
		   Calendar calendar = Calendar.getInstance();
		   calendar.add(Calendar.DAY_OF_MONTH, 1);
		 
		   Date dataRetorno = notaAluguel.getDataEntrega();
		   Calendar calRetorno = Calendar.getInstance();
		   calRetorno.setTime(dataRetorno);
		   
		   assertEquals(calendar.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
		   assertEquals(calendar.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
		   assertEquals(calendar.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
		});

		Then("^o estoque do filme sera (\\d+) unidade$", (Integer estoque) -> {
		   assertEquals(estoque.intValue(), movie.getQtdEstoque());
		});

	}
}
