package clinicaveterinaria.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.negocio.GestionClientes;
import clinicaveterinaria.negocio.GestionPacientes;



/**
 * Servlet implementation class PacienteModificarServlet
 */
@WebServlet("/PacienteModificarServlet")
public class PacienteModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteModificarServlet() {
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
		int m=Integer.parseInt(request.getParameter("idPaciente"));
		String a=request.getParameter("nombre");
		String b=request.getParameter("esterilizado");
		String c=request.getParameter("tamano");
		String d=request.getParameter("actividad");
		double  e=Double.parseDouble(request.getParameter("peso"));
		String f=request.getParameter("fchnac");
		String g=request.getParameter("especie");
		String h=request.getParameter("raza");
		String i=request.getParameter("genero");
		String j=request.getParameter("tiposangre");	
		int k=Integer.parseInt(request.getParameter("idCliente"));
		
		
		
		
		

		GestionPacientes negocio = new GestionPacientes();
		GestionClientes negCli = new GestionClientes(); 
		
		
		try {
			
			Cliente cli = negCli.obtener(k);
					
			negocio.actualizar(m,a, b,c,d,e,f,g,h,i,j,cli);
			response.sendRedirect(request.getContextPath()	+ "/Paciente.jsp");
		} catch (DAOExcepcion e1) {
			System.out.println(e1.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
