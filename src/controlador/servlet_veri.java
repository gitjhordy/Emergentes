package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.consultas;

/**
 * Servlet implementation class inicio
 */
@WebServlet("/servlet_veri")
public class servlet_veri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servlet_veri() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession seesion=request.getSession();
		ArrayList<String> lista=new ArrayList<String>();
		PrintWriter salida=response.getWriter();
		
		
		
		String u = request.getParameter("usuario");	
		String c =  request.getParameter("pass");
		
		
        consultas obj =new consultas();
        
        
		
       
        
        
	if (obj.auetentintificacion(u,c))
	{
		lista.add(u);
		lista.add(c);
		seesion.setAttribute("usuario",lista);
		
		response.sendRedirect("vista/salida.jsp");
	}
	else
	{
		response.sendRedirect("vista/index.jsp");
	}
		
			
		

	}

}
