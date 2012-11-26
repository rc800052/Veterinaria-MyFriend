package service.impl;

import java.util.Collection;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import service.ClienteService;
import util.Constantes;
import vo.ClienteCollection;
import dao.ClienteDAO;
import dominio.Cliente;
import excepcion.DAOExcepcion;


public class ClienteServiceImpl implements ClienteService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
    public ClienteServiceImpl() {}    
    
	@Override
	public ClienteCollection clientes() throws DAOExcepcion {
		ClienteDAO clienteDao = new ClienteDAO();
		Collection<Cliente> clientes = clienteDao.buscarPorNombre(Constantes.VACIO);
		ClienteCollection resultados = new ClienteCollection(clientes);		
		return resultados;
	}
    
	@Override
	public ClienteCollection clientesXNombre(String nombre) throws DAOExcepcion {
		ClienteDAO clienteDao = new ClienteDAO();
		Collection<Cliente> clientes = clienteDao.buscarPorNombre(nombre);
		ClienteCollection resultados = new ClienteCollection(clientes);		
		return resultados;
	}
	
}
