package clinicaveterinaria.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Paciente;
import clinicaveterinaria.negocio.GestionPacientes;

/**
 * Servlet implementation class PacienteMostrarServlet
 */

@WebServlet("/PacienteMostrarServlet")
public class PacienteMostrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteMostrarServlet() {
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
		// Recuperar
		String Nombre = request.getParameter("bnombre");
		
		GestionPacientes negocio = new GestionPacientes();

		try {			
			Collection<Paciente> listado = negocio.buscarPorNombre(Nombre);

			//Assert.assertTrue(listado.size() > 0);

			// Enviar objetos al JSP
			request.setAttribute("RESULTADO",listado);
			
			// Invocar al JSP
			RequestDispatcher rd = request.getRequestDispatcher("Paciente.jsp");
			rd.forward(request,response);

		} catch (DAOExcepcion e) {

			System.out.println("Fallo el listado: " + e.getMessage());

		}
	}

}
