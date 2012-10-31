package clinicaveterinaria.test;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Prospecto;
import clinicaveterinaria.negocio.GestionProspectos;

public class GestionProspectosTest {

	@Test
	public void insertarTest() {

		GestionProspectos negocio = new GestionProspectos();

		try {
			
			//Prospecto nuevo = negocio.insertar("marcelo campos","mcampos@gmail.com","cll.huaman poma de ayala nro 250","rcampos.jpg","888-8888","99-999-9999");
			Prospecto nuevo = negocio.insertar("ricardo campos","rcampos@gmail.com","cll.huaman poma de ayala nro 250","rcampos.jpg","777-7777","99-999-9999", "");

			Prospecto obtener = negocio.obtener(nuevo.getIdProspecto());


			//Assert.assertEquals("888-8888", obtener.getTelcasa());
			Assert.assertEquals("777-7777", obtener.getTelcasa());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	//@Test
	public void actualizarTest() {

		GestionProspectos negocio = new GestionProspectos();

		try {

			int iId = 1;
			
			//negocio.actualizar(iId, "ricardo j. campos l.","rcampos@laive.com.pe","cll.huamanpoma de ayala nro 250 san miguel","rcampos.jpg","5785711","994103423");
			negocio.actualizar(iId, "ricardo campos","rcampos@laive.com.pe","cll.huamanpoma de ayala nro 250 san miguel","rcampos.jpg","5785711","994103423","");

			Prospecto obj = negocio.obtener(iId);

			//Assert.assertEquals("994103423", obj.getTelcelular());
			Assert.assertEquals("ricardo campos", obj.getNombre());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}
	
//	@Test
	public void listarTest() {

		GestionProspectos negocio = new GestionProspectos();

		try {
			Collection<Prospecto> listado = negocio.listar();

			System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);
			for (Prospecto x : listado){
				System.out.println(x.getIdProspecto() + " | " + x.getNombre() + " | " + x.getEmail() + " | " + 
			                       x.getDireccion() + " | " + x.getImagen() + " | " + x.getTelcasa() + " | " +
						           x.getTelcelular() );
			}

		
		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}

	}

	//@Test
	public void eliminarTest() {

		GestionProspectos negocio = new GestionProspectos();

		try {

			int iId = 2;
			
			negocio.eliminar(iId);

			Prospecto nuevo = negocio.obtener(iId);

			Assert.assertEquals(null, nuevo.getNombre());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}
	
	//@Test
	public void cambiar2Cliente() {

		GestionProspectos negocio = new GestionProspectos();
		

		try {

			int iId = 1;
			
			negocio.cambiar2cliente(iId);
			
//			Prospecto nuevo = negocio.obtener(iId);
			
//			Assert.assertEquals(true, nuevo.isCliente());
			
			
									

		} catch (DAOExcepcion e) {

			Assert.fail("Falló de Cambio de Cliente: " + e.getMessage());

		}

	}
	
}
