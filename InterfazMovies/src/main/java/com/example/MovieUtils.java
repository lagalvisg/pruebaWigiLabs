package com.example;

public abstract class MovieUtils {
	
	private String usuario;
	private String contraseña;
	
	public MovieUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public abstract boolean authenticateUser(String user, String contraseña);

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	

}
