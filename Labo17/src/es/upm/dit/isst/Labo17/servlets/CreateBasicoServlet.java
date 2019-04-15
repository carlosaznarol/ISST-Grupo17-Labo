package es.upm.dit.isst.Labo17.servlets;

import java.io.IOException;
import java.util.*;

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
import es.upm.dit.isst.Labo17.dao.PartidoPoliticoDAO;
import es.upm.dit.isst.Labo17.dao.PartidoPoliticoDAOImplementation;
import es.upm.dit.isst.Labo17.dao.ResultadoDAO;
import es.upm.dit.isst.Labo17.dao.ResultadoDAOImplementation;
import es.upm.dit.isst.Labo17.model.Comunidad;
import es.upm.dit.isst.Labo17.model.PartidoPolitico;
import es.upm.dit.isst.Labo17.model.Resultado;




@SuppressWarnings("serial")
@WebServlet("/CreateBasicoServlet")

public class CreateBasicoServlet extends HttpServlet {




	public int[] mayor(int [][] votos,int escanosPs,int escanosPp,int escanosPd,int escanosCs,int escanosVx,int escanosOt, int escanosARepartirOk) {
		int [][] votosSintocar=new int[escanosARepartirOk][6];
		int [][] votosigual=new int[escanosARepartirOk][6];



		for(int j=0;j<6;j++) {

			for(int i=0;i<escanosARepartirOk;i++) {
				votosSintocar[i][j]=votos[i][j];
				votosigual[i][j]=votos[i][j];


			}

		}

		for(int k=0;k<escanosARepartirOk;k++) {


			int numeromayor;
			int posicionFila = 0;
			int posicionColumna=0;
			int iguales=0;



			numeromayor = votos[0][0];



			for(int i=0; i<escanosARepartirOk; i++){
				for(int j=0;j<6;j++) {
					if(votos[i][j]>numeromayor && votos[i][j]!=-1){  
						numeromayor = votos[i][j];
						posicionFila=i;
						posicionColumna=j;

					}
				}
			}


			votosigual[posicionFila][posicionColumna]=-2;
			int columnaIgual = 0;
			int filaIgual = 0;

			for(int i=0; i<escanosARepartirOk; i++){
				for(int j=0;j<6;j++) {
					if(votosigual[i][j]==votos[posicionFila][posicionColumna] && votosigual[i][j]!=-2) {
						iguales=1;
						columnaIgual=j;
						filaIgual=i;
					}
				}
			}

			if(iguales==0) {
				if(posicionColumna==0 &&  votos[posicionFila][posicionColumna]!=-1 ) {
					escanosPs++;
					votos[posicionFila][posicionColumna]=-1;
				}else if(posicionColumna==1 && votos[posicionFila][posicionColumna]!=-1 ) {
					escanosPp++;
					votos[posicionFila][posicionColumna]=-1;
				}else if(posicionColumna==2 &&  votos[posicionFila][posicionColumna]!=-1 ) {
					escanosCs++;
					votos[posicionFila][posicionColumna]=-1;
				}else if(posicionColumna==3  && votos[posicionFila][posicionColumna]!=-1 ) {
					escanosPd++;
					votos[posicionFila][posicionColumna]=-1;
				}else if(posicionColumna==4   && votos[posicionFila][posicionColumna]!=-1 ) {
					escanosVx++;
					votos[posicionFila][posicionColumna]=-1;
				}else if(posicionColumna==5  && votos[posicionFila][posicionColumna]!=-1 ) {
					escanosOt++;
					votos[posicionFila][posicionColumna]=-1;
				}
			}




			if(iguales==1) {
				System.out.println("VotosIgual");


				if(votosSintocar[0][columnaIgual]>votosSintocar[0][posicionColumna]) {

					if(columnaIgual==0) {

						escanosPs++;
						votos[filaIgual][columnaIgual]=-1;
					}else if(columnaIgual==1) {
						escanosPp++;
						votos[filaIgual][columnaIgual]=-1;
					}else if(columnaIgual==2) {
						escanosCs++;
						votos[filaIgual][columnaIgual]=-1;
					}else if(columnaIgual==3) {
						escanosPd++;
						votos[filaIgual][columnaIgual]=-1;
					}else if(columnaIgual==4) {
						escanosVx++;

						votos[filaIgual][columnaIgual]=-1;
					}else if(columnaIgual==5) {
						escanosOt++;
						votos[filaIgual][columnaIgual]=-1;
					}
				}else {
					if(votosSintocar[0][columnaIgual]<votosSintocar[0][posicionColumna]) {
						if(posicionColumna==0) {
							escanosPs++;
							votos[posicionFila][posicionColumna]=-1;

						}else if(posicionColumna==1) {
							escanosPp++;
							votos[posicionFila][posicionColumna]=-1;
						}else if(posicionColumna==2) {
							escanosCs++;
							votos[posicionFila][posicionColumna]=-1;
						}else if(posicionColumna==3) {
							escanosPd++;
							votos[posicionFila][posicionColumna]=-1;
						}else if(posicionColumna==4) {
							escanosVx++;
							votos[posicionFila][posicionColumna]=-1;
						}else if(posicionColumna==5) {
							escanosOt++;
							votos[posicionFila][posicionColumna]=-1;
						}
					}
				}
			}
			for(int j=0;j<6;j++) {
			for(int i=0;i<escanosARepartirOk;i++) {
			
					System.out.print(" "+votos[i][j]);
				}
				System.out.println();
			}
			System.out.println();



		}


		int [] escanos= {escanosPs,escanosPp,escanosCs,escanosPd,escanosVx,escanosOt};
		return  escanos;
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//try {

		//-----OBTENEMOS LOS VOTOS INTRODUCIDOS POR EL USUARIO
		String tipoLey = req.getParameter( "tipoLey" );
		String comunidad = req.getParameter("comunidad");

		//ArrayList<String> comunidades= req.getParameter("comunidad");
		//ArrayList<String> provincias = req.getParameter("provincia");

		String tipoElecciones = req.getParameter( "tipoElecciones" );
		String votosPSOE = req.getParameter( "votosPSOE" );
		String votosPP = req.getParameter( "votosPP" );
		String votosCiudadanos = req.getParameter( "votosCiudadanos" );
		String votosVox = req.getParameter( "votosVox" );
		String votosPodemos = req.getParameter( "votosPodemos" );
		String votosOtros = req.getParameter( "votosOtros" );
		String escanosARepartir=req.getParameter("escanosARepartir");

		//------CONVERTIMOS LOS VOTOS EN ENTEROS
		int escanosARepartirOk= Integer.parseInt(escanosARepartir);
		int votosPPOk = Integer.parseInt(votosPP);
		int votosPSOEOk = Integer.parseInt(votosPSOE);
		int votosCiudadanosOk = Integer.parseInt(votosCiudadanos);
		int votosVoxOk = Integer.parseInt(votosVox);
		int votosPodemosOk = Integer.parseInt(votosPodemos);
		int votosOtrosOk = Integer.parseInt(votosOtros);

		int escanosPp=0, escanosPs=0, escanosCs=0,escanosPd=0,escanosVx=0,escanosOt=0;

		int[] votosMaxPsoe=new int[escanosARepartirOk];
		int[] votosMaxPP=new int[escanosARepartirOk];
		int[] votosMaxVox=new int[escanosARepartirOk];
		int[] votosMaxCiudadanos=new int[escanosARepartirOk];
		int[] votosMaxPodemos=new int[escanosARepartirOk];
		int [] votosMaxOtros=new int[escanosARepartirOk];


		//D`hont


		for(int i=0;i<escanosARepartirOk;i++) {

			votosMaxPsoe[i]=(int) (votosPSOEOk/(i+1));
			votosMaxPP[i]=(int)((int)(votosPPOk)/(i+1));
			votosMaxVox[i]=(int)((votosVoxOk)/(i+1));
			votosMaxPodemos[i]=(int)((votosPodemosOk)/(i+1));
			votosMaxCiudadanos[i]=(int) (votosCiudadanosOk/(i+1));
			votosMaxOtros[i]=(int) (votosOtrosOk/(i+1));
		}

		int[][] votos=new int [escanosARepartirOk][6];

		for(int i=0;i<escanosARepartirOk;i++) {
			votos[i][0]=votosMaxPsoe[i];
		}
		for(int i=0;i<escanosARepartirOk;i++) {
			votos[i][1]=votosMaxPP[i];
		}
		for(int i=0;i<escanosARepartirOk;i++) {
			votos[i][2]=votosMaxCiudadanos[i];
		}
		for(int i=0;i<escanosARepartirOk;i++) {
			votos[i][3]=votosMaxPodemos[i];
		}
		for(int i=0;i<escanosARepartirOk;i++) {
			votos[i][4]=votosMaxVox[i];
		}
		for(int i=0;i<escanosARepartirOk;i++) {
			votos[i][5]=votosMaxOtros[i];
		}




		int [] escanos=mayor(votos,escanosPs, escanosPp, escanosPd, escanosCs, escanosVx, escanosOt,escanosARepartirOk);





		System.out.println("PSOE: "+escanos[0]);
		System.out.println("PP: "+escanos[1]);
		System.out.println("Cs: "+escanos[2]);
		System.out.println("Podemos: "+escanos[3]);
		System.out.println("Vox: "+escanos[4]);
		System.out.println("Otros: "+escanos[5]);

		//--------SACAMOS EL NUMERO DE ESCANOS DE LA COMUNIDAD SELECCIONADA
		/*ComunidadDAO tdao = ComunidadDAOImplementation.getInstance();
		Comunidad comunidadBBDD = new Comunidad();
		comunidadBBDD = tdao.read(comunidad);
		System.out.println(">>>>>>>>>>>>>>SACAMOS LOS ESCA�OS DE " +comunidadBBDD.getNombre() + ": " + comunidadBBDD.getEscanos());
		System.out.println(">>>>>>>>>>>>>>>>> MUESTRA VOTOS VOX: " + votosVox);
		System.out.println(">>>>>>>>>>>>>>>>> MUESTRA COMUNIDADES: " + comunidad);*/


		//-----------PP-------------
		PartidoPolitico partPolPP = new PartidoPolitico();
		partPolPP.setNombre("Partido Popular");
		partPolPP.setAcronimo("PP");

		Resultado resultPP = new Resultado();
		resultPP.setId(1);
		resultPP.setEscanos(escanos[1]);
		resultPP.setVotosObtenidos(votosPPOk);
		resultPP.setPartido(partPolPP);

		PartidoPoliticoDAO partPolPPDao = PartidoPoliticoDAOImplementation.getInstance();
		partPolPPDao.update(partPolPP);
		ResultadoDAO resultadoPPDao = ResultadoDAOImplementation.getInstance();
		resultadoPPDao.update(resultPP);


		//-----------PSOE-------------
		PartidoPolitico partPolPSOE = new PartidoPolitico();
		partPolPSOE.setNombre("Partido Socialista Obrero Espanol");
		partPolPSOE.setAcronimo("PSOE");

		Resultado resultPSOE = new Resultado();
		resultPSOE.setId(2);
		resultPSOE.setEscanos(escanos[0]);
		resultPSOE.setVotosObtenidos(votosPSOEOk);
		resultPSOE.setPartido(partPolPSOE);

		PartidoPoliticoDAO partPolPSOEDao = PartidoPoliticoDAOImplementation.getInstance();
		partPolPSOEDao.update(partPolPSOE);
		ResultadoDAO resultadoPSOEDao = ResultadoDAOImplementation.getInstance();
		resultadoPSOEDao.update(resultPSOE);


		//----------VOX-------------
		PartidoPolitico partPolVox = new PartidoPolitico();
		partPolVox.setNombre("Vox");
		partPolVox.setAcronimo("Vox");

		Resultado resultVox = new Resultado();
		resultVox.setId(3);
		resultVox.setEscanos(escanos[4]);
		resultVox.setVotosObtenidos(votosVoxOk);
		resultVox.setPartido(partPolVox);

		PartidoPoliticoDAO partPolVoxDao = PartidoPoliticoDAOImplementation.getInstance();
		partPolVoxDao.update(partPolVox);
		ResultadoDAO resultadoVoxDao = ResultadoDAOImplementation.getInstance();
		resultadoVoxDao.update(resultVox);

		//---------CIUDADANOS----------
		PartidoPolitico partPolCiudadanos = new PartidoPolitico();
		partPolCiudadanos.setNombre("Ciudadanos");
		partPolCiudadanos.setAcronimo("CS");

		Resultado resultCiudadanos = new Resultado();
		resultCiudadanos.setId(4);
		resultCiudadanos.setEscanos(escanos[2]);
		resultCiudadanos.setVotosObtenidos(votosCiudadanosOk);
		resultCiudadanos.setPartido(partPolCiudadanos);

		PartidoPoliticoDAO partPolCiudadanosDao = PartidoPoliticoDAOImplementation.getInstance();
		partPolCiudadanosDao.update(partPolCiudadanos);
		ResultadoDAO resultadoCiudadanosDao = ResultadoDAOImplementation.getInstance();
		resultadoCiudadanosDao.update(resultCiudadanos);


		//-----------PODEMOS----------
		PartidoPolitico partPolPodemos = new PartidoPolitico();
		partPolPodemos.setNombre("Podemos");
		partPolPodemos.setAcronimo("Podemos");

		Resultado resultPodemos = new Resultado();
		resultPodemos.setId(5);
		//resultPodemos.setEscanos(10);
		//resultPodemos.setEscanos(escanosPd);
		resultPodemos.setEscanos(escanos[3]);
		resultPodemos.setVotosObtenidos(votosPodemosOk);
		resultPodemos.setPartido(partPolPodemos);

		PartidoPoliticoDAO partPolPodemosDao = PartidoPoliticoDAOImplementation.getInstance();
		partPolPodemosDao.update(partPolPodemos);
		ResultadoDAO resultadoPodemosDao = ResultadoDAOImplementation.getInstance();
		resultadoPodemosDao.update(resultPodemos);


		//---------OTROS-------
		PartidoPolitico partPolOtros = new PartidoPolitico();
		partPolOtros.setNombre("Otros");
		partPolOtros.setAcronimo("Otros");

		Resultado resultOtros = new Resultado();
		resultOtros.setId(6);
		resultOtros.setEscanos(escanos[5]);
		resultOtros.setVotosObtenidos(votosOtrosOk);
		resultOtros.setPartido(partPolOtros);

		PartidoPoliticoDAO partPolOtrosDao = PartidoPoliticoDAOImplementation.getInstance();
		partPolOtrosDao.update(partPolOtros);
		ResultadoDAO resultadoOtrosDao = ResultadoDAOImplementation.getInstance();
		resultadoOtrosDao.update(resultOtros);


		//	}catch(Exception e) {
		//System.out.println("------------------------RELLENA--------------------");
		//	}

		resp.sendRedirect( req.getContextPath() + "/SimulacionServlet" );


	}	

}
