package br.com.vagner;

import com.google.gson.ExclusionStrategy;
import com.google.gson.JsonNull;

/**
 * Hello world!
 *
 */
public class Produto {
	ExclusionStrategy exclusionStrategy;
	
	private final String nome;
	private final double preco;
	
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		System.out.println(JsonNull.INSTANCE);
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}

	public double getPrecoComImposto() {
		return preco * 1.10;
	}
}
