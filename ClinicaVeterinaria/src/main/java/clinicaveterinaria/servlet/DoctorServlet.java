package clinicaveterinaria.servlet;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.negocio.GestionDoctor;




/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
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
			
			GestionDoctor negCan = new GestionDoctor();
					
			String a=request.getParameter("nombre");
			String b=request.getParameter("apellido");
			String c=request.getParameter("email");
			String d=request.getParameter("telefono");
			String e=request.getParameter("usuario");
			String f=request.getParameter("clave");
			String g=request.getParameter("perfil");		
			
			if (a==" "){
				request.setAttribute("MENSAJE", "Debe registrar las 3 tarifas.");
			}

			
			try {
			negCan.insertar(a, b, c,d, e, f, g);
								
				request.setAttribute("MENSAJE", "Doctor registrado correctamente.");
			
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
					.getRequestDispatcher("Doctor.jsp");
			rd.forward(request, response);
		
		
				
		}
		
	}


