package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import vo.ProductoCollection;
import excepcion.DAOExcepcion;

@Path("/producto-service/")
@Produces("application/xml")
public interface ProductoService {
    
	@GET
    @Path("/productos")
    @Produces({"application/xml", "application/json"})
    public ProductoCollection productos() throws DAOExcepcion;
	
	@GET
    @Path("/productos")
    @Produces({"application/xml", "application/json"})
    public ProductoCollection productosXRangoFilas(
    		@PathParam("filaInicial") Integer filaInicial, 
    		@PathParam("cantFilas") Integer cantFilas) throws DAOExcepcion;
	
    @GET
    @Path("/productosXNombre/{nombre}")
    @Produces({"application/xml", "application/json"})
    public ProductoCollection productosXNombre(@PathParam("nombre") String nombre) throws DAOExcepcion;
    
}