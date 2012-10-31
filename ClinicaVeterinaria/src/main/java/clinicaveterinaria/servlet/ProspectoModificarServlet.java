package clinicaveterinaria.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.negocio.GestionProspectos;

/**
 * Servlet implementation class ProspectoModificarServlet
 */
@WebServlet("/ProspectoModificarServlet")
public class ProspectoModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProspectoModificarServlet() {
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
		
		
		int h=Integer.parseInt(request.getParameter("idProspecto"));
		String a=request.getParameter("nombre");
		String b=request.getParameter("email");
		String c=request.getParameter("direccion");
		String d=request.getParameter("imagen");
		String e=request.getParameter("telefono");
		String f=request.getParameter("celular");
		String g=request.getParameter("cliente");
		
		

		GestionProspectos negocio = new GestionProspectos();
		try {

			
			negocio.actualizar(h,a, b,c,d,e,f,g);
			response.sendRedirect(request.getContextPath()	+ "/Prospecto.jsp");
		} catch (DAOExcepcion e1) {
			System.out.println(e1.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
