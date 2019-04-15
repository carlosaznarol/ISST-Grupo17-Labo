package es.upm.dit.isst.Labo17.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/AvanzadoServlet")
public class AvanzadoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		getServletContext().getRequestDispatcher( "/Avanzado.jsp" ).forward( req, resp );
	}
	
	
	
		

}
