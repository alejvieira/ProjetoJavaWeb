package br.com.impacta.projetojavaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javaweb.models.Usuario;

@WebServlet("/sistema")
public class SistemaServelt extends HttpServlet {

	private static final long serialVersionUID = 2791674352741019247L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		String email = null;

		if (cookies != null) {
			for (Cookie coo : cookies) {
				if (coo.getName().equals("email")){
					email = coo.getValue();
					break;
				}

			}
		}
		
		String emailReq = request.getParameter("email");
		if (email == null && emailReq != null && !emailReq.isEmpty()) {
			email = emailReq;
		}

		if (email == null) {
				RequestDispatcher dispacher = request.getRequestDispatcher("/coletaEmail");
				dispacher.forward(request, response);
		} else {

			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			usuario.setEmail(email);

			response.setCharacterEncoding("ISO-8859-1");
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			out.println("<html><head>");
			out.println("<title>Sistema - Home</title>");
			out.println("</head><body>");
			out.println("<h1>Bem vindo " + usuario.getLogin() + "!</h1>");
			out.println("<h1>Seu Email é: " + usuario.getEmail() + "!</h1>");
			out.println("<h3>Está é a página principal do sistema</h3>");
			out.println("<h3><a href=\"login.html\">Logout</a></h3>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
