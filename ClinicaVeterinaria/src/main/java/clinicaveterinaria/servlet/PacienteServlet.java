package clinicaveterinaria.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/PacienteServlet")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteServlet() {
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
	
		/* try{
			
			GestionPacientes negCan2 = new GestionPacientes();

		
			String a=request.getParameter("txtnombreclipac");
			String b=request.getParameter("optesterilizadopac");
			String c=request.getParameter("lsttamanopac");
						
			String d=request.getParameter("lstactividadpac");
			Integer e=Integer.parseInt(request.getParameter("txtpesopac"));
			Date f = Date.valueOf(request.getParameter("text"));
			String g=request.getParameter("cmbespeciepac");
			
			/*for(int i=0;i<100;i++){
				System.out.println("Valor del combo:["+g+"]");
			}
			*/
		
		
		/*
			String h=request.getParameter("cmbrazapac");
			String i=request.getParameter("optgenpac");
			String j=request.getParameter("txttiposangrepac");
		
			
				
			try {
				negCan2.insertarpaciente(a, b, c, d, e, f, g, h,i, j);
								
				request.setAttribute("MENSAJE", "Paciente registrado correctamente.");
				
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
					.getRequestDispatcher("paciente.jsp");
			rd.forward(request, response);
		
		
				
		}
		*/
	}
}

