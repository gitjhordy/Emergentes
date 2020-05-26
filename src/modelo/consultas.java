package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.*;
import java.sql.Date;


public class consultas extends conexion {
	
 public boolean auetentintificacion(String usua,String contr)
 {
	 PreparedStatement st=null;
	 ResultSet rs=null;
	 
	 try {
		 
		 String consulta="select * from usuario where usuario = ? and password= ?";
		 st=getCon().prepareStatement(consulta);
		 st.setString(1,usua);
		 st.setString(2,contr);
		 rs=st.executeQuery();
		
		 if(rs.absolute(1))
		 {
			 return true;
		 }
		
	} catch (Exception e)
	
	{
		System.out.println("error1"+e);
	}
	 finally
	 {
		 try 
		{
			if(getCon()!=null) getCon().close();
			if(st !=null) st.close();
			if(rs !=null) rs.close();
			
		} catch (Exception e2) 
		
		{
			System.out.println("error2"+e2);
		}
	
	 }
	 
	 return false;
	 
 }
	
	
public boolean registrar(java.sql.Date fecha , String titulo,String contenido )
{
	PreparedStatement st= null;
	
	try {
		
		String sql=" insert into blog  (fecha,titulo,contenido)  values (?,?,?)";
		
		st=getCon().prepareStatement(sql);
		st.setDate(1, fecha);
		st.setString(2, titulo);
		st.setString(3,contenido);
		
		   if(st.executeUpdate()==1)
				{
			         return true;
				}
		
		
	} catch (Exception e)
	{
 System.out.println("error registro"+e);
           
	}
	
	
	return false;
}


public boolean eliminar(int campo)
{
	Statement st= null;
	String sql=" delete from blog where id="+campo;
	
	try {
		st =getCon().createStatement();
		
		if(st.executeUpdate(sql)==1)
		{
	         return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.err.println("Error"+e);
	}
	 
	
	
	return false;
}

public boolean editar(int id, java.sql.Date fecha, String titulo,String contenido)
{
	
	PreparedStatement st=null;
	
	 
	 try {
		 
		 String consulta="update blog set   fecha=?,titulo=? ,contenido=?  where id=?";
		 st=getCon().prepareStatement(consulta);
		 st.setDate(1,fecha);
		 st.setString(2,titulo);
		 st.setString(3,contenido);
		 st.setInt(4,id);
		 
		 st.executeUpdate();
		
		  return true;
		
	} catch (Exception e)
	
	{
		System.out.println("error1"+e);
	}
	
	return false;
}

	
public static void main(String[] args) 
{
	consultas obj= new consultas();
	String fecha="11/11/20";
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
	java.sql.Date xfecha = null;
	try {
		java.util.Date nfecha = formato.parse(fecha);
		xfecha = new java.sql.Date(nfecha.getTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.print(obj.editar(16, xfecha,"madona", "sexi"));
	
}



}
