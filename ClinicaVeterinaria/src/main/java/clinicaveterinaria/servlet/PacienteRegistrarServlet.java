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
 * Servlet implementation class PacienteRegistrarServlet
 */
@WebServlet("/PacienteRegistrarServlet")
public class PacienteRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteRegistrarServlet() {
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

			
			GestionPacientes negCan = new GestionPacientes();
			GestionClientes negCli = new GestionClientes(); 
					
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
			
			Cliente cli = negCli.obtener(k);
			
	
			

			
			try {
				negCan.insertarpaciente(a, b, c, d, e, f,g,h,i,j,cli);
				
				
				request.setAttribute("MENSAJE", "Paciente Registrado Correctamente.");
				
			} catch (DAOExcepcion e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				request.setAttribute("MENSAJE", e1.getMessage());
			}
		
			
		} catch (IllegalArgumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			request.setAttribute("MENSAJE", "ERROR, Falta llenar campos o tipo de variable no soportada: -" + e2.getMessage() + "-");
		} catch (DAOExcepcion e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
			RequestDispatcher rd = request.getRequestDispatcher("Paciente.jsp");
			rd.forward(request, response);
		
			
				
		}
	
	
	}

