package clinicaveterinaria.citas.source;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import clinicaveterinaria.modelo.BeanCitas;

public class CitaSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendCita(final BeanCitas cita) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage mapMessage = session.createMapMessage();
				mapMessage.setInt("idCita", cita.getIdCita());
				
				mapMessage.setInt("idCliente", cita.getIdCliente());
				mapMessage.setInt("idPaciente", cita.getIdPaciente());
				mapMessage.setInt("idDoctor", cita.getIdDoctor());				
				
				mapMessage.setString("descripcion", cita.getDescripcion());				
				mapMessage.setString("telefono", cita.getTelefono());
				mapMessage.setString("direccion", cita.getDireccion());
				mapMessage.setString("fecha", cita.getFecha());				
				mapMessage.setString("estado", cita.getEstado());
				
				return mapMessage;
			}
		});
		System.out.println("Cita en cola - id: "+ cita.getIdCita());
	}
}