package clinicaveterinaria.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clinicaveterinaria.dao.Citas;
import clinicaveterinaria.modelo.Doctor;
import clinicaveterinaria.negocio.CitasImpl;


@WebServlet("/CitasDTServlet")
public class CitasDTServlet extends HttpServlet {

	
	
	public void service(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		 try {
		 HttpSession session = request.getSession();
		 CitasImpl ocitas = new CitasImpl();		 
		
		  
	    	int cod;
			Doctor user = (Doctor) request.getSession().getAttribute("USUARIO_ACTUAL");
			
			
			System.out.println("oasiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"+user.getIdDoctor());
			cod  = user.getIdDoctor();
			Collection listaPacientes=ocitas.obtenerFullpacientes(cod);
			int nroFilas = listaPacientes.size();
			
			request.setAttribute("listaPacientes",listaPacientes);
			
			 System.out.println("llego al <<<<<<<<<<  "+nroFilas);
			 
			//getServletContext().getRequestDispatcher("/frm_citas.jsp").forward(request,response);
		
		
		

			RequestDispatcher rd = request.getRequestDispatcher("frm_citas.jsp");
			rd.forward(request, response);
				

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
		}

	
}
