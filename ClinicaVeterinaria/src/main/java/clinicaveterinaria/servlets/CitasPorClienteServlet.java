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
import clinicaveterinaria.modelo.CitaCabDet;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.modelo.Producto;
import clinicaveterinaria.negocio.GestionCitas;
import clinicaveterinaria.negocio.GestionFactura;
import clinicaveterinaria.negocio.GestionFacturaDetalle;

/**
 * Servlet implementation class CitasPorClienteServlet
 */
@WebServlet("/CitasPorClienteServlet")
public class CitasPorClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CitasPorClienteServlet() {
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
		
		String codigo = request.getParameter("codigo");
		String serie = request.getParameter("serie");
		String numero = request.getParameter("numero");
		String fecha = request.getParameter("fecha");
		String moneda = request.getParameter("moneda");
		String tc = request.getParameter("tc");
		String emision = request.getParameter("emision");
		String cliente_id = request.getParameter("cliente_id");
		String cliente = request.getParameter("cliente");
		
		String peticion = request.getParameter("txtpeticion");
		
		try {
			
			if(peticion.equals("Buscar")) {				
				GestionCitas negocio = new GestionCitas();
				
				int idCliente = Integer.parseInt(cliente_id);
				
				Collection<CitaCabDet> listado = negocio.listarCitasxFacturarCliente(idCliente);
	
				//Assert.assertTrue(listado.size() > 0);
				
				// Enviar objetos al JSP
				request.setAttribute("RESULTADO",listado);
				request.setAttribute("CODIGO",codigo);
				request.setAttribute("SERIE",serie);
				request.setAttribute("NUMERO",numero);
				request.setAttribute("FECHA",fecha);
				request.setAttribute("MONEDA",moneda);
				request.setAttribute("TC",tc);
				request.setAttribute("EMISION",emision);
				request.setAttribute("CLIENTE_ID",cliente_id);
				request.setAttribute("CLIENTE",cliente);
				
				// Invocar al JSP
				RequestDispatcher rd = request.getRequestDispatcher("Factura.jsp");
			    //System.out.println(session.getAttribute("codigo"));
				rd.forward(request,response);
			}
			
			if(peticion.equals("Grabar")) {				
				//FACTURA CABECERA
				java.sql.Date fch_Factura;
				java.sql.Date fch_Emision;
				
				int idFactura;
				int idCliente = Integer.parseInt(cliente_id);
				double tipocambio = Double.parseDouble(tc);
				
				Cliente oCliente = new Cliente();
				oCliente.setIdCliente(idCliente);
				
				GestionFactura negocio = new GestionFactura();
				
				fch_Factura = new java.sql.Date(this.FormatearFecha(fecha).getTime());
				fch_Emision = new java.sql.Date(this.FormatearFecha(emision).getTime());
				
				negocio.insertar(fch_Factura, serie, numero, fch_Emision, moneda, tipocambio, oCliente);
				idFactura = negocio.obtenerUltimo();
				//FACTURA CABECERA
				
				//FACTURA DETALLE
				double cantidad_real;
				double precio_real;
				double subtotal;
				double igv;
				int idProducto;
				int idCitaDeta;
				
				GestionFacturaDetalle negociodeta = new GestionFacturaDetalle();
				
				String[] seleccionados = request.getParameterValues("seleccionar");
				String[] citadeta = request.getParameterValues("citadeta");
				String[] prod = request.getParameterValues("idprod");
				String[] cantidad = request.getParameterValues("cantidad");
				String[] precio = request.getParameterValues("precio");
				 

				for ( int i=0; i< seleccionados.length;  i++) {
					idProducto = 0;
					cantidad_real = 0;
					precio_real = 0;
					subtotal = 0;
					igv = 0;
					
					cantidad_real = Double.parseDouble(cantidad[i]);
					precio_real = Double.parseDouble(precio[i]);
					subtotal = cantidad_real * precio_real;
					igv = subtotal * 0.18;
					idProducto = Integer.parseInt(prod[i]);
					
					Producto oProducto = new Producto();
					oProducto.setIdProducto(idProducto);
					
					idCitaDeta = Integer.parseInt(citadeta[i]);
					
					negociodeta.insertar(cantidad_real,precio_real,subtotal,igv,idFactura,oProducto,idCitaDeta);
				}
				
				request.setAttribute("GRABAR","LA FACTURA GRABO CORRECTAMENTE...");
				
				// Invocar al JSP
				RequestDispatcher rd = request.getRequestDispatcher("Factura.jsp");
			    //System.out.println(session.getAttribute("codigo"));
				rd.forward(request,response);
				
			}
		} catch (DAOExcepcion e) {
			
			Assert.fail("Falló la actualización: " + e.getMessage());

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
