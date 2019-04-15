 package es.upm.dit.isst.Labo17.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.upm.dit.isst.Labo17.dao.ComunidadDAO;
import es.upm.dit.isst.Labo17.dao.ComunidadDAOImplementation;
import es.upm.dit.isst.Labo17.model.Comunidad;




@WebServlet("/CreateComunidadServlet")
public class CreateComunidadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter( "nombre" );
		//String acronimo = req.getParameter( "acronimo" );
		String escanos = req.getParameter( "escanos" );
		String censo = req.getParameter( "censo" );
		
		int censo2 = Integer.parseInt(censo);
		int escanos2 = Integer.parseInt(escanos);
		
		
		
		Comunidad comunidad = new Comunidad();
		
		comunidad.setNombre(nombre);
		//comunidad.setAcronimo(acronimo);
		comunidad.setCenso(censo2);
		comunidad.setEscanos(escanos2);
		
		
		
		ComunidadDAO dao = ComunidadDAOImplementation.getInstance();
		dao.update(comunidad);
		
		resp.sendRedirect( req.getContextPath() + "/ComunidadesServlet" );
	}
	
	
	
	

}
