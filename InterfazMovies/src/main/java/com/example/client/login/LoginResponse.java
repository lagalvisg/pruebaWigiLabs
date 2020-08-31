package com.example.client.login;

public class LoginResponse {
	
	private String error = "";
	private Response response = new Response();
    private String srv_nodo = "";
    private String  secs="";
    private String  server="";
    
	public LoginResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public String getSrv_nodo() {
		return srv_nodo;
	}

	public void setSrv_nodo(String srv_nodo) {
		this.srv_nodo = srv_nodo;
	}

	public String getSecs() {
		return secs;
	}

	public void setSecs(String secs) {
		this.secs = secs;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
	
	
    
    

}
