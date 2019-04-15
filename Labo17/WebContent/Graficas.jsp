<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Graficas</title>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    google.charts.setOnLoadCallback(drawChart2);
    
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Element", "Votos", { role: "style" } ],
        ["PSOE", ${votos_PSOE}, "red"],
        ["PP", ${votos_PP}, "blue"],
        ["CIUDADANOS", ${votos_Ciudadanos}, "orange"],
        ["VOX",${votos_Vox},"green"],
        ["PODEMOS",${votos_Podemos},"purple"],
        ["OTROS", ${votos_Otros}, "#e5e4e2"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Número de votos",
        width: 900,
        height: 500,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
    
    function drawChart2() {
        var data = google.visualization.arrayToDataTable([
          ["Element", "Escaños" ],
          ["PSOE", ${escanos_PSOE}],
          ["PP", ${escanos_PP} ],
          ["CIUDADANOS", ${escanos_Ciudadanos}],
          ["VOX",${escanos_Vox}],
          ["PODEMOS",${escanos_Podemos}],
          ["OTROS", ${escanos_Otros}]
        ]);

        

        var options = {
        		title: "Reparto de escaños",
        		 slices: {
        	            0: { color: 'red' },
        	            1: { color: 'blue' },
        	            2: { color: 'orange'},
        	            3: { color: 'green' },
        	            4: { color: 'purple' },
        	            5: { color: '#e5e4e2'}
        	          },
        	    pieSliceTextStyle : {color: 'black'},
                pieHole: 0.4,
              };
        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
    }
    
    
    
  </script>




</head>
<body >

	    <div style= "font-family: Chaparral Pro Light; text-align: center;border: 2px solid orange">
                    <h1><b>Graficas de los resultados</b></h1>
                   
               
  	 </div>

	<div id= "columnchart_values" style="width:900px; heigh: 500 px"></div>
    <div id="donutchart" style="width: 900px; height: 500px;"></div>

	<form action="BasicoServlet">
			
			<button type="submit"style="width: 200px; height: 30px">Volver a simular </button>
	</form>
	
	<form action= "InicioServlet">
			<button type="submit">Inicio</button>
	</form>

	
	<div id="columnchart_values" style="width: 400px; height: 200px;" ></div>
	<br><br>
	<div id="donutchart" style="width: 420px; height: 200px;float: right;" ></div>
	
	






</body>
</html>