package br.com.vagner.controller.dto;

public class TokenDTO {
	
	// Token do tipo JWT
	private String token;
	
	//É o tipo de autenticação a ser feita pelo cliente com o token que lhe foi devolvido
	// Bearer é um dos mecanismos de autenticação utilizados no protocolo HTTP, tal como o Basic e o Digest.
	private String tipo;
	
	public TokenDTO(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}
	
	
}
