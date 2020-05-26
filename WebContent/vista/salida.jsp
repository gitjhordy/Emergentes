<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%	ArrayList<String> lista=(ArrayList<String>)session.getAttribute("usuario"); %>

<h1 Style="text-align:center" >BLOG DE LENJUAGE PHP <h1>
<h2 Style="text-align:center" Style="font-size:10px">Bienvenido usuario <%out.print(lista.get(0)); %></h2>
 
 <a href="nuevo_art.jsp">nueva entrada</a>

<% 
try
{	
	consultas obj = new consultas(); 
	Statement st=obj.getCon().createStatement();
	ResultSet resultado=st.executeQuery("select *from blog order by fecha");
	
	while(resultado.next())
	{
		
	

%>
<h5><%out.print(resultado.getString("fecha")); %></h5>
 <h3> <% out.print(resultado.getString("titulo")); %></h3>

<article>
       <p><%out.print(resultado.getString("contenido")); %> </p>
</article>
<br>
<a href="editar_art.jsp?link=<%=resultado.getInt("id")%>">Editar </a>
<a href="../eliminar?link=<%=resultado.getInt("id")%>" >Eliminar</a>
<hr></hr>
<%     }
	}

catch(Exception e)
{
	out.print("Error"+e);
}
%>
<a href="index.jsp" Style="margin:left" >Salir</a>

</body>
</html>