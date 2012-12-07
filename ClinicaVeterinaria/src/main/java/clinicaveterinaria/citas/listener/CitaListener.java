package clinicaveterinaria.citas.listener;

import java.util.Map;

import org.springframework.stereotype.Component;

import clinicaveterinaria.modelo.BeanCitas;

@Component
public class CitaListener {

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
				
		BeanCitas cita = new BeanCitas(idCita, descripcion, telefono, direccion, fecha, estado, idDoctor, idPaciente, idCliente);
		System.out.println("Nro Cita: "+idCita+", Cod Cliente: "+idCliente+", Cod Paciente: "+idPaciente+", Cod Doctor: "+idDoctor+
				", Descripcion: "+descripcion+", Telefono: "+telefono+", Direccion: "+direccion+", Fecha: "+fecha+", Estado: "+estado);
	}
}