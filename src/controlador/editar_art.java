package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.consultas;


@WebServlet("/editar_art")
public class editar_art extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public editar_art() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		consultas obj=new consultas();
		PrintWriter salida=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
        String fecha=request.getParameter("fecha");
        String titulo=request.getParameter("titulo");
        String contenido=request.getParameter("contenido");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
		java.sql.Date xfecha = null;
		try {
			java.util.Date nfecha = formato.parse(fecha);
			xfecha = new java.sql.Date(nfecha.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(obj.editar(id, xfecha, titulo, contenido))
		{
			response.sendRedirect("vista/salida.jsp");
		}
		
		
		
	}

}
