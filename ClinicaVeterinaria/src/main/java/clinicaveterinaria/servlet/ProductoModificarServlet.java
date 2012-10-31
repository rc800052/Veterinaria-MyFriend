package clinicaveterinaria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clinicaveterinaria.negocio.GestionProducto;

import clinicaveterinaria.excepcion.DAOExcepcion;


/**
 * Servlet implementation class ProductoModificarServlet
 */


@WebServlet("/ProductoModificarServlet")
public class ProductoModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoModificarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		int c0 = Integer.parseInt(request.getParameter("id"));
		String  c1 = request.getParameter("nombre");
		Double  c2 = Double.parseDouble(request.getParameter("precio"));
		Integer c3 = Integer.parseInt(request.getParameter("cbotipo"));

		GestionProducto negocio = new GestionProducto();
		try {

			System.out .println(c0);
			System.out .println(c1);
			System.out .println(c2);
			System.out .println(c3);
			
			negocio.actualizar(c0, c1, c2, c3);
			response.sendRedirect(request.getContextPath()	+ "/ProductoBuscar.jsp");
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
