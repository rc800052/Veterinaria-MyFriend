package clinicaveterinaria.test;

import java.util.Collection;
import junit.framework.Assert;
import org.junit.Test;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Producto;
import clinicaveterinaria.negocio.GestionProducto;

public class GestionProductoTest {

//	@Test
	public void insertarTest() {

		GestionProducto negocio = new GestionProducto();

		try {
			//TIPO DE SERVICIO
			// 1 - SERVICIO
			// 2 - VACUNA
			// 3 - ACCESORIO
			
			Producto nuevo = negocio.insertar("VACUNA CONTRA EL TETANO", 40.00,2);
			Assert.assertEquals("VACUNA CONTRA EL TETANO", nuevo.getProducto());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	//@Test
	public void actualizarTest() {

		GestionProducto negocio = new GestionProducto();

		try {
			
			int idProducto;
			idProducto = 1;
					
			negocio.actualizar(idProducto, "Triple - edad: 6 semanas", 120, 1);

			Producto nuevo = negocio.obtener(idProducto);
			
			Assert.assertEquals("VACUNA CONTRA LA RABIA", nuevo.getProducto());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}

	//@Test
	public void eliminarTest() {

		GestionProducto negocio = new GestionProducto();

		try {
			
			int idProducto;
			idProducto = 2;//CAMBIAR
			
			negocio.eliminar(idProducto);

			Producto nuevo = negocio.obtener(idProducto);

			Assert.assertEquals(null, nuevo.getProducto());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}

	@Test
	public void listarVacunaTest() {
		
		GestionProducto negocio = new GestionProducto();

		try {
			Collection<Producto> listado = negocio.buscarVacuna("Rabia");
			System.out.println(listado.size());
			Assert.assertTrue(listado.size() > 0);
			
			for (Producto x : listado){
				System.out.println(x.getProducto() + " | " + x.getPrecio());
			}
				
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}

	//@Test
	public void listarServicioTest() {
		
		GestionProducto negocio = new GestionProducto();

		try {
			Collection<Producto> listado = negocio.buscarServicio("Baño");
			System.out.println(listado.size());
			Assert.assertTrue(listado.size() > 0);
			
			for (Producto x : listado){
				System.out.println(x.getProducto() + " | " + x.getPrecio());
			}
				
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}

	//@Test
	public void listarAccesorioTest() {
		
		GestionProducto negocio = new GestionProducto();

		try {
			Collection<Producto> listado = negocio.buscarAccesorio("Pedigree");
			System.out.println(listado.size());
			Assert.assertTrue(listado.size() > 0);
			
			for (Producto x : listado){
				System.out.println(x.getProducto() + " | " + x.getPrecio());
			}
				
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}

}
