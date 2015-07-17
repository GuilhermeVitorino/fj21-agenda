package br.com.caelum.mvc.logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class IniciaAlteraContatoLogic implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimento = req.getParameter("dataNascimento");
		
	     System.out.println(dataNascimento);
	     
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
		cal.setTime(sdf.parse(dataNascimento));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setCalendar(cal);
        
		req.setAttribute("id", id);
		req.setAttribute("nome", nome);
		req.setAttribute("email", email);
		req.setAttribute("endereco", endereco);
		req.setAttribute("dataNascimento", dateFormat.format(cal.getTime()));
				
		return "/WEB-INF/jsp/altera-contato.jsp";
	}
}