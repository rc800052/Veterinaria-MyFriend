package clinicaveterinaria.negocio;

import clinicaveterinaria.dao.FacturaDetalleDAO;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.FacturaDetalle;
import clinicaveterinaria.modelo.Producto;

public class GestionFacturaDetalle {
/*
	public Collection<Categoria> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		CategoriaDAO dao = new CategoriaDAO();
		return dao.listar();
	}
*/
	public FacturaDetalle insertar(double cantidad, double precio, double subtotal, double igv, int idFactura, Producto oProducto, int idCitaDet)
			throws DAOExcepcion {
		FacturaDetalleDAO dao = new FacturaDetalleDAO();

		FacturaDetalle factdeta = new FacturaDetalle();
		factdeta.setCantidad(cantidad);
		factdeta.setPrecio(precio);
		factdeta.setSubtotal(subtotal);
		factdeta.setIgv(igv);
		factdeta.setIdFact(idFactura);
		factdeta.setoProducto(oProducto);
		factdeta.setIdCitaDet(idCitaDet);

		return dao.insertar(factdeta,oProducto);
	}
/*
	public Factura obtener(int idFactura) throws DAOExcepcion {
		FacturaDAO dao = new FacturaDAO();
		return dao.obtener(idFactura);
	}

	public void eliminar(int idFactura) throws DAOExcepcion {
		FacturaDAO dao = new FacturaDAO();
		dao.eliminar(idFactura);
	}

	public Categoria actualizar(int idCategoria, String nombre,
			String descripcion) throws DAOExcepcion {
		CategoriaDAO dao = new CategoriaDAO();

		Categoria vo = new Categoria();
		vo.setIdCategoria(idCategoria);
		vo.setNombre(nombre);
		vo.setDescripcion(descripcion);

		return dao.actualizar(vo);
	}

	public Collection<Factura> listar_cliente(int idCliente) throws DAOExcepcion {
		FacturaDAO dao = new FacturaDAO();
		return dao.listar_cliente(idCliente);
	}
*/
}
