package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.sql.DriverManager;

import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements javax.servlet.Filter {
// implementação do init e destroy, se necessário
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	
			// abre uma conexão
			Connection connection = new ConnectionFactory().getConnection();
			
			// "pendura um objeto no Request"
			request.setAttribute("connection", connection);
			
			// indica que o processamento do request deve prosseguir
			chain.doFilter(request, response);
			
			// fecha conexão
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
