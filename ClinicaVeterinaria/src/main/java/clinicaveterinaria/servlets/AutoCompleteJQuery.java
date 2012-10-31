package clinicaveterinaria.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.negocio.GestionClientes;

/**
 * Servlet implementation class AutoCompleteJQuery
 */
@WebServlet("/AutoCompleteJQuery")
public class AutoCompleteJQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompleteJQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
        GestionClientes negocio = new GestionClientes();
       try {
       	Collection<Cliente> listado = negocio.listar();

       	String Nombre = request.getParameter("q");

            for(Cliente cliente : listado ){
                if(cliente.getNombre().toLowerCase().startsWith(Nombre))
                out.println(cliente.getIdCliente() + "|" + cliente.getNombre());
            }
       } catch (DAOExcepcion e) {
       	Assert.fail("Falló el listado: " + e.getMessage());
       	
		} finally {
           out.close();
       }

		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
