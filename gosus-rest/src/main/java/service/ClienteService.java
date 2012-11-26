package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import vo.ClienteCollection;
import excepcion.DAOExcepcion;

@Path("/cliente-service/")
@Produces("application/xml")
public interface ClienteService {
	
	@GET
    @Path("/clientes")
    @Produces({"application/xml", "application/json"})
    public ClienteCollection clientes() throws DAOExcepcion;
	
    @GET
    @Path("/clientesXNombre/{nombre}")
    @Produces({"application/xml", "application/json"})
    public ClienteCollection clientesXNombre(@PathParam("nombre") String nombre) throws DAOExcepcion;
    
}