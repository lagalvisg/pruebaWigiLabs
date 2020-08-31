package com.example.client.login;

import java.util.ArrayList;
import java.util.List;

public class Response {
	
	private Usuario usuario = new Usuario();
	private List<Cuentas> cuentas = new ArrayList<>();
    
	public Response() {

		// TODO Auto-generated constructor stub
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Cuentas> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuentas> cuentas) {
		this.cuentas = cuentas;
	}
    
	
	
    
    
    

}
