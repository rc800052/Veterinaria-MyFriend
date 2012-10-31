package clinicaveterinaria.test;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Historia;
import clinicaveterinaria.negocio.GestionHistoria;

public class GestionHistoriaTest {

	//@Test
	public void insertarTest() throws DAOExcepcion {
	
		GestionHistoria negocio = new GestionHistoria();
	 	
		try {
			negocio.insertar("presenta malestar","imgPaciente_2","malo",2);
//			Historia nuevo = negocio.obtener(12);
//			Assert.assertEquals("presenta malestar", nuevo.getNotaMedica());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
		
		System.out.println("El Historia ha sido creado.");
	}

	//@Test //Listar Historia
	public void listarTest() {
		
		GestionHistoria negocio = new GestionHistoria();

		try {
			Collection<Historia> listado = negocio.listar();
			System.out.println(listado.size());
			Assert.assertTrue(listado.size() > 0);
			for ( Historia x: negocio.listar()){		
				System.out.println("Código Historia: "+x.getIdHistoria());
				System.out.println("Nota Médica:"+ x.getNotaMedica());
				System.out.println("Imagen Médica:"+ x.getImagenMedica());
				System.out.println("Condicion especial:"+ x.getCondicionEspecial());
				System.out.println("Código Cita:"+ x.getCita_idCita());
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
				
			}
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
		System.out.println("Lista de Historia");
	}
	@Test
	public void obtener() {
		
		GestionHistoria negocio = new GestionHistoria();

		try {
			Historia obtener = negocio.obtener(7);
			System.out.println(obtener.getIdHistoria());
			//Assert.assertTrue(obtener.size() > 0);

		}  catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
		System.out.println("Lista de Historia");
	}

	//@Test Eliminar Historia
	public void eliminarTest() {
		
		GestionHistoria negocio = new GestionHistoria();

		try {
			negocio.eliminar(3);
			Historia nuevo = negocio.obtener(3);
			Assert.assertEquals(null, nuevo.getIdHistoria());

		} catch (DAOExcepcion e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
		System.out.println("El Cliente ha sido Eliminado.");
	}
}