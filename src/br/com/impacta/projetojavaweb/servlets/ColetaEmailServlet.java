package br.com.impacta.projetojavaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javaweb.pojo.Usuario;

@WebServlet("/coletaEmail")
public class ColetaEmailServlet extends HttpServlet {
	private static final long serialVersionUID = -6833737828824000905L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		
		response.setCharacterEncoding("ISO-8859-1");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>Cadastro de Email</title>");
		out.println("</head><body>");
		out.println("<h2>" + usuario.getLogin() + "informe o seu email:</h2>");
		
		out.println("<form method=\"post\" action=\"adicionaEmailCookie\">");
		out.println("Email: </br> <input type=\"text\"  name=\"email\" size=\"80\"/> ");
		out.println("<p> <input type=\"submit\"  value=\"enviar\" /> </p>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}
	
	
	

}
