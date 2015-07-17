package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "OiServlet",
		urlPatterns = {"/oi", "/ola"},
		//Parametro passado quando inicia-se o Servlet
		initParams = {
		@WebInitParam(name = "param1", value = "Valor do parametro 1")})

public class OiMundo extends HttpServlet {

		protected void service (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			PrintWriter out = response.getWriter();
			
			// escreve o texto
			out.println("<html>");
			out.println("<body>");
			out.println("Primeira servlet");
			out.println("</br>");
			out.println("</br>");
			out.println("Valor do param1 = "+ getServletConfig().getInitParameter("param1"));
			out.println("</body>");
			out.println("</html>");
		}
}
