package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.*;


@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		log("Iniciando a Servlet!"); 
	}
	
	public void init(){
		super.destroy();
		log("Destruindo a Servlet!"); 
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
				PrintWriter out = response.getWriter();
				
				//buscando os parâmetros no request
				String nome = request.getParameter("nome");
				String endereco = request.getParameter("endereco");
				String email = request.getParameter("email");
				String dataEmTexto = request.getParameter("dataNascimento");
				Calendar dataNascimento = null;
				
				//fazendo a conversao da data
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
					dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(date);
				} catch (Exception e) {
					out.println("Erro na conversão da data");
					return; //para a execução do método
				}
				
				//monta um objeto contato
				Contato contato = new Contato();
				contato.setNome(nome);
				contato.setEndereco(endereco);
				contato.setEmail(email);
				contato.setDataNascimento(dataNascimento);
				
				Connection connection = (Connection) request.getAttribute("connection");
				ContatoDao dao = new ContatoDao(connection);
				dao.adiciona(contato);
				
//				//imprime o nome do contato que foi adicionado
//				out.println("<html>");
//				out.println("<body>");
//				out.println("Contato " + contato.getNome() + " adicionado com sucesso");
//				out.println("</body>");
//				out.println("<html>");
				
				RequestDispatcher re = request
						.getRequestDispatcher("/contato-adicionado.jsp");
				re.forward(request, response);
	}
}	
