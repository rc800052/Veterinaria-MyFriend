package clinicaveterinaria.test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cita;
import clinicaveterinaria.modelo.CitaCabDet;
import clinicaveterinaria.negocio.GestionCitas;
//import clinicaveterinaria.modelo.CitaporCliente;

public class GestionCitasTest {

//	@Test
	public void insertarTest() throws ParseException {

		GestionCitas negocio = new GestionCitas();

		try {

			  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			  String Fecha;
			  Fecha = "16/07/2012";
			  Date fec = null;
			  fec = sdf.parse(Fecha);
			  
			  java.util.Date utilDate = new java.util.Date();
			  utilDate = fec;
			  java.sql.Date fchCita = new java.sql.Date(utilDate.getTime());
			
			
			  Cita nuevo = negocio.insertar("control medico y vacunas", "555-5555", "av. el sol n° 456", fchCita, 1, 1, 1);

			
			
			Cita cita1 = negocio.obtener(nuevo.getIdCita());
			Assert.assertEquals("555-5555", cita1.getTelefono());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
		System.out.println("La cita ha sido registrada.");
	}

	

	//@Test
	public void actualizarTest() throws ParseException {

		GestionCitas negocio = new GestionCitas();

		try {

			  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			  String Fecha;
			  Fecha = "18/08/2012";
			  Date fec = null;
			  fec = sdf.parse(Fecha);
			  
			  java.util.Date utilDate = new java.util.Date();
			  utilDate = fec;
			  java.sql.Date fchCita = new java.sql.Date(utilDate.getTime());
			
			Cita nuevo = negocio.actualizar(1, "vacuna antirabica", "555-5555", "av. el sol n° 456", fchCita, 1, 1, 1);
			
			
			
			Cita cita1 = negocio.obtener(nuevo.getIdCita());
			Assert.assertEquals("555-5555", cita1.getTelefono());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
		System.out.println("La cita ha sido re-programada.");
	}

	
	//@Test
	public void anularCitaTest() throws ParseException {

		
		
		
		GestionCitas negocio = new GestionCitas();

		try {

			
			
			  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			  String Fecha;
			  Fecha = "16/07/2012";
			  Date fec = null;
			  fec = sdf.parse(Fecha);
			  
			  java.util.Date utilDate = new java.util.Date();
			  utilDate = fec;
			  java.sql.Date fchCita = new java.sql.Date(utilDate.getTime());
			
			
			  Cita nuevo = negocio.insertar("control medico y vacunas", "555-5555", "av. el sol n° 456", fchCita, 1, 1, 1);

			
			
			  negocio.anularCita(nuevo.getIdCita());
			
			  Cita cita1 = negocio.obtener(1);
			
			  Assert.assertEquals("A", cita1.getEstado());

		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
		System.out.println("La cita se anulo satisfactoriamente.");
	}

	
	
	// Consultar las Citas que presenta un Cliente.
//	@Test
	public void listarCitasPendientesporClienteTest() {
		
		GestionCitas negocio = new GestionCitas();

		try {
			int idCliente = 1;
			Collection<Cita> listado = negocio.buscarCitasPendientesPorCliente(idCliente);
			System.out.println(listado.size());
			Assert.assertTrue(listado.size() > 0);
			
			for (Cita x : listado){
				System.out.println(x.getFchcita() + " | " + x.getDescripcion() + " | " + 
			                       x.getoDoctor().getApellido() +", "+ x.getoDoctor().getNombre()+ " | " +
			                       x.getoPaciente().getEspecie() + ", "+ x.getoPaciente().getNombre());
			}
				
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
		System.out.println("Lista de Citas por Clientes");
	}
	
	
	@Test
	public void listarCitasxFacturarCliente() {
		
		GestionCitas negocio = new GestionCitas();

		try {
			int idCliente = 1;
			Collection<CitaCabDet> listado = negocio.listarCitasxFacturarCliente(idCliente);
			System.out.println(listado.size());
			Assert.assertTrue(listado.size() > 0);
			
			for (CitaCabDet x : listado){
				System.out.println(x.getFchcita() + " | " + x.getDescripcion() + " | "// + 
			                       //x.getoDoctor().getApellido() +", "+ x.getoDoctor().getNombre()+ " | " +
			                       //x.getoPaciente().getEspecie() + ", "+ x.getoPaciente().getNombre());
						);
			}
				
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
		System.out.println("Lista de Citas por Clientes");
	}
	
	
}
