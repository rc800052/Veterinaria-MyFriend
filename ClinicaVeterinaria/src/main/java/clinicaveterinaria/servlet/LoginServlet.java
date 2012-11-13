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
import clinicaveterinaria.ws.login.Service1Stub;
import clinicaveterinaria.ws.login.Service1Stub.ValidarUsuario;
import clinicaveterinaria.ws.login.Service1Stub.ValidarUsuarioResponse;

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
		
		try {
			String usuario = request.getParameter("usuario");
			String clave = request.getParameter("clave");
			
			Service1Stub stub = new Service1Stub();
			
			ValidarUsuario requestWS = new ValidarUsuario();
			requestWS.setUsuario(usuario);
			requestWS.setPassword(clave);
			
			ValidarUsuarioResponse responseWS = stub.validarUsuario(requestWS);
			Doctor doctorWS = null;
			String strL_mensaje = "";
			
			if(responseWS.getValidarUsuarioResult().getExito()){
				doctorWS = new Doctor();
				doctorWS.setUsuario(responseWS.getValidarUsuarioResult().getUsuario());
				doctorWS.setClave(responseWS.getValidarUsuarioResult().getClave());
				doctorWS.setIdDoctor(responseWS.getValidarUsuarioResult().getID());
				doctorWS.setApellido(responseWS.getValidarUsuarioResult().getApellido());
				doctorWS.setNombre(responseWS.getValidarUsuarioResult().getNombre());			
				doctorWS.setPerfil(responseWS.getValidarUsuarioResult().getPerfil());
				doctorWS.setTelefono(responseWS.getValidarUsuarioResult().getTelefono());
				doctorWS.setEmail(responseWS.getValidarUsuarioResult().getEmail());				
				
				strL_mensaje = responseWS.getValidarUsuarioResult().getMensaje();
				
				HttpSession session = request.getSession();
				session.setAttribute("USUARIO_ACTUAL", doctorWS);
				session.setAttribute("MSJ_EXITO_LOGIN", strL_mensaje);
				
				response.sendRedirect("PortadaServlet");
				return;
			} else {
				strL_mensaje = responseWS.getValidarUsuarioResult().getMensaje();
				request.setAttribute("MSJ_ERROR_LOGIN", strL_mensaje); 
				
				RequestDispatcher rd = request.getRequestDispatcher("/error_login.jsp");
				rd.forward(request, response);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		} 
		
//		try {
//			GestionDoctor negocio = new GestionDoctor();
//			Doctor vo = negocio.validarUsuario(usuario, clave);
//
//			HttpSession session = request.getSession();
//			session.setAttribute("USUARIO_ACTUAL", vo);
//
//			response.sendRedirect("PortadaServlet");
//			return;
//		} catch (DAOExcepcion e) {
//			System.err.println("Error DAOExcepcion");
//			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
//			rd.forward(request, response);
//		} catch (LoginExcepcion e) {
//			System.err.println("Error LoginExcepcion");
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/error_login.jsp");
//			rd.forward(request, response);
//		}

	}

}
