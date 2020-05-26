<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<Style>




table .contenido
{
  
  position:relative;
  width: 98%;
 
   height: 150px;
   
}

</Style>

</head>
<body>

<% String veri="registrar"; %>

<h1 Style="text-align:center">Nuevo/Editar</h1>



<form  action="../nuevo" method="post" >
<table>
<tr>
<td>Fecha :</td>
<td><input type="date" name="fecha" value="dia/mes/año" ></td>
</tr>

<tr>
<td>Titulo :</td>
<td><input type="text" name="titulo"  ></td>
</tr>

<tr>
<td>Contenido :</td>
<td><input type="text" name="contenido" class="contenido"  ></td>
</tr>

<tr>
<td><input type="hidden" name="op" value="<%=veri %>"  ></td>
<td><input type="submit" value="Registrar" ></td>
</tr>     
</table>

</form>



</body>
</html>