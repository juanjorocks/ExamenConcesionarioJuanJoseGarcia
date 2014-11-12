<%@page import="es.concesionario.modelo.Vehiculo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VISTA INDIVIDUAL</title>
</head>
<body>
<form action="Procesar" method="get">
<% Vehiculo vehiculo = (Vehiculo)request.getAttribute("vehiculo"); %>
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
   <tr>
   <td><input type="text" name="id" value="<%=vehiculo.getId() %>" readonly="readonly"/></td>
      <td><input type="text" name="matricula" value="<%=vehiculo.getMatricula() %>"/></td>
      <td><input type="text" name="marca" value="<%=vehiculo.getMarca() %>"/></td>
      <td><input type="text" name="modelo" value="<%=vehiculo.getModelo() %>"/></td>
      <td><input type="text" name="color" value="<%=vehiculo.getColor() %>"/></td>
      <td><input type="text" name="caballos" value="<%=vehiculo.getCaballos() %>"/></td>
      <td><input type="text" name="cambio" value="<%=vehiculo.isCambio() %>"/></td>        
  </tr>
</table>
 <input class="botones" type="submit" value="Borrar" id="borrar" name="borrar"/>
 <input class="botones" type="submit" value="Modificar" id="modificar" name="modificar"/> 
</form>
<p><a href="index.html"  >Ir a Inicio</a></p>
</body>
</html>