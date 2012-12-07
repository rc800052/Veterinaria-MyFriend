package clinicaveterinaria.citas.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinicaveterinaria.modelo.BeanCitas;

@Service("citaService")
public class CitaService {
	static int citaSequence = 1;

	@Autowired
	private CitaSender citaSender;

	public void setCitaSender(CitaSender citaSender) {
		this.citaSender = citaSender;
	}

	public void sendCita(BeanCitas cita) {
		citaSender.sendCita(cita);
	}
}