package es.upm.dit.isst.Labo17.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.Labo17.dao.PartidoPoliticoDAO;
import es.upm.dit.isst.Labo17.dao.PartidoPoliticoDAOImplementation;
import es.upm.dit.isst.Labo17.dao.ResultadoDAO;
import es.upm.dit.isst.Labo17.dao.ResultadoDAOImplementation;
import es.upm.dit.isst.Labo17.model.Resultado;





@WebServlet("/GraficoServlet")
public class GraficoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		ResultadoDAO resultDao = ResultadoDAOImplementation.getInstance();
		
		req.getSession().setAttribute( "escanos_PP", resultDao.read(1).getEscanos());
		req.getSession().setAttribute( "escanos_PSOE", resultDao.read(2).getEscanos());
		req.getSession().setAttribute( "escanos_Vox", resultDao.read(3).getEscanos());
		req.getSession().setAttribute( "escanos_Ciudadanos", resultDao.read(4).getEscanos());
		req.getSession().setAttribute( "escanos_Podemos", resultDao.read(5).getEscanos());
		req.getSession().setAttribute( "escanos_Otros", resultDao.read(6).getEscanos());
		
		req.getSession().setAttribute( "votos_PP", resultDao.read(1).getVotosObtenidos());
		req.getSession().setAttribute( "votos_PSOE", resultDao.read(2).getVotosObtenidos());
		req.getSession().setAttribute( "votos_Vox", resultDao.read(3).getVotosObtenidos());
		req.getSession().setAttribute( "votos_Ciudadanos", resultDao.read(4).getVotosObtenidos());
		req.getSession().setAttribute( "votos_Podemos", resultDao.read(5).getVotosObtenidos());
		req.getSession().setAttribute( "votos_Otros", resultDao.read(6).getVotosObtenidos());

		
		//Resultado resultado = new Resultado();
		//resultado = resultDao.read(1);
		//int votos = resultado.getEscanos();
		//System.out.println(">>>>>>>>>>>>HEMOS OBTENIDO LOS VOTOS PP: <<<<<<<<<<<< " + votos);
		PartidoPoliticoDAO partPolDao = PartidoPoliticoDAOImplementation.getInstance();
		req.getSession().setAttribute( "Partido_list", partPolDao.readAll() );
	
		getServletContext().getRequestDispatcher( "/Graficas.jsp" ).forward( req, resp );
	}
	
	
	
		

}