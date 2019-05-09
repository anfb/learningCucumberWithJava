package com.learningcucumberwithjava.service;

import java.util.Calendar;

import com.learningcucumberwithjava.entity.Movie;
import com.learningcucumberwithjava.entity.NotaAluguel;

public class AluguelService {

	public NotaAluguel alugar(Movie movie) {
		NotaAluguel nota = new NotaAluguel();
		nota.setPreco(movie.getAluguel());
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		nota.setDataEntrega(calendar.getTime());
		
		movie.setQtdEstoque(movie.getQtdEstoque() - 1);
		
		return nota;
	}
}

