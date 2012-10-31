package clinicaveterinaria.test;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Doctor;
import clinicaveterinaria.negocio.GestionDoctor;

public class GestionDoctorTest {
	//@Test
	public void insertarUsuarioTest() {
		GestionDoctor negocio = new GestionDoctor();
	 	
		try {
//			Doctor nuevo = new Doctor(); 
			negocio.insertarUsuario("gcuchca");
//			Doctor obtener = negocio.obtener(nuevo.getIdDoctor());
//			Assert.assertEquals("gcuchca@gmail.com", obtener.getEmail());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
		
		System.out.println("El Doctor ha sido creado.");
	}
	//@Test
	public void insertarTest() throws DAOExcepcion {
	
		GestionDoctor negocio = new GestionDoctor();
	 	
		try {
			Doctor nuevo = new Doctor(); 
			nuevo = negocio.insertar("Gabrielink", "Cuchca", "gcuchca@gmail.com", "2810188", "jorge", "123456", "admin");
			Doctor obtener = negocio.obtener(nuevo.getIdDoctor());
			Assert.assertEquals("gcuchca@gmail.com", obtener.getEmail());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
		
		System.out.println("El Doctor ha sido creado.");
	}
	
	//@Test Actualiza Datos de Cliente
	//@Test
	public void actualizarTest() {
		GestionDoctor negocio = new GestionDoctor();
		try {
			negocio.actualizar(20,"abc","def","g@hot","1234567","gc","123456","a");
			Doctor nuevo = negocio.obtener(20);
			Assert.assertEquals("abc", nuevo.getNombre());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
		System.out.println("El Doctor ha sido Actualizado.");
	}

	//@Test Listar Doctor

//	@Test
	public void listarTest() {
		
		GestionDoctor negocio = new GestionDoctor();

		try {
			Collection<Doctor> listado = negocio.listar();
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
			System.out.println("Número de registros:"+listado.size());
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
			Assert.assertTrue(listado.size() > 0);
			for ( Doctor x: negocio.listar()){
				
				System.out.println("Código de Doctor : "+x.getIdDoctor());
				System.out.println("Nombre :"+ x.getNombre());
				System.out.println("Apellido :"+ x.getApellido());
				System.out.println("Email :"+ x.getEmail());
				System.out.println("Telefono :"+ x.getTelefono());
				System.out.println("Usuario :"+ x.getUsuario());
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
				
			}

		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
		System.out.println("Lista de Doctor");
	}

	//@Test Eliminar Doctor
	@Test
	public void eliminarTest() {
		
		GestionDoctor negocio = new GestionDoctor();

		try {
			negocio.eliminar(4);
			Doctor nuevo = negocio.obtener(4);
			Assert.assertEquals(null, nuevo.getNombre());

		} catch (DAOExcepcion e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
		System.out.println("El Cliente ha sido Eliminado.");
	}
	
	//@Test
	public void buscarPorNombre() {
		
		GestionDoctor negocio = new GestionDoctor();

		try {
			Collection<Doctor> buscarPorNombre = negocio.buscarPorNombre("");
			Assert.assertTrue(buscarPorNombre.size() > 0);
			for ( Doctor x: negocio.listar()){
				
				System.out.println("Código de Doctor : "+x.getIdDoctor());
				System.out.println("Nombre :"+ x.getNombre());
				System.out.println("Apellido :"+ x.getApellido());
				System.out.println("Email :"+ x.getEmail());
				System.out.println("Telefono :"+ x.getTelefono());
				System.out.println("Usuario :"+ x.getUsuario());
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
				
			}
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
		System.out.println("Se encontró coincidencias por nombre de Doctor");
	}
	
	
}
