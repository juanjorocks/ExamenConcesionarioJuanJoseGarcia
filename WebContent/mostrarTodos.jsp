<%@page import="java.util.ArrayList"%>
<%@page import="es.concesionario.modelo.Vehiculo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MOSTRAR TODOS LOS VEHICULOS</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
</head>
<body>
<% ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo> )request.getAttribute("listado"); %>
<table>
    <tr>
      <th>Id</th>
      <th>Matricula</th>
      <th>Marca</th>
      <th>Modelo</th> 
      <th>Color</th>
      <th>Caballos</th>
      <th>Cambio</th>
    </tr>
  <% for(Vehiculo vehiculo: vehiculos){ %>  
   <tr>
      <td><%=vehiculo.getId() %></td>
      <td><%=vehiculo.getMatricula() %></td>
      <td><%=vehiculo.getMarca() %></td>
      <td><%=vehiculo.getModelo() %></td>
      <td><%=vehiculo.getColor() %></td>
      <td><%=vehiculo.getCaballos() %></td>
      <td><%=vehiculo.isCambio() %></td>
    </tr>
  <%}// del for %>
</table>
<p><a href="index.html"  >Ir a Inicio</a></p>
</body>
</html>