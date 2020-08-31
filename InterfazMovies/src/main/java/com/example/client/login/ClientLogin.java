package com.example.client.login;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.MovieUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ClientLogin extends MovieUtils{
	
	
	public Usuario usuario = new Usuario();



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientLogin cliente = new ClientLogin();
		//List<UsersTest> usuarios = new ArrayList<>();
		   
		LoginResponse usuariosResult= cliente.postUsers("pruebasparaclaro15@gmail.com","Colombia2039");
		
		System.out.println("Usuario: "+usuariosResult.getResponse().getUsuario().getNombre());
		
	}
	
	
	
	public LoginResponse postUsers(String usuario, String contraseña)
	{
	    final String uri = "https://apiselfservice.co/api/index.php/v1/soap/LoginUsuario.json";
	    
	    final HttpHeaders headers = new HttpHeaders();
        headers.set("X-MC-SO", "WigilabsTest");

        //Create a new HttpEntity
       
        
   	 
	    Data data = new Data();
	    data.setNombreUsuario(usuario);
	    data.setClave(contraseña);
	    
	    DataRequest dataRequest = new DataRequest();
	    dataRequest.setData(data);
	    
	    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    try {
			String json = ow.writeValueAsString(dataRequest);
			System.out.println("json: "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    HttpEntity<DataRequest> entity = new HttpEntity<>(dataRequest, headers);
        
        //Execute the method writing your HttpEntity to the request
	    RestTemplate restTemplate = new RestTemplate();
	    
        
        //LoginResponse result = response.getBody();
	   // ResponseEntity<LoginResponse> response = restTemplate.postForEntity( uri, entity, LoginResponse.class);
	 
	    //ResponseEntity<Object> response = restTemplate.postForEntity( uri, entity, Object.class);

	    LoginResponse result = new LoginResponse();
	    LoginResponse resultEmpty = new LoginResponse();
	    
	    try {
	    ResponseEntity<LoginResponse> response = restTemplate.postForEntity( uri, entity, LoginResponse.class);
	    
	    
	    
	   result = response.getBody();
	    }
	    catch(Exception e) {
	    	return resultEmpty;
	    }
	   
		return result;
	}



	@Override
	public boolean authenticateUser(String user, String password) {
		// TODO Auto-generated method stub

		LoginResponse result = new LoginResponse();
		result = postUsers(user, password);
		if(result.getResponse().getUsuario().getNombre().contains("Gerencia")) {
			return true;
		}
		
		return false;
	}










	

	
	
	
	

}

