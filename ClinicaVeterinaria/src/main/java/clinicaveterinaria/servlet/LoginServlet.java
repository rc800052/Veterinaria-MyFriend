package clinicaveterinaria.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.excepcion.LoginExcepcion;
import clinicaveterinaria.modelo.Doctor;
import clinicaveterinaria.negocio.GestionDoctor;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String usuario = request.

		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		GestionDoctor negocio = new GestionDoctor();

		try {
			Doctor vo = negocio.validarUsuario(usuario, clave);

			HttpSession session = request.getSession();
			session.setAttribute("USUARIO_ACTUAL", vo);

			response.sendRedirect("PortadaServlet");
			return;
		} catch (DAOExcepcion e) {
			System.err.println("Error DAOExcepcion");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		} catch (LoginExcepcion e) {
			System.err.println("Error LoginExcepcion");
			RequestDispatcher rd = request
					.getRequestDispatcher("/error_login.jsp");
			rd.forward(request, response);
		}

	}

}
