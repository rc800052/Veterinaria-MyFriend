package clinicaveterinaria.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.negocio.GestionFactura;

/**
 * Servlet implementation class FacturaInsertarServlet
 */
@WebServlet("/FacturaInsertarServlet")
public class FacturaInsertarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacturaInsertarServlet() {
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
		// TODO Auto-generated method stub

		@SuppressWarnings("unused")
		String codigo = request.getParameter("codigo");
		String serie = request.getParameter("serie");
		String numero = request.getParameter("numero");
		String fecha = request.getParameter("fecha");
		String moneda = request.getParameter("moneda");
		String tipocambio = request.getParameter("tc");
		String emision = request.getParameter("emision");
		String cliente_id = request.getParameter("cliente_id");

		java.sql.Date fch_Factura;
		java.sql.Date fch_Emision;

		int idCliente = Integer.parseInt(cliente_id);
		double tc = Double.parseDouble(tipocambio);

		GestionFactura negocio = new GestionFactura();

		try {
			fch_Factura = new java.sql.Date(this.FormatearFecha(fecha)
					.getTime());
			fch_Emision = new java.sql.Date(this.FormatearFecha(emision)
					.getTime());

			Cliente oCliente = new Cliente();
			oCliente.setIdCliente(idCliente);

			negocio.insertar(fch_Factura, serie, numero, fch_Emision, moneda,
					tc, oCliente);

			// Assert.assertTrue(listado.size() > 0);

			// Enviar objetos al JSP
			// request.setAttribute("RESULTADO",listado);

			// Invocar al JSP
			RequestDispatcher rd = request.getRequestDispatcher("Factura.jsp");
			rd.forward(request, response);

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
