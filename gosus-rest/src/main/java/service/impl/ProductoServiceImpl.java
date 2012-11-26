package service.impl;

import java.util.Collection;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import service.ProductoService;
import util.Constantes;
import vo.ProductoCollection;
import dao.ProductoDAO;
import dominio.Producto;
import excepcion.DAOExcepcion;


public class ProductoServiceImpl implements ProductoService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
    public ProductoServiceImpl() {}
    
	@Override
	public ProductoCollection productos() throws DAOExcepcion {
		ProductoDAO productoDao = new ProductoDAO();		
		Collection<Producto> productos = 
			productoDao.buscarArticuloxTipo(Constantes.VACIO, Constantes.TIPO_PRODUCTO_ACCESORIO);
		ProductoCollection resultados = new ProductoCollection(productos);		
		return resultados;
	}
	

	@Override
	public ProductoCollection productosXRangoFilas(Integer filaInicial,
			Integer cantFilas) throws DAOExcepcion {
		ProductoDAO productoDao = new ProductoDAO();		
		Collection<Producto> productos = 
			productoDao.buscarArticuloxTipoxRango(
					Constantes.VACIO, filaInicial, cantFilas, Constantes.TIPO_PRODUCTO_ACCESORIO);
		ProductoCollection resultados = new ProductoCollection(productos);		
		return resultados;
	}

	    
	@Override
	public ProductoCollection productosXNombre(String nombre) throws DAOExcepcion {		
		ProductoDAO productoDao = new ProductoDAO();		
		Collection<Producto> productos = 
			productoDao.buscarArticuloxTipo(nombre, Constantes.TIPO_PRODUCTO_ACCESORIO);
		ProductoCollection resultados = new ProductoCollection(productos);		
		return resultados;
	}
}
