package clinicaveterinaria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.negocio.GestionClientes;


/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
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

		
			GestionClientes negCan = new GestionClientes();
					
			String a=request.getParameter("nombre");
			String b=request.getParameter("email");
			String c=request.getParameter("direccion");
			String d=request.getParameter("imagen");
			String e=request.getParameter("telefono");
			String f=request.getParameter("celular");
			String g=request.getParameter("notas");



	
			try {
				
	
					
				negCan.insertar(a, b, c, d, e, f,g);
								
				request.setAttribute("MENSAJE", "Cliente Registrado Correctamente.");
				
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
		
			RequestDispatcher rd = request
					.getRequestDispatcher("clientes.jsp");
			rd.forward(request, response);
		
			
				
		}
	
	
	}


