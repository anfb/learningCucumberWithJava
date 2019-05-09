package com.learningcucumberwithjava.persistence;

import java.util.ArrayList;
import java.util.List;

import com.learningcucumberwithjava.entity.Movie;

public class MovieRepository {

	List<Movie> movieList = new ArrayList();
	
	public void save (Movie movie) {
		movie.setQtdEstoque(movie.getQtdEstoque()+1);
		movieList.add(movie);
	}
	
	public Movie existMovie(String codeMovie) {
		Movie movie = new Movie();
		int busca = movieList.indexOf(codeMovie);
		
		return movie;
	}
	
}

