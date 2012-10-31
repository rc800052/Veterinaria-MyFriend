package clinicaveterinaria.test;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.Test;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Factura;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.modelo.Producto;
import clinicaveterinaria.negocio.GestionFactura;
import clinicaveterinaria.negocio.GestionFacturaDetalle;


public class GestionFacturaTest {

	//@Test
	public void insertarTest() throws ParseException {

		try {
			
			
			//FACTURA CABECERA
			// SETEAR EL CLIENTE 
			// 1 - JORGE ALCANTARA
			// 2 - GABRIEL 
			GestionFactura negocio = new GestionFactura();
			
			String Fecha;
			String serie;
			String numero;
			String Emision;
			String moneda;
			double tc;
			int idCliente;
			java.sql.Date fch_Factura;
			java.sql.Date fch_Emision;

			Fecha = "25/07/2012";//CAMBIAR
			serie = "001";
			numero = "000005";//CAMBIAR
			Emision = "25/07/2012";//CAMBIAR
			moneda = "MN";
			tc = 2.85;
			idCliente = 1;//CAMBIAR
			
			Cliente oCliente = new Cliente();
			oCliente.setIdCliente(idCliente);

			fch_Factura = new java.sql.Date(this.FormatearFecha(Fecha).getTime());
			fch_Emision = new java.sql.Date(this.FormatearFecha(Emision).getTime());

			negocio.insertar(fch_Factura, serie, numero, fch_Emision, moneda, tc, oCliente);
			
			int idFactura;
			idFactura = negocio.obtenerUltimo();
			
		    Factura nuevo = negocio.obtener(idFactura);

			Assert.assertEquals(idFactura,nuevo.getIdFactura());
			
			System.out.println("Se Registro la Factura Serie: " + nuevo.getSerie() + " Número: " + nuevo.getNumero());
			
			
			//FACTURA DETALLE
			//SETEAR EL PRODUCTO
			// 1 - VACUNA CONTRA EL TETANO , S/. 10.5
			// 2 - CHEQUE GENERAL S/. 40
			GestionFacturaDetalle negociodeta = new GestionFacturaDetalle();
			
			double cantidad;
			double precio;
			double subtotal;
			double igv,igv_porc;
			int idProducto;
			int idCitaDet;
			
			cantidad = 1;//CAMBIAR
			precio = 40;//CAMBIAR
			subtotal = cantidad * precio;
			igv_porc = 0.18;
			igv = subtotal * igv_porc;
			idProducto = 1;//CAMBIAR
			idCitaDet = 1;//CAMBIAR
			
			Producto oProducto = new Producto();
			oProducto.setIdProducto(idProducto);
			  
			negociodeta.insertar(cantidad,precio,subtotal,igv,idFactura,oProducto,idCitaDet);
			
			/*
		    Factura nuevo = negocio.obtener(7);

			Assert.assertEquals(7,nuevo.getIdFactura());
			*/

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	
	//@Test
	public void actualizarTest() throws ParseException {

		try {
			
			int idFactura;
			String Fecha;
			String serie;
			String numero;
			String Emision;
			String moneda;
			double tc;
			int idCliente;
			java.sql.Date fch_Factura;
			java.sql.Date fch_Emision;

			Fecha = "25/07/2012";//CAMBIAR
			serie = "001";
			numero = "000005";//CAMBIAR
			Emision = "25/07/2012";//CAMBIAR
			moneda = "MN";
			tc = 2.85;
			
			idFactura = 1;//CAMBIAR
			idCliente = 1;//CAMBIAR
			
			GestionFactura negocio = new GestionFactura();
			

			fch_Factura = new java.sql.Date(this.FormatearFecha(Fecha).getTime());
			fch_Emision = new java.sql.Date(this.FormatearFecha(Emision).getTime());

			negocio.actualizar(idFactura,fch_Factura,serie,numero,fch_Emision,moneda,tc,idCliente);
			
			Factura nuevo = negocio.obtener(idFactura);
			
			Assert.assertEquals(numero, nuevo.getNumero());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}

	
	@Test
	public void buscarPorFechaTest() throws ParseException {

		GestionFactura negocio = new GestionFactura();

		try {
			String FechaDesde;
			String FechaHasta;
			java.sql.Date fch_FacturaDesde;
			java.sql.Date fch_FacturaHasta;
			
			FechaDesde = "19/07/2012";
			FechaHasta = "19/07/2012";
			
			fch_FacturaDesde = new java.sql.Date(this.FormatearFecha(FechaDesde).getTime());
			fch_FacturaHasta = new java.sql.Date(this.FormatearFecha(FechaHasta).getTime());
			
			Collection<Factura> listado = negocio.buscarPorFecha(fch_FacturaDesde,fch_FacturaHasta);
			
			for (Factura x:listado) {
				 System.out.println("Fact Serie: " + x.getSerie() + " - Número: "+ x.getNumero() + "  Fecha: " + x.getFch_Factura() + " Moneda:" + x.getMoneda() + "  Cliente: " + x.getClienteNombre());
	        }
			
			
			//System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}

	}

//	@Test
	public void listar_x_ClienteTest() {

		GestionFactura negocio = new GestionFactura();

		try {
			//1 - Jorge Alcantara
			//2 - Juan Tapia
			//3 - Juan Perez
			int idCliente = 1;
			
			Collection<Factura> listado = negocio.listar_x_cliente(idCliente);
			
			for (Factura x:listado) {
				 System.out.println("Fact Serie: " + x.getSerie() + " - Número: "+ x.getNumero() + "  Fecha: " + x.getFch_Factura() + " Moneda:" + x.getMoneda() + "  Cliente: " + x.getClienteNombre());
	        }
			
			
			//System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}

	}
	
//	@Test
	public void eliminarTest() {

		GestionFactura negocio = new GestionFactura();

		try {

			negocio.eliminar(6);

			Factura nuevo = negocio.obtener(6);

			Assert.assertEquals(null, nuevo.getIdFactura());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}
	
	public Date FormatearFecha(String fch_Fecha) throws ParseException {
		DateFormat sdf_fecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fec_fecha = null;
		fec_fecha = sdf_fecha.parse(fch_Fecha);
		
		return fec_fecha;
	}


}
