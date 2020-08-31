package com.example;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.example.client.mongodb.ClientMongodb;
import com.example.client.mongodb.Movies;


@Named
@ViewScoped
	public class ImagesView {
		
	    private List<Movies> movies = new ArrayList<>();
	    private Movies selectedMovies = new Movies();
	    private Movies createdMovies = new Movies();
	    private Movies qualifiedMovies = new Movies();
	    
	    public ClientMongodb service = new ClientMongodb();


	    
	    
	    public ImagesView() {
			super();
			// TODO Auto-generated constructor stub
			movies = service.seeAll();
		}


	    @PostConstruct
	    public void init() {
	    	    
	   System.out.println("constructor...");
	        
	        
	    }
	    
	    

	  public String updateMovie() {
		  String result = "editar";
		  
		  ClientMongodb clienteMongoDB = new ClientMongodb();
		  
		  clienteMongoDB.editMovie(selectedMovies);
		  movies = service.seeAll();
		  System.out.println(result);
		  return result;
	  }
	  
	  public String deleteMovie() {
		  String result = "borrar";
		  
		  ClientMongodb clienteMongoDB = new ClientMongodb();
		  
		  clienteMongoDB.deleteMovie(selectedMovies);
		  movies = service.seeAll();
		  System.out.println(result);
		  return result;
	  }
	  
	  public String createMovie() {
		  String result = "crear";
		  
		  ClientMongodb clienteMongoDB = new ClientMongodb();
		  Date date = new Date();
		  createdMovies.setFechaIngreso(date);
		  clienteMongoDB.saveMovie(createdMovies);
		  movies = service.seeAll();
		  System.out.println(result);
		  return result;
	  }
	  
	  
	  public String qualifyMovie() {
		  String result = "calificar";
		  
		  Movies qualifiedMovie = new Movies();
		  
		  ClientMongodb clienteMongoDB = new ClientMongodb();
		  double calificacion = selectedMovies.getCalificacion();
		  
		  double calificacionNueva = ( calificacion + qualifiedMovies.getCalificacion() )/2;
		  
		  selectedMovies.setCalificacion(calificacionNueva);
		  qualifiedMovie = selectedMovies;
		  
		  clienteMongoDB.editMovie(qualifiedMovie);
		  movies = service.seeAll();
		  System.out.println(result);
		  return result;
	  }
	  
	  public String seeLastMovies() {
		  String result = "crear";
		  movies = service.seeLastMovies();
		  System.out.println(result);
		  return result;
	  }
	  
	  public String seeMovies() {
		  String result = "crear";
		  movies = service.seeAll();
		  System.out.println(result);
		  return result;
	  }
	  
	
	  
	  
	  
    
	    
	    public String doSomething() {
	 	    	
	    	System.out.println(" doSomething()");
	    	return "OK";
	    }
	    
	    
	    

	    

		public Movies getQualifiedMovies() {
			return qualifiedMovies;
		}


		public void setQualifiedMovies(Movies qualifiedMovies) {
			this.qualifiedMovies = qualifiedMovies;
		}


		public Movies getCreatedMovies() {
			return createdMovies;
		}


		public void setCreatedMovies(Movies createdMovies) {
			this.createdMovies = createdMovies;
		}


		public List<Movies> getMovies() {
			return movies;
		}


		public void setMovies(List<Movies> movies) {
			this.movies = movies;
		}


	

		public Movies getSelectedMovies() {
			return selectedMovies;
		}


		public void setSelectedMovies(Movies selectedMovies) {
			this.selectedMovies = selectedMovies;
		}


		public ClientMongodb getService() {
			return service;
		}


		public void setService(ClientMongodb service) {
			this.service = service;
		}

		
	    
	    

		
		
	    
	    
	    
	    
	}

	
