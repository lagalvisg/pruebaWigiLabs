package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Movies;


@Repository
public interface MoviesService extends MongoRepository<Movies, String> {
    public List<Movies> findAll();
    //Para buscar por un campo especifico solo agregamos la siguiente linea:
    
	public Movies findMoviesByNombre(String nombre);
	
	//Para buscar en orden de la ultima a la primera pelicula:
	
	public List<Movies> findAllByOrderByIdAsc();

	public List<Movies> findAllByOrderByIdDesc();

    
}