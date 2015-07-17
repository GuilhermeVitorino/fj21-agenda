package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class IncluiContatoLogic implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimento = req.getParameter("dataNascimento");
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		cal.setTime(dateFormat.parse(dataNascimento));
		dateFormat.setCalendar(cal);
        
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(cal);

		Connection connection = (Connection) req.getAttribute("connection");
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);	
		System.out.println("Alterando contato... ");
		return "mvc?logica=ListaContatosLogic";
	}
}