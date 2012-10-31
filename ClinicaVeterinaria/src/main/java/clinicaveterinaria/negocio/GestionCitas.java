package clinicaveterinaria.negocio;

import java.sql.Date;
import java.util.Collection;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.dao.CitaDAO;
import clinicaveterinaria.modelo.Calendario;
import clinicaveterinaria.modelo.Cita;
import clinicaveterinaria.modelo.CitaCabDet;
import clinicaveterinaria.modelo.CitaDetalle;
import clinicaveterinaria.modelo.Producto;
import clinicaveterinaria.modelo.Doctor;
import clinicaveterinaria.modelo.Paciente;
import clinicaveterinaria.modelo.Cliente;

public class GestionCitas {

	public CitaDetalle insertarCitaDetalle(double cantidad, double precio, int idCita, int idProducto)
			throws DAOExcepcion {
		
		CitaDAO dao = new CitaDAO();

		Producto oProducto = new Producto();
		oProducto.setIdProducto(idProducto);

		CitaDetalle oCita = new CitaDetalle();
		oCita.setCantidad(cantidad);
		oCita.setPrecio(precio);
		oCita.setIdCita(idCita);
		oCita.setoProducto(oProducto);
		
		return dao.insertarCitaDetalle(oCita);
	}
	
	public Cita insertar(String descripcion, String telefono, String direccion, Date fchcita, int idDoctor, int idPaciente, int idCliente)
			throws DAOExcepcion {
		
		CitaDAO dao = new CitaDAO();

		Doctor oDoctor = new Doctor();
		oDoctor.setIdDoctor(idDoctor);

		Paciente oPaciente = new Paciente();
		oPaciente.setIdPaciente(idPaciente);

		Cliente oCliente = new Cliente();
		oCliente.setIdCliente(idCliente);
		
		Cita oCita = new Cita();
		oCita.setDescripcion(descripcion);
		oCita.setTelefono(telefono);
		oCita.setDireccion(direccion);
		oCita.setFchcita(fchcita);
		oCita.setEstado("P");
		oCita.setoDoctor(oDoctor);
		oCita.setoPaciente(oPaciente);
		oCita.setoCliente(oCliente);
		
		return dao.insertar(oCita);
	}

	public Cita obtener(int idCita) throws DAOExcepcion {
		CitaDAO dao = new CitaDAO();
		return dao.obtener(idCita);
	}

	public Cita actualizar(int idCita, String descripcion, String telefono, String direccion, Date fchcita, int idDoctor, int idPaciente, int idCliente)
			 throws DAOExcepcion {
		CitaDAO dao = new CitaDAO();

		Doctor oDoctor = new Doctor();
		oDoctor.setIdDoctor(idDoctor);

		Paciente oPaciente = new Paciente();
		oPaciente.setIdPaciente(idPaciente);

		Cliente oCliente = new Cliente();
		oCliente.setIdCliente(idCliente);
		
		Cita oCita = new Cita();
		oCita.setIdCita(idCita);
		oCita.setDescripcion(descripcion);
		oCita.setTelefono(telefono);
		oCita.setDireccion(direccion);
		oCita.setFchcita(fchcita);
		oCita.setoDoctor(oDoctor);
		oCita.setoPaciente(oPaciente);
		oCita.setoCliente(oCliente);
	
		return dao.actualizar(oCita);
	}
	
	public void anularCita(int idCita) throws DAOExcepcion {
		CitaDAO dao = new CitaDAO();

		dao.anularCita(idCita);
	}
	
	public Collection<Cita> buscarCitasPendientesPorCliente(int idCliente)
			throws DAOExcepcion {
		CitaDAO dao = new CitaDAO();
		return dao.buscarCitasPendientesPorCliente(idCliente);
	}

	public Collection<CitaCabDet> listarCitasxFacturarCliente(int idCliente)
			throws DAOExcepcion {
		CitaDAO dao = new CitaDAO();
		return dao.listarCitasxFacturarCliente(idCliente);
	}

	public Collection<Calendario> listarCalendario(int tipo, Date fchini, Date fchfin)
			throws DAOExcepcion {
		CitaDAO dao = new CitaDAO();
		return dao.listarCalendario(tipo, fchini, fchfin);
	}

	
}
