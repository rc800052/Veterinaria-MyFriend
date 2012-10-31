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
 * Servlet implementation class DoctorModificarServlet
 */
@WebServlet("/DoctorModificarServlet")
public class DoctorModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorModificarServlet() {
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
		int h=Integer.parseInt(request.getParameter("idDoctor"));
		String a=request.getParameter("nombre");
		String b=request.getParameter("apellido");
		String c=request.getParameter("email");
		String d=request.getParameter("telefono");
		String e=request.getParameter("usuario");
		String f=request.getParameter("clave");
		String g=request.getParameter("perfil");
		
		

		GestionDoctor negocio = new GestionDoctor();
		try {
			negocio.actualizar(h,a, b,c,d,e,f,g);
			response.sendRedirect(request.getContextPath()	+ "/Doctor.jsp");
		} catch (DAOExcepcion e1) {
			System.out.println(e1.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
