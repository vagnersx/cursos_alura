package br.com.vagner.lojaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vagner.Produto;

@WebServlet(urlPatterns = "/contato")
public class ContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Produto produto = new Produto("Rufitos", 0.10);
		PrintWriter writer = resp.getWriter();
		writer.println("<html><h1>" + produto.getNome() + "</h1></html>");
		writer.close();
	}
}
