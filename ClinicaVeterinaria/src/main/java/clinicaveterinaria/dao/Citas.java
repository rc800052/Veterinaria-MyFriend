package clinicaveterinaria.dao;

import java.util.Collection;

import clinicaveterinaria.modelo.BeanCitas;




public interface Citas {
	
	public Collection obtenerFullpacientes(int cod) throws Exception;
	public abstract BeanCitas insertarcita(BeanCitas citas) throws Exception;

}
