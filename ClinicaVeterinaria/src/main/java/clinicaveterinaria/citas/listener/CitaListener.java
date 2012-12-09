package clinicaveterinaria.citas.listener;

import java.util.Map;

import org.springframework.stereotype.Component;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.BeanCitas;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.modelo.Doctor;
import clinicaveterinaria.modelo.Paciente;
import clinicaveterinaria.negocio.GestionClientes;
import clinicaveterinaria.negocio.GestionDoctor;
import clinicaveterinaria.negocio.GestionPacientes;

@Component
public class CitaListener {
	
//	@Resource
//	private MailServicio mailServicio;

	public void citaReceived(Map<String, Object> message) throws Exception {
		Integer idCita = (Integer) message.get("idCita");
		Integer idCliente = (Integer) message.get("idCliente");
		Integer idPaciente = (Integer) message.get("idPaciente");
		Integer idDoctor = (Integer) message.get("idDoctor");
		
		String descripcion = (String) message.get("descripcion");
		String telefono = (String) message.get("telefono");
		String direccion = (String) message.get("direccion");
		String fecha = (String) message.get("fecha");
		String estado = (String) message.get("estado");
				
		BeanCitas citaObtenida = new BeanCitas(idCita, descripcion, telefono, direccion, fecha, estado, idDoctor, idPaciente, idCliente);
		enviarCorreoCliente(citaObtenida);
		
	}
	
	public void enviarCorreoCliente(BeanCitas cita) throws DAOExcepcion {
		
		GestionClientes serviceCliente = new GestionClientes();
		GestionPacientes servicePaciente = new GestionPacientes();
		GestionDoctor serviceDoctor = new GestionDoctor();
		
		Cliente cliente = serviceCliente.obtener(cita.getIdCliente());		
		Paciente paciente = servicePaciente.obtener(cita.getIdPaciente());
		Doctor doctor = serviceDoctor.obtener(cita.getIdDoctor());
		
		String asunto = "RESERVA DE CITA "+cita.getIdCita();
		StringBuffer mensajeBuffer = new StringBuffer();		
		mensajeBuffer.append("Estimado Cliente, se realizo la reserva de Cita, los datos a continuacion:");
		mensajeBuffer.append(" Cod Cliente: "+cita.getIdCliente());
		mensajeBuffer.append(", Cliente: "+cliente.getNombre());
		mensajeBuffer.append(", Cod Paciente: "+cita.getIdPaciente());
		mensajeBuffer.append(", Nombre Paciente: "+paciente.getNombre());
		mensajeBuffer.append(", Cod Doctor: "+cita.getIdDoctor());
		mensajeBuffer.append(", Nombre Doctor: "+doctor.getNombre());
		mensajeBuffer.append(", Descripcion: "+cita.getDescripcion());
		mensajeBuffer.append(", Telefono: "+cita.getTelefono());
		mensajeBuffer.append(", Direccion: "+cita.getDireccion());
		mensajeBuffer.append(", Fecha: "+cita.getFecha());		
		mensajeBuffer.append(", Estado: "+cita.getEstado());
		
		String mensaje = mensajeBuffer.toString();
		//mailServicio.send(cliente.getEmail(), asunto, mensaje);
		
		System.out.println(mensaje);				
	}
}