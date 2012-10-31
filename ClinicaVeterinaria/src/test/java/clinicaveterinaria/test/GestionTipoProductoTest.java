package clinicaveterinaria.test;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.TipoProducto;
import clinicaveterinaria.negocio.GestionTipoProducto;

public class GestionTipoProductoTest {

	@Test
	public void insertarTest() {

		GestionTipoProducto negocio = new GestionTipoProducto();

		try {

			@SuppressWarnings("unused")
			TipoProducto nuevo = negocio.insertar("Vacuna");

			// TipoProducto nuevo1 = negocio.insertar("Tarea");

			// TipoProducto obtener = negocio.obtener(nuevo.getIdTipo());

			// Assert.assertEquals("Vacuna", obtener.getTipo());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	// @Test
	public void actualizarTest() {

		GestionTipoProducto negocio = new GestionTipoProducto();

		try {

			int iId = 1;

			negocio.actualizar(iId, "Vacuna Cachorros");

			TipoProducto obj = negocio.obtener(iId);

			// Assert.assertEquals("994103423", obj.getTelcelular());
			Assert.assertEquals("Vacuna Cachorros", obj.getTipo());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}

	// @Test
	public void listarTest() {

		GestionTipoProducto negocio = new GestionTipoProducto();

		try {
			Collection<TipoProducto> listado = negocio.listar();

			System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}

	}

	// @Test
	public void eliminarTest() {

		GestionTipoProducto negocio = new GestionTipoProducto();

		try {

			int iId = 2;

			negocio.eliminar(iId);

			TipoProducto nuevo = negocio.obtener(iId);

			Assert.assertEquals(null, nuevo.getTipo());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}

}
