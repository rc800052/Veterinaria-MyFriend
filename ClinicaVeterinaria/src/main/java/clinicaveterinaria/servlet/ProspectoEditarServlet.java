package clinicaveterinaria.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Prospecto;
import clinicaveterinaria.negocio.GestionProspectos;

/**
 * Servlet implementation class ProspectoEditarServlet
 */
@WebServlet("/ProspectoEditarServlet")
public class ProspectoEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProspectoEditarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Integer a=Integer.parseInt(request.getParameter("cboLocal"));
		
		Integer a = Integer.parseInt(request.getParameter("idProspecto"));
		GestionProspectos negocio = new GestionProspectos();
		try {
			Prospecto vo = negocio.obtener(a);
			request.setAttribute("vo", vo);
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("ProspectoModificar.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
