<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MODO BÁSICO</title>
</head>
<body bgcolor="#F7F4D4">



    <div style= "font-family: Chaparral Pro Light; text-align: center;border: 2px solid orange">
                    <h1><b>Simulación básica</b></h1>
                   
               
   </div>

    <div class="container" style= "font-family: Arial; ">
        <div class="row">
            <div class="col-md-6">
            
        <form method="get" action= "ComunidadesServlet" >
			<button type="submit">Distribución de escaños</button>
		</form>
                
		<form action="CreateBasicoServlet" method = "post" >
                    <p><label for="tipoLey">Seleccionar tipo de ley:
                        <select name="tipoLey" id="tipoLey">
                            <option value="Hont">D'Hont</option>
                            <option value="Lague">Saint-Laguë</option>
                        </select>
                    </label></p>

                    <p><label for="tipoElecciones">Seleccionar tipo de elecciones:
                        <select name="tipoElecciones" id="tipoElecciones">
                            <option value="Generales">Autonomicas</option>                                                       
                        </select>
                    </label></p>
                    
                    
                    <p>
						Seleccione Comunidad Autonóma: <select name = "comunidad" id ="comunidad">
						<option value="" disabled selected>Seleccione una Comunidad</option> 
						 <c:forEach items="${Comunidad_list}" var="comunidadi">
    					<option value="${ comunidadi.nombre}">
      					${comunidadi.nombre}
   						 </option>
 						 </c:forEach> 
   						  
						 </select>
			
					</p>                    
                    
					<%--
					    <p><label for="comunidad">Seleccione provincia:
                        <select name="provincia" id="provincia">
                        <option value="" disabled selected>Seleccione una provincia</option>
                        <c:forEach items="${Provincia_list}" var="provinciadi">
    					<option value="${ provincicadi.nombre}">
      					${provinciadi.nombre}
   						 </option>
 						 </c:forEach> 
						
                        </select>
                    </label></p>
					
					 --%>
    
                    <p><label>Escanos a repartir:
                        <input name="escanosARepartir" type="number" placeholder="Introduzca los escanos" value="" />
                    </label></p>

                    <p><label>Votos PSOE:
                        <input name="votosPSOE" type="number" placeholder="Introduzca los votos" value="" />
                    </label></p>

                    <p><label>Votos PP:
                        <input name="votosPP" type="number" placeholder="Introduzca los votos" value="" />
                    </label></p>

                    <p><label>Votos Ciudadanos:
                        <input name="votosCiudadanos" type="number" placeholder="Introduzca los votos" value="" />
                    </label></p>

                    <p><label>Votos Vox:
                        <input name="votosVox" type="number" placeholder="Introduzca los votos" value="" />
                    </label></p>

                    <p><label>Votos Podemos:
                        <input name="votosPodemos" type="number" placeholder="Introduzca los votos" value="" />
                    </label></p>
                    
                    <p><label>Otros:
                        <input name="votosOtros" type="number" placeholder="Introduzca los votos" value="" />
                    </label></p>
                    

				<p>
				<button type="submit">Simular Resultado</button>
				</p>
				</form>
				<form action= "InicioServlet">
				<button type="submit">Inicio</button>
				</form>
                
            </div>

        </div>
    </div>





</body>
</html>