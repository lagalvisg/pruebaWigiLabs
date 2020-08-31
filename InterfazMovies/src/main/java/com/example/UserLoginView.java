package com.example;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.example.client.login.ClientLogin;
import com.example.client.login.Usuario;

/*
 * 
USER: pruebasparaclaro15@gmail.com
PASS: Colombia2039
 */

@Named
@ViewScoped
public class UserLoginView {

	private String username;
	private String password;
	
	private String userProfileID;
	private String documentNumber;
	
	private Usuario usuario;
	
	
	
	
	public UserLoginView() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String login() {
		boolean authenticate = false;
		ClientLogin clientLogin = new ClientLogin();
		
		authenticate = clientLogin.authenticateUser(username, password);
		
		
		
	if (authenticate) {
		usuario = clientLogin.postUsers(username, password).getResponse().getUsuario();
		documentNumber = usuario.getDocumentNumber();
		userProfileID = usuario.getUserProfileID();
	return "movies.xhtml";
	} else
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario o Contraseña errados."));
	 return null;
	}
	
	
	
	
	 
	public String getUserProfileID() {
		return userProfileID;
	}



	public void setUserProfileID(String userProfileID) {
		this.userProfileID = userProfileID;
	}



	public String getDocumentNumber() {
		return documentNumber;
	}



	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}



	/**
	* @return the username
	*/
	public String getUsername() {
	return username;
	}
	 
	/**
	* @param username the username to set
	*/
	public void setUsername(String username) {
	this.username = username;
	}
	 
	/**
	* @return the password
	*/
	public String getPassword() {
	return password;
	}
	 
	/**
	* @param password the password to set
	*/
	public void setPassword(String password) {
	this.password = password;
	}
	
	
	 
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	
	
}
