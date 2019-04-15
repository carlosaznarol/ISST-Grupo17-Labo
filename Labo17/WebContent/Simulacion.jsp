<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simulacion</title>
</head>
<body bgcolor="#F7F4D4">

<div style= "font-family: Chaparral Pro Light; text-align: center;border: 2px solid orange">
                    <h1><b>Resultado de la simulación</b></h1>
                   
               
   </div >
   <br>

<form action="CreateSimulacionServlet" method="post">

<table border="1">
			<tr>
				<th>Partido</th>
				<th>Acronimo Partido</th>
				<th>Votos obtenidos</th>
				<th>Escaños</th>
			</tr>
			<c:forEach items="${Result_list}" var="res">
				<tr>
					<td>${res.partido.nombre}</td>
					<td>${res.partido.acronimo}
					<td>${res.votosObtenidos} </td>
					<td>${res.escanos} </td>
				</tr>
			</c:forEach>
		</table>


</form>
 	<br>
 	<br>
 	<form action="GraficoServlet">
			<button type="submit">Generar Graficas </button>
	</form>
 	<form action="BasicoServlet">
			<button type="submit">Volver a simular </button>
	</form>
 	<form action="InicioServlet">
 		<button type="submit">Inicio</button>
 	</form>

</body>
</html>