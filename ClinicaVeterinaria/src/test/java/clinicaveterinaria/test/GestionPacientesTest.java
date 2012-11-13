package clinicaveterinaria.test;
import java.text.ParseException;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.modelo.Paciente;
import clinicaveterinaria.negocio.GestionClientes;
import clinicaveterinaria.negocio.GestionPacientes;

public class GestionPacientesTest {

	
	//@Test 
	public void registrarPacienteTest() throws DAOExcepcion, ParseException {
	
		
		System.out.println("Test de registrar de Paciente");
		
		GestionClientes negocio = new GestionClientes();
		GestionPacientes negociopaciente = new GestionPacientes();
		
	
		try {
			Cliente objcliente =  negocio.insertar("Juan Botetano", "juan.botetano@gmail.com","Calle Mario Florian 271 San Borja", "/Image/jbotetano.jpg", "3461204", "991923307","");
			Assert.assertEquals("juan.botetano@gmail.com", objcliente.getEmail());
			

//			 DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
//			 String Fecha;
//			 Fecha = "16/07/2012";
//			 Date fec = null;
//			 fec = sdf.parse(Fecha);
//			  
//			 java.util.Date utilDate = new java.util.Date();
//			 utilDate = fec;
//			 java.sql.Date fchPaciente = new java.sql.Date(utilDate.getTime());
			
			
		
			  
			Paciente objpaciente = negociopaciente.insertarpaciente("Kafir", "S", "Mediano", "En las ma�anas sale al parque", 15, "01/01/2012", "perro", "cocker spaniel", "Macho", "RH+", objcliente);
			
			
			
			Assert.assertEquals("Kafir", objpaciente.getNombre());
			
			
			
			Paciente objpaciente1 = negociopaciente.insertarpaciente("Salvo", "S", "Peque�o", "Hoga�ero", 10, "01/05/2012", "perro", "sin raza", "Macho", "RH+", objcliente);
			
			Assert.assertEquals("Salvo", objpaciente1.getNombre());
			
			
			
			
			
			
			System.out.println("Nombre  | Actividad | Tama�o | Especie | Raza | Genero ");
			for ( Paciente x: negociopaciente.buscarPorIdCliente(objcliente.getIdCliente())){
				
				System.out.println(x.getNombre() + " | "+ x.getActividad() + " | "+ x.getTamano() + " | " + x.getEspecie() + " | " + x.getRaza() + " | " + x.getGenero());
				
				
			}
			

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserci�n: " + e.getMessage());
		}
		
		System.out.println("El Paciente se ha registrado satisfactoriamente en el sistema.");
	}
	
	
	
	//@Test 
	public void actualizarPacienteTest() throws DAOExcepcion, ParseException {
	
		System.out.println("INICIANDO Test de actualizacion de paciente");
		
		GestionPacientes negociopaciente = new GestionPacientes();
//		GestionClientes negocio = new GestionClientes();
	
		try {

			//  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			 // String Fecha;
			  //Fecha = "16/07/2012";
			//  Date fec = null;
			//  fec = sdf.parse(Fecha);
			  
			//  java.util.Date utilDate = new java.util.Date();
		//	  utilDate = fec;
		//	  java.sql.Date fchPaciente = new java.sql.Date(utilDate.getTime());
			
			/*
			Cliente objcliente =  negocio.insertar("Juan Botetano", "juan.botetano@gmail.com","Calle Mario Florian 271 San Borja", "/Image/jbotetano.jpg", "3461204", "991923307","");
			Assert.assertEquals("juan.botetano@gmail.com", objcliente.getEmail());
			 */		
			GestionClientes neg = new GestionClientes();
			Cliente objcliente = neg.obtener(1);
				
			  Paciente objpaciente = negociopaciente.actualizar(12, "Mateus", "S", "Mediano", "Ninguna", 15, "01/01/2001", "gato", "angora", "Macho", "RH-",objcliente);
			
			  Assert.assertEquals("Leonidas", objpaciente.getNombre());
			
			  		System.out.println("Nombre  | Actividad | Tama�o | Especie | Raza | Genero ");
			  
				for ( Paciente x: negociopaciente.buscarPorIdCliente(1)){
					
					System.out.println(x.getNombre() + " | "+ x.getActividad() + " | "+ x.getTamano() + " | " + x.getEspecie() + " | " + x.getRaza() + " | " + x.getGenero());
					
				}
			
			

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la actualizacion: " + e.getMessage());
		}
		
		System.out.println("El Paciente se ha actualizado satisfactoriamente en el sistema.");
	}
	
	
	@Test
		public void buscarPorNombre() {
			
			GestionPacientes negocio = new GestionPacientes();

			try {
				Collection<Paciente> buscarPorNombre = negocio.buscarPorNombre("");
				Assert.assertTrue(buscarPorNombre.size() > 0);
				for ( Paciente x: negocio.listar()){
					
					System.out.println("C�digo de Doctor : "+x.getIdPaciente());
					System.out.println("Nombre :"+ x.getNombre());
					System.out.println("Esterilizado:"+ x.getEsterelizado());
					System.out.println("Tama�o:"+ x.getTamano());
					System.out.println("Act :"+ x.getActividad());
					System.out.println("Peso:"+ x.getPeso());
					
					System.out.println("FEcha:"+ x.getFchnac());
					System.out.println("Especie:"+ x.getEspecie());
					System.out.println("Raza:"+ x.getRaza());
					System.out.println("Genero:"+ x.getGenero());
					System.out.println("TipoSangre:"+ x.getTiposangre());
					System.out.println("Cliente:"+ x.getOcliente().getIdCliente());
					
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); 
					
				}
			} catch (DAOExcepcion e) {
				Assert.fail("Fall� el listado: " + e.getMessage());
			}
			System.out.println("Se encontr� coincidencias por nombre de Doctor");
		}
	
	//@Test 
	public void eliminarTest() {
		
		System.out.println("INICIANDO Test de eliminacion de paciente");
		
		GestionPacientes negociopaciente = new GestionPacientes();
		
		
		
		

		try {
			negociopaciente.eliminar(2);
			
			Paciente nuevo = negociopaciente.obtener(2);
			Assert.assertEquals(null, nuevo.getNombre());
			
			System.out.println("Nombre  | Actividad | Tama�o | Especie | Raza | Genero ");

			for ( Paciente x: negociopaciente.buscarPorIdCliente(1)){
				
				System.out.println(x.getNombre() + " | "+ x.getActividad() + " | "+ x.getTamano() + " | " + x.getEspecie() + " | " + x.getRaza() + " | " + x.getGenero());
				
			}
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la eliminici�n: " + e.getMessage());
		}
		System.out.println("El Paciente ha sido Eliminado.");
	}
	
	
}
