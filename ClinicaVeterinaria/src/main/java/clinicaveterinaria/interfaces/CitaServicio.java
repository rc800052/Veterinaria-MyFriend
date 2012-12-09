package clinicaveterinaria.interfaces;

import java.util.Collection;

import clinicaveterinaria.modelo.BeanCitas;




public interface CitaServicio {
	
	public Collection obtenerFullpacientes(int cod) throws Exception;
	public abstract BeanCitas insertarcita(BeanCitas citas) throws Exception;

}
