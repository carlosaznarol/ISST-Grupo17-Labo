package es.upm.dit.isst.Labo17.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.Labo17.dao.PartidoPoliticoDAO;
import es.upm.dit.isst.Labo17.dao.PartidoPoliticoDAOImplementation;
import es.upm.dit.isst.Labo17.model.PartidoPolitico;

import es.upm.dit.isst.Labo17.dao.ResultadoDAO;
import es.upm.dit.isst.Labo17.dao.ResultadoDAOImplementation;
import es.upm.dit.isst.Labo17.model.Resultado;



@WebServlet("/SimulacionServlet")
public class SimulacionServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ResultadoDAO resultDao = ResultadoDAOImplementation.getInstance();
		req.getSession().setAttribute( "Result_list", resultDao.readAll() );
		/*Resultado resultado = new Resultado();
		resultado = resultDao.read(1);
		int votos = resultado.getVotosObtenidos();
		System.out.println(">>>>>>>>>>>>HEMOS OBTENIDO LOS VOTOS<<<<<<<<<<<<" + votos);*/
		PartidoPoliticoDAO partPolDao = PartidoPoliticoDAOImplementation.getInstance();
		req.getSession().setAttribute( "Partido_list", partPolDao.readAll() );
	
		getServletContext().getRequestDispatcher( "/Simulacion.jsp" ).forward( req, resp );
	}
	
	
	
		

}