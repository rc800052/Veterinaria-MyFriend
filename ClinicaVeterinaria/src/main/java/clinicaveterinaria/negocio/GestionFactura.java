package clinicaveterinaria.negocio;

import java.sql.Date;
import java.util.Collection;
import clinicaveterinaria.dao.FacturaDAO;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.modelo.Factura;

public class GestionFactura {

	public Collection<Factura> buscarPorFecha(Date fch_FacturaDesde, Date fch_FacturaHasta)
			throws DAOExcepcion {
		FacturaDAO dao = new FacturaDAO();
		return dao.buscarPorFecha(fch_FacturaDesde, fch_FacturaHasta);
	}

	public Factura insertar(Date fch_Factura, String serie, String numero, Date fch_Emision, String moneda, double tc, Cliente oCliente)
			throws DAOExcepcion {
		FacturaDAO dao = new FacturaDAO();

		Factura fact = new Factura();
		fact.setFch_Factura(fch_Factura);
		fact.setSerie(serie);
		fact.setNumero(numero);
		fact.setFch_Emision(fch_Emision);
		fact.setMoneda(moneda);
		fact.setTc(tc);
		fact.setoCliente(oCliente);

		return dao.insertar(fact,oCliente);
	}

	public Factura obtener(int idFactura) throws DAOExcepcion {
		FacturaDAO dao = new FacturaDAO();
		return dao.obtener(idFactura);
	}

	public void eliminar(int idFactura) throws DAOExcepcion {
		FacturaDAO dao = new FacturaDAO();
		dao.eliminar(idFactura);
	}

	public int obtenerUltimo() throws DAOExcepcion {
		int id= 0;
		FacturaDAO dao = new FacturaDAO();
		id = dao.obtenerUltimo();
		return id;
	}
	
	public Factura actualizar(int idFactura, Date fch_Factura, String serie, String numero, Date fch_Emision, String moneda, double tc, int idCliente) throws DAOExcepcion {
		FacturaDAO dao = new FacturaDAO();

		Factura fact = new Factura();
		fact.setIdFactura(idFactura);
		fact.setFch_Factura(fch_Factura);
		fact.setSerie(serie);
		fact.setNumero(numero);
		fact.setFch_Emision(fch_Emision);
		fact.setMoneda(moneda);
		fact.setTc(tc);
		fact.setIdCliente(idCliente);

		return dao.actualizar(fact);
	}

	public Collection<Factura> listar_x_cliente(int idCliente) throws DAOExcepcion {
		FacturaDAO dao = new FacturaDAO();
		return dao.listar_x_cliente(idCliente);
	}

}
