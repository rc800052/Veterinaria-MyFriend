package clinicaveterinaria.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Factura;
import clinicaveterinaria.negocio.GestionFactura;

/**
 * Servlet implementation class FacturaBuscarServlet
 */
@WebServlet("/FacturaBuscarServlet")
public class FacturaBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaBuscarServlet() {
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
		
		// Recuperar
		
		String inicio = request.getParameter("inicio");
		String hasta = request.getParameter("fin");
		
		
		
		GestionFactura negocio = new GestionFactura();

		try {
			java.sql.Date fch_desde;
			java.sql.Date fch_hasta;
			
			fch_desde = new java.sql.Date(this.FormatearFecha(inicio).getTime());
			fch_hasta = new java.sql.Date(this.FormatearFecha(hasta).getTime());
			
			Collection<Factura> listado = negocio.buscarPorFecha(fch_desde, fch_hasta);

			//Assert.assertTrue(listado.size() > 0);
			
			// Enviar objetos al JSP
			request.setAttribute("RESULTADO",listado);
			
			// Invocar al JSP
			RequestDispatcher rd = request.getRequestDispatcher("FacturaListado.jsp");
			rd.forward(request,response);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Date FormatearFecha(String fch_Fecha) throws ParseException {
		DateFormat sdf_fecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fec_fecha = null;
		fec_fecha = sdf_fecha.parse(fch_Fecha);
		
		return fec_fecha;
	}

}
