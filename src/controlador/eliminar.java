package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.consultas;


@WebServlet("/eliminar")
public class eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public eliminar() 
    {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		consultas obj1= new consultas();
		int id=Integer.parseInt(request .getParameter("link"));
		
		if(obj1.eliminar(id))
		{
			response.sendRedirect("vista/salida.jsp");
		}
		
	}
}
