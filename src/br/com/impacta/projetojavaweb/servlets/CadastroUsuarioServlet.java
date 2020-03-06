package br.com.impacta.projetojavaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastro")
public class CadastroUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -595180341272296993L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("ISO-8859-1");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cadastro realizado com sucesso!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Cadastro realizado com sucesso!</h1>");
		out.println("<h4>Nome:</h4>" + request.getParameter("nome"));
		out.println("<h4>Login:</h4>" + request.getParameter("login"));
		out.println("<h4>Senha:</h4>" + request.getParameter("senha"));
		out.println("</body>");
		out.println("</html>");
		
	}	
	
	

}
