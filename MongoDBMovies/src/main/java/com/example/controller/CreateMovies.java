package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Movies;
import com.example.service.MoviesService;

@Service
public class CreateMovies {
	
	@Autowired
	MoviesService moviesService;
	
	
	public boolean saveMovie(Movies movie) {
		
        /*List<Movies> movies = new ArrayList<>();
		
		Date fechaIngreso = new Date();
		
		Movies movie1 = new Movies();
		movie1.setId("002");
		movie1.setCalificacion(5.0);
		movie1.setFechaIngreso(fechaIngreso);
		movie1.setFechaIngreso(fechaIngreso);
		movie1.setNombre("La isla siniestra editada");
		movie1.setDescripcion("Protagonizada por leonardo dicarpio, narra la historia de una paciente perdida,"
				+ "que sera encontrada por dos detectives, que no saben cual es su posición dentro del centro de rehabilitacion");
		movie1.setElenco("LeonardoDicaprio-Tom Hanks");
		
		movies.add(movie1);*/
		
boolean result = false;
		
		try {	
			moviesService.save(movie);
			result = true;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
		
		return result;
		
		
		//moviesService.save(movie1);
	}
	
	public boolean deleteMovie(Movies movie) {
		
		boolean result = false;
		
		try {	
		    String id = movie.getId();
			moviesService.deleteById(id);
			result = true;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
		
		return result;
		
		
	}
	
public boolean editMovie(Movies movie) {
	boolean result = false;
	
	try {	
		moviesService.save(movie);
		result = true;
	}catch(Exception e){
		e.getMessage();
		return false;
	}
	
	return result;
	
	
	}
	
	
	
	
	
	public List<Movies> seeAll(){
		
		return moviesService.findAll();
	}
	

	public List<Movies> seeLastMovies() {
		// TODO Auto-generated method stub
		int top = 5;
		
		List<Movies> lastMovies = new ArrayList<>();
		
		List<Movies> movies = new ArrayList<>();
		movies = moviesService.findAllByOrderByIdDesc();
		
		for(int i = 0; i<=top;i++) {
			
			lastMovies.add(movies.get(i));
		}
		
		
		return lastMovies;
	}
	
	

}
