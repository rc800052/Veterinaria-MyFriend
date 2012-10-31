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
import clinicaveterinaria.modelo.Prospecto;
import clinicaveterinaria.negocio.GestionProspectos;

/**
 * Servlet implementation class ProspectoMostrarServlet
 */
@WebServlet("/ProspectoMostrarServlet")
public class ProspectoMostrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProspectoMostrarServlet() {
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
		String Nombre = request.getParameter("bnombre");
		
		GestionProspectos negocio = new GestionProspectos();

		try {			
			Collection<Prospecto> listado = negocio.buscarPorNombre(Nombre);

			//Assert.assertTrue(listado.size() > 0);

			// Enviar objetos al JSP
			request.setAttribute("RESULTADO",listado);
			
			// Invocar al JSP
			RequestDispatcher rd = request.getRequestDispatcher("Prospecto.jsp");
			rd.forward(request,response);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}
	}

}
