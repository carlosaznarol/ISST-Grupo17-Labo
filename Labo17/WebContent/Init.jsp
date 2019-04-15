<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LABORATORIO ELECTORAL</title>
</head>
<body>




<body bgcolor="#F7F4D4">



 	<div style= "font-family: Chaparral Pro Light; text-align: center;border: 2px solid orange">
                    <h1><b>Seleccione el modo de simulación</b></h1>
                   
               
   </div>
		
		<br><br>


		<form action="BasicoServlet" >
			
			<button type="submit" style="width: 200px; height: 100px;  text-align: center;">Básico</button>
		</form>
		<br>
		<form action="AvanzadoServlet" >
			
			<button type="submit" style="width: 200px; height: 100px;float: center">Avanzado</button>
		</form>

</body>
</html>