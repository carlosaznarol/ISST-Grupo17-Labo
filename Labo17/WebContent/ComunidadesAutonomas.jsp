<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	
		<h3>Crear Comunidad nueva</h3>
		<form action="CreateComunidadServlet" method="post">
			<p>
				Nombre: <input type="text" name="nombre" />
			</p>
			<p>
				Escaños: <input type="number" name="escanos" />
			</p>
			<p>
				Censo: <input type="number" name="censo" />
			</p>
			<p>
				<button type="submit">Crear Comunidad</button>
			</p>
		</form>
		
		
		<h3>Listado de Comunidades</h3>
		<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Escaños</th>
				<th>Censo</th>
			</tr>
			<c:forEach items="${Comunidad_list}" var="comu">
				<tr>
					<td>${comu.nombre }</td>
					<td>${comu.escanos} </td>
					<td>${comu.censo }</td>
				</tr>
			</c:forEach>
		</table>


	<form action="BasicoServlet">
			
			<button type="submit">Volver a simular </button>
	</form>
	
	<form action= "InicioServlet">
			<button type="submit">Inicio</button>
	</form>



</body>
</html>