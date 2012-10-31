package clinicaveterinaria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.negocio.GestionProducto;


/**
 * Servlet implementation class ProductoEliminarServlet
 */
@WebServlet("/ProductoEliminarServlet")
public class ProductoEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEliminarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    for(int i=0;i<10;i++){
	    	System.out.println("olasKa");
	    }
		System.out.println("id:"+request.getParameter("tipo"));
		
		int a = Integer.parseInt(request.getParameter("id"));
		int tipo=Integer.parseInt(request.getParameter("tipo"));		
		
		GestionProducto negocio = new GestionProducto();
		try {
			
			negocio.eliminar(a);
		    for(int i=0;i<10;i++){
		    	System.out.println("REGRESO0000000000000000");
		    }
		    
		    
			response.sendRedirect(request.getContextPath() + "/ProductoBuscarServlet?cbotipo="+tipo);
		} catch (DAOExcepcion e) {
			
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
