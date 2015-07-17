package br.com.caelum.mvc.logica;

import java.awt.List;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ListaContatosLogic implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		// Monta a lista de contatos
		Connection connection = (Connection) req.getAttribute("connection");
		ArrayList<Contato> contatos = new ContatoDao(connection).getLista();
		// Guarda a lista no request
		req.setAttribute("contatos", contatos);
		return "/WEB-INF/jsp/lista-contatos-scriptlet.jsp";
	}
}