package clinicaveterinaria.test;

import java.text.ParseException;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.negocio.GestionClientes;

public class GestionClientesTest {

	//Inserta Clientes
	//@Test 
	public void insertarTest() throws DAOExcepcion {
	
		GestionClientes negocio = new GestionClientes();
	
		try {
			Cliente nuevo =  new Cliente();
			nuevo = negocio.insertar("Pikachu", "juan@gmail.com","Av. Lima 123", "/Image/cliente.jpg", "9852212", "89564512" ,"");
			//nuevo = negocio.insertar("Avatar", "ricardo@gmail.com","Av. Lima 123", "/Image/avatar.jpg", "9999999", "55555555" ,"");
			Cliente obtener = negocio.obtener(nuevo.getIdCliente());
			Assert.assertEquals("juan@gmail.com", obtener.getEmail());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
		
		System.out.println("El Cliente ha sido creado.");
	}
	
	
	//@Test Actualiza Datos de Cliente
	//@Test
	public void actualizarTest() {
		
		System.out.println("El Cliente ha sido Actualizado.");
		GestionClientes negocio = new GestionClientes();
		try {
			negocio.actualizar(26,"Rosa Mendez", "rosa@gmail.com","Av. Lima 456", "/Image/cliente2.jpg", "5555555", "999999999","BBBBBBBBBBB");
			Cliente nuevo = negocio.obtener(26);
			Assert.assertEquals("Rosa Mendez", nuevo.getNombre());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}
	
	
	//@Test Actualizar Notas del Cliente
	public void actualizarNotasTest() {
				
		GestionClientes negocio = new GestionClientes();

		try {
			negocio.actualizarNotas(6, "NOTas NOTas NOTas");
			Cliente nuevo = negocio.obtener(6);
			Assert.assertEquals("NOTas NOTas NOTas", nuevo.getNotas());

		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
		
		System.out.println("Las Notas del Cliente ha sido Actualizado.");

	}
	
	//@Test // Listar Clientes
	public void listarTest() {
		
		GestionClientes negocio = new GestionClientes();

		try {
			Collection<Cliente> listado = negocio.listar();
			System.out.println(listado.size());
			Assert.assertTrue(listado.size() > 0);
			for ( Cliente x: negocio.listar()){
				
				System.out.println("Nombre : "+x.getNombre());
				System.out.println("Email :"+ x.getEmail());
				System.out.println("Direccion :"+ x.getDireccion());
				System.out.println("Imagen :"+ x.getImagen());
				System.out.println("Telefono Casa :"+ x.getTelcasa());
				System.out.println("Telefono Celular :"+ x.getTelcelular());
				System.out.println("Notas :"+ x.getNotas());
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
				
			}
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
		System.out.println("Lista de Clientes");
	}
	
	@Test
	public void buscarPorNombre() throws ParseException {

		GestionClientes negocio = new GestionClientes();

		try {
			String Nombre;
			Nombre = "JORGE LUIS ALCANTARA OSPINA";
			
			Collection<Cliente> listado = negocio.buscarPorNombre(Nombre);
			
			for (Cliente x:listado) {
				 System.out.println("Codigo : " + x.getIdCliente() + " - Nombre : "+ x.getNombre() + "  Direccion : " + x.getDireccion());
	        }
			
			
			//System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}

	}

	//@Test Eliminar Clientes
	@Test
	public void eliminarTest() {
		
		GestionClientes negocio = new GestionClientes();

		try {
			negocio.eliminar(27);
			Cliente nuevo = negocio.obtener(27);
			Assert.assertEquals(null, nuevo.getNombre());

		} catch (DAOExcepcion e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
		System.out.println("El Cliente ha sido Eliminado.");
	}
	
}
