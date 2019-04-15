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


@WebServlet("/ComunidadesServlet")
public class ComunidadesServlet  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ComunidadDAO tdao = ComunidadDAOImplementation.getInstance();
		req.getSession().setAttribute( "Comunidad_list", tdao.readAll() );
		//Comunidad comunidad = new Comunidad();
		//comunidad = tdao.read("Alicante");
		//String esc = "Hola " + comunidad.getNombre();
		//System.out.println(">>>>>>>>>>>>>>SACAMOS EL NOMBREEEE: " + comunidad.getEscanos());
		
					
		getServletContext().getRequestDispatcher( "/ComunidadesAutonomas.jsp" ).forward( req, resp );
	}

}
