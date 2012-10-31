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
 * Servlet implementation class RegistrarProductoServlet
 */
@WebServlet("/RegistrarProductoServlet")
public class RegistrarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarProductoServlet() {
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
		try{
		GestionProducto negprod = new GestionProducto();
		
		String a=request.getParameter("nombre");
		Double b=Double.parseDouble(request.getParameter("precio"));
		Integer c=Integer.parseInt(request.getParameter("cbotipo"));
		
		
		try {
				
				if (a.isEmpty()){
					request.setAttribute("MENSAJE", "Debe registrar la descripción.");
				}
				
				if (a.trim()==""){
					request.setAttribute("MENSAJE", "Debe registrar la descripción.");
				}
				
				if (b==0){
					request.setAttribute("MENSAJE", "Debe registrar el precio.");
				}
				
				if (c==0){
					request.setAttribute("MENSAJE", "Debe seleccionar un tipo de producto.");
				}
				
				
				negprod.insertar(a, b, c);
								
				request.setAttribute("MENSAJE", "Producto registrado correctamente.");
				
				
			} catch (DAOExcepcion e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				request.setAttribute("MENSAJE", e1.getMessage());
			}
		} catch (IllegalArgumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			request.setAttribute("MENSAJE", "ERROR, Falta llenar campos o tipo de variable no soportada: -" + e2.getMessage() + "-");
	}
		//RequestDispatcher rd = request.getRequestDispatcher("Producto.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("ProductoNew.jsp");
		rd.forward(request, response);
	
	
			
	}
		
		
	}
