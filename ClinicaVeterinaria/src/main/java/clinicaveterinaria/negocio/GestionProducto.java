package clinicaveterinaria.negocio;

import java.util.Collection;

import clinicaveterinaria.dao.ProductoDAO;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Producto;
import clinicaveterinaria.modelo.TipoProducto;

public class GestionProducto {
	public Producto insertar(String producto, double precio, int idTipo)
			throws DAOExcepcion {
		ProductoDAO dao = new ProductoDAO();

		Producto oProducto = new Producto();
		oProducto.setProducto(producto);
		oProducto.setPrecio(precio);
		
		TipoProducto oTipoProducto = new TipoProducto();
		oTipoProducto.setIdTipo(idTipo);
		
		oProducto.setoTipoProducto(oTipoProducto);
		
		return dao.insertar(oProducto);
	}

	public Producto obtener(int idProducto) throws DAOExcepcion {
		ProductoDAO dao = new ProductoDAO();
		return dao.obtener(idProducto);
	}

	public void eliminar(int idProducto) throws DAOExcepcion {
		ProductoDAO dao = new ProductoDAO();
		dao.eliminar(idProducto);
	}

	public Producto actualizar(int idProducto, String Producto, double precio, int idTipo) throws DAOExcepcion {
		ProductoDAO dao = new ProductoDAO();

		Producto oProducto = new Producto();
		oProducto.setIdProducto(idProducto);
		oProducto.setProducto(Producto);
		oProducto.setPrecio(precio);

		TipoProducto oTipoProducto = new TipoProducto();
		oTipoProducto.setIdTipo(idTipo);
		
		oProducto.setoTipoProducto(oTipoProducto);

		return dao.actualizar(oProducto);
	}

	public Collection<Producto> buscarProducto(String nombre, int tipo) throws DAOExcepcion {
		ProductoDAO dao = new ProductoDAO();
		return dao.buscarArticuloxTipo(nombre, tipo);
	}
	
	public Collection<Producto> buscarVacuna(String nombre) throws DAOExcepcion {
		ProductoDAO dao = new ProductoDAO();
		return dao.buscarArticuloxTipo(nombre, 1);
	}

	public Collection<Producto> buscarServicio(String nombre) throws DAOExcepcion {
		ProductoDAO dao = new ProductoDAO();
		return dao.buscarArticuloxTipo(nombre, 2);
	}

	public Collection<Producto> buscarAccesorio(String nombre) throws DAOExcepcion {
		ProductoDAO dao = new ProductoDAO();
		return dao.buscarArticuloxTipo(nombre, 3);
	}

}
