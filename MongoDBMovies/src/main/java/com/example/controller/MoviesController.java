package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Movies;
import com.example.service.MoviesService;

@RestController
public class MoviesController {

    
    @Autowired
    CreateMovies createMovies = new CreateMovies();
    
    
	@GetMapping("/seeMovies")
	public List<Movies> seeMovies(){
		
			
	
	
		return createMovies.seeAll();
	}
	
	@GetMapping("/seeLastMovies")
	public List<Movies> seeLastMovies(){
		
			return createMovies.seeLastMovies();
	

	}
	

    
	@RequestMapping(value = "/createMovie", method = RequestMethod.POST)
	public boolean createMovie(@RequestBody Movies movie){
		
		 return createMovies.saveMovie(movie);
	}
	
    
	@PutMapping("/editMovies")
	public boolean editMovies(@RequestBody Movies movie){
	
		return createMovies.saveMovie(movie);
		
	}
	
	
	@PatchMapping("/editMovie")
	public boolean editMovie(@RequestBody Movies movie){
	
		return createMovies.editMovie(movie);	
	}
	
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public void delete() {

	    }
	
	@PostMapping("/deleteMovie")
	public boolean deleteMovie(@RequestBody Movies movie){
		
		return createMovies.deleteMovie(movie);	
	}
	
	
	
	
	
    
    
}
