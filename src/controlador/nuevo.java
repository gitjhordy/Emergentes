package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.consultas;

/**
 * Servlet implementation class nuevo_edit
 */
@WebServlet("/nuevo")
public class nuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nuevo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	   PrintWriter salida= response.getWriter();
	   
	   consultas obj=new consultas(); 
		String fecha=request.getParameter("fecha"); 
		String titulo=request.getParameter("titulo");
		String contenido=request.getParameter("contenido");
		String op=request.getParameter("op");
		
		
	switch (op)
	{
		case "registrar":
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
			java.sql.Date xfecha = null;
			try {
				java.util.Date nfecha = formato.parse(fecha);
				xfecha = new java.sql.Date(nfecha.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (obj.registrar(xfecha, titulo, contenido)) {
				response.sendRedirect("vista/salida.jsp");
			}

			else {
				response.sendRedirect("vista/nuevo_art.jsp");
			}

			break;
		case "eliminar":
			
			
			
			
			
		break;	
	}
		
		
			   
			
		
	
		
		
		
	   	  
	}

}
