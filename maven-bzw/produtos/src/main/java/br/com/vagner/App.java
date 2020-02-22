package br.com.vagner;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
	

	
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		Produto produto = new Produto("Bala juquinha sabor cereja", 1.1);
		System.out.println(produto.getNome());
		System.out.println(gson);
	}
}
