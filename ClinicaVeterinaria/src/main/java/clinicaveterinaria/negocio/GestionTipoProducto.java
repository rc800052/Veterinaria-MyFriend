package clinicaveterinaria.negocio;

import java.util.Collection;

import clinicaveterinaria.dao.TipoProductoDAO;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.TipoProducto;

public class GestionTipoProducto {
	
	public Collection<TipoProducto> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		TipoProductoDAO dao = new TipoProductoDAO();
		return dao.buscarPorNombre(nombre);
	}
	
	public TipoProducto insertar(String tipo )
			throws DAOExcepcion {
		TipoProductoDAO dao = new TipoProductoDAO();

		TipoProducto vo = new TipoProducto();
		vo.setTipo(tipo);
		
		return dao.insertar(vo);
	}
	
	public TipoProducto obtener(int idTipo) throws DAOExcepcion {
		TipoProductoDAO dao = new TipoProductoDAO();
		return dao.obtener(idTipo);
	}
	
	public void eliminar(int idTipo) throws DAOExcepcion {
		TipoProductoDAO dao = new TipoProductoDAO();
		dao.eliminar(idTipo);
	}

	public TipoProducto actualizar(int idTipo, String tipo)
			 throws DAOExcepcion {
		TipoProductoDAO dao = new TipoProductoDAO();

		TipoProducto vo = new TipoProducto();
		vo.setIdTipo(idTipo);
		vo.setTipo(tipo);
		
		return dao.actualizar(vo);
	}
	
	public Collection<TipoProducto> listar() throws DAOExcepcion {
		TipoProductoDAO dao = new TipoProductoDAO();
		return dao.listar();
	}
	
}
