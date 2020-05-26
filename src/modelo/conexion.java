package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class conexion 
{
    private String usuario ="root";
    private String contra="";
    private String  host="localhost";
    private String puerto="3306";
    private String bd="caceres11093455";
    private String classname="com.mysql.jdbc.Driver";
    private String url ="jdbc:mysql://"+ host +":"+ puerto +"/" +bd;
    public static boolean a=false;
    
   private Connection con;
    
    public conexion()
    {
    	try {
    		Class.forName(classname);
    		con=DriverManager.getConnection(url,usuario,contra);
    		
		} 
    	catch (ClassNotFoundException e) 
    	{
		 System.err.print("Error class"+e);
		}
    	
    	catch (SQLException e2)
    	{
			System.err.print("Errorsql"+e2);
    	}
    }
    
    public  Connection getCon()
    {
    	return con;
    }
    

 public static void main(String[] args) {
     
	 conexion obj = new conexion();
	 
	 
	 
  }
}
