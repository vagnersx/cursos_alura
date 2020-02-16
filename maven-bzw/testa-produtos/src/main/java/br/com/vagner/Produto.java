package br.com.vagner;

/**
 * Hello world!
 *
 */
public class Produto {
	private final String nome;
	private final double preco;
	
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome + " 2";
	}
	
//	public double getPreco() {
//		return preco;
//	}
}

