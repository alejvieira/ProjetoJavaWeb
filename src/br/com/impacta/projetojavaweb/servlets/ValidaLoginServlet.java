package br.com.impacta.projetojavaweb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javaweb.pojo.Usuario;


@WebServlet("/validaLogin")
public class ValidaLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ValidaLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if (login != null && senha != null ){
		
			login = login.trim();
			senha = senha.trim();
			
			if(!login.isEmpty() && !senha.isEmpty() 
					&& login.equals("admin")
					&& senha.equals("admin123")){
				
				Usuario usuario = new Usuario();
				usuario.setLogin(login);
				usuario.setSenha(senha);
				
				request.getSession().setAttribute("usuario", usuario);
				
				
				RequestDispatcher dispacher = request.getRequestDispatcher("/sistema");
				dispacher.forward(request, response);
				
				return;
				
			}
		}
		
		response.sendRedirect("/ProjetoJavaWeb/erro_login.html");
		
			
		
	}

}
