package clinicaveterinaria.negocio;

import java.util.Collection;
import clinicaveterinaria.dao.HistoriaDAO;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Historia;

public class GestionHistoria {

	public Collection<Historia> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		HistoriaDAO dao = new HistoriaDAO();
		return dao.buscarPorNombre(nombre);
	}
	
	public Historia insertar(String notaMedica, String imagenMedica, String condicionEspecial, int Cita_idCita)
			throws DAOExcepcion {
				
	
		HistoriaDAO dao = new HistoriaDAO();
			
		Historia vo = new Historia();
		vo.setNotaMedica(notaMedica);
		vo.setImagenMedica(imagenMedica);
		vo.setCondicionEspecial(condicionEspecial);
		vo.setCita_idCita(Cita_idCita);
		
		return dao.insertar(vo);
	}
	public Collection<Historia> listar() throws DAOExcepcion {
		HistoriaDAO dao = new HistoriaDAO();
		return dao.listar();
	}
	public Historia obtener(int idHistoria) throws DAOExcepcion {
		HistoriaDAO dao = new HistoriaDAO();
		return dao.obtener(idHistoria);
	}

	public void eliminar(int idHistoria) throws DAOExcepcion {
		HistoriaDAO dao = new HistoriaDAO();
		dao.eliminar(idHistoria);
	}	
}
