package es.upm.dit.isst.Labo17.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import es.upm.dit.isst.Labo17.dao.ComunidadDAO;
import es.upm.dit.isst.Labo17.dao.ComunidadDAOImplementation;


@WebServlet("/BasicoServlet")
public class BasicoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ComunidadDAO tdao = ComunidadDAOImplementation.getInstance();
		//ProvinciaDAO pdao = ProvinciaDAOImplementation.getInstance();
		req.getSession().setAttribute( "Comunidad_list", tdao.readAll() );
		//req.getSession().setAttribute( "Provincia_list", pdao.readAll() );
		
		getServletContext().getRequestDispatcher( "/Basico.jsp" ).forward( req, resp );
		//resp.sendRedirect( req.getContextPath() + "/SimulacionServlet" );
	}
	
	
	
		

}