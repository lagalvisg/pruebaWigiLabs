package com.example.client.mongodb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.client.login.ClientLogin;
import com.example.client.login.LoginResponse;


public class ClientMongodb {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientMongodb cliente = new ClientMongodb();
		//List<UsersTest> usuarios = new ArrayList<>();
		
Date fechaIngreso = new Date();
		
		Movies movie1 = new Movies();
		movie1.setId("002");
		movie1.setCalificacion(5.0);
		movie1.setFechaIngreso(fechaIngreso);
		movie1.setFechaIngreso(fechaIngreso);
		movie1.setNombre("La isla siniestra editada cliente patch");
		movie1.setDescripcion("Protagonizada por leonardo dicarpio, narra la historia de una paciente perdida,"
				+ "que sera encontrada por dos detectives, que no saben cual es su posición dentro del centro de rehabilitacion");
		movie1.setElenco("LeonardoDicaprio-Tom Hanks");
		
	
		String saveMovie= cliente.saveMovie(movie1);
		String editMovie = cliente.editMovie(movie1);
		String deleteMovie = "no haga nada";
		//String deleteMovie = cliente.deleteMovie(movie1);
		
		System.out.println("Resultado de operacion: "+saveMovie+ " " +editMovie+" "+deleteMovie);
		
		List<Movies> movies = new ArrayList<>();
		
	    movies = cliente.seeAll();
	    
	    System.out.println("#peliculas: "+movies.size());
	    
	    
		
		
	}
	
	
	
	public String  saveMovie(Movies movie) {
		
		
String result = " init";
		
		try {	
			final String uri = "http://localhost:8080/createMovie";
			 
	
		 
		    RestTemplate restTemplate = new RestTemplate();
		   Object resultO = restTemplate.postForObject( uri,movie,Object.class);
		   result = resultO.toString();
		   
		}catch(Exception e){
			
			return e.getMessage();
		}
		
		return result;
		
		
			}
	
	
	
	public String  deleteMovie(Movies movie) {
		
String result = " init";
		
		try {	
			final String uri = "http://localhost:8080/deleteMovie";
			 
	
		 
		    RestTemplate restTemplate = new RestTemplate();
		   Object resultO = restTemplate.postForObject( uri,movie,Object.class);
		   result = resultO.toString();
		   
		}catch(Exception e){
			
			return e.getMessage();
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
public String  editMovie(Movies movie) {
	String result = " init";
	
	try {	
		final String uri = "http://localhost:8080/createMovie";
		 

	 
	    RestTemplate restTemplate = new RestTemplate();
	   Object resultO = restTemplate.postForObject( uri,movie,Object.class);
	   result = resultO.toString();
	   
	}catch(Exception e){
		
		return e.getMessage();
	}
	
	return result;
	
	
		}

	
	
	
	
	
	
	
	
	public List<Movies> seeAll(){
		
List<Movies> movies = new ArrayList<>();

try {	
	final String uri = "http://localhost:8080/seeMovies";
	 
    RestTemplate restTemplate = new RestTemplate();
    
    ResponseEntity<Movies[]> response =
    		  restTemplate.getForEntity(
    		  uri,
    		  Movies[].class);
    
    		Movies[] result = response.getBody();
    		
    		   for(int i = 0; i<result.length;i++) {
    			   movies.add(result[i]);
    		   }
    		   
    			return movies;	
    		
 
   
	

   
}catch(Exception e){
	e.getMessage();
	return movies;
}


		
	
		
	}
	

	public List<Movies> seeLastMovies() {
		// TODO Auto-generated method stub
		List<Movies> movies = new ArrayList<>();
		try {	
			final String uri = "http://localhost:8080/seeLastMovies";
			 
		    RestTemplate restTemplate = new RestTemplate();
		    
		    ResponseEntity<Movies[]> response =
		    		  restTemplate.getForEntity(
		    		  uri,
		    		  Movies[].class);
		    
		    		Movies[] result = response.getBody();
		    		
		    		   for(int i = 0; i<result.length;i++) {
		    			   movies.add(result[i]);
		    		   }
		    		   
		    			return movies;	
		    		
		 
		   
			

		   
		}catch(Exception e){
			e.getMessage();
			return movies;
		}

		
		
	}
	
	

}
