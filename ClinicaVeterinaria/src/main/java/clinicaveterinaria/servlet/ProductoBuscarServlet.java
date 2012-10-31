package clinicaveterinaria.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Producto;
import clinicaveterinaria.negocio.GestionProducto;

/**
 * Servlet implementation class ProductoBuscarServlet
 */
@WebServlet("/ProductoBuscarServlet")
public class ProductoBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoBuscarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  /*
		for(int i=0;i<40;i++){
		    		System.out.println("PRODUCTO BUSCAR SERVLET");	
	    		System.out.println("bnombre:"+request.getParameter("bnombre"));
	    		System.out.println("cbotipo:"+request.getParameter("cbotipo"));
	    	
	    }
		*/
		
		String x = request.getParameter("bnombre");
		int y = Integer.parseInt(request.getParameter("cbotipo"));
		System.out.println("*****************************1");
		System.out.println(x);
		System.out.println(y);
		
		GestionProducto negocio = new GestionProducto();
		
		try {
			
			System.out.println("*********** 2");
			Collection<Producto> lista = negocio.buscarProducto(x,y);
						
			// Guardar en el ambiente de request
			request.setAttribute("RESULTADO", lista);
			RequestDispatcher rd = request.getRequestDispatcher("ProductoBuscar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}

}
