package clinicaveterinaria.negocio;

import java.util.Collection;

import clinicaveterinaria.dao.PacienteDAO;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.modelo.Paciente;

public class GestionPacientes {
	
	public Collection<Paciente> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		PacienteDAO dao = new PacienteDAO();
		return dao.buscarPorNombre(nombre);
	}
	
	public Collection<Paciente> buscarPorIdCliente(int IdCliente) 
			throws DAOExcepcion{
		PacienteDAO dao = new PacienteDAO();
		return dao.buscarPorIdCliente(IdCliente);
	}
	
	
	public Paciente insertarpaciente(String nombre, String esterelizado, String tamano, String actividad, 
			double peso, String fchnac, String especie, String raza, String genero, 
			String tiposangre, Cliente idCliente)
	throws DAOExcepcion {


validarDatosPaciente(nombre, esterelizado, tamano, actividad, peso, fchnac, especie, raza, genero, tiposangre);

PacienteDAO dao = new PacienteDAO();

Paciente vo = new Paciente();	
vo.setNombre(nombre);
vo.setEsterelizado(esterelizado);
vo.setTamano(tamano);
vo.setActividad(actividad);
vo.setPeso(peso);
vo.setFchnac(fchnac);
vo.setEspecie(especie);
vo.setRaza(raza);
vo.setGenero(genero);
vo.setTiposangre(tiposangre);
vo.setOcliente(idCliente);


return dao.insertar(vo);
}
	
	
	
	/*

	public Paciente insertar(String nombre, String esterelizado, String tama�o, String actividad, 
					double peso, String fchnac, String especie, String raza, String genero, 
					String tiposangre, int idCliente )
			throws DAOExcepcion {
		
		
		validarDatosPaciente(nombre, esterelizado, tama�o, actividad, peso, fchnac, especie, raza, genero, tiposangre);
	
		PacienteDAO dao = new PacienteDAO();

		Paciente vo = new Paciente();	
		vo.setNombre(nombre);
		vo.setEsterelizado(esterelizado);
		vo.setTama�o(tama�o);
		vo.setActividad(actividad);
		vo.setPeso(peso);
		vo.setFchnac(fchnac);
		vo.setEspecie(especie);
		vo.setRaza(raza);
		vo.setGenero(genero);
		vo.setTiposangre(tiposangre);
		vo.setIdCliente(idCliente);
		
		
		return dao.insertar(vo);
	}
	
	*/
	
	
	public Paciente obtener(int idPaciente) throws DAOExcepcion {
		PacienteDAO dao = new PacienteDAO();
		return dao.obtener(idPaciente);
	}
	
	public void eliminar(int idPaciente) throws DAOExcepcion {
		PacienteDAO dao = new PacienteDAO();
		dao.eliminar(idPaciente);
	}
	
	public Paciente actualizar(int idPaciente, String nombre, String esterelizado, String tamano, String actividad, 
			double peso, String fchnac, String especie, String raza, String genero, String tiposangre, Cliente idCliente)
			 throws DAOExcepcion {
		
		PacienteDAO dao = new PacienteDAO();

		Paciente vo = new Paciente();
		
		vo.setIdPaciente(idPaciente);
		vo.setNombre(nombre);
		vo.setEsterelizado(esterelizado);
		vo.setTamano(tamano);
		vo.setActividad(actividad);
		vo.setPeso(peso);
		vo.setFchnac(fchnac);
		vo.setEspecie(especie);
		vo.setRaza(raza);
		vo.setGenero(genero);
		vo.setTiposangre(tiposangre);
		vo.setOcliente(idCliente);
		return dao.actualizar(vo);
	}
	
	
	public Collection<Paciente> listar() throws DAOExcepcion {
		PacienteDAO dao = new PacienteDAO();
		return dao.listar();
	}
	
	
    private void validarDatosPaciente(String nombre, String esterelizado, String tamano, String actividad, 
			double peso, String fchnac, String especie, String raza, String genero, String tiposangre) 
		throws DAOExcepcion {

        String arg0 = "";

        if (nombre == null || nombre.isEmpty())
            arg0 = "- Nombre no puede ser vacio\n";
        if (esterelizado == null || esterelizado.isEmpty())
        	arg0 += "- El campo Esterilizado no puede ser vacio\n";
        if (tamano == null || tamano.isEmpty())
        	arg0 += "- El tama�o no puede ser vacio\n";
        if (actividad == null || actividad.isEmpty())
        	arg0 += "- El campo actividad no puede ser vacio\n";
        if (peso == 0 )
        	arg0 += "- El peso del paciente no puede ser vacio\n";
        if (fchnac== null)
        	arg0 += "- La fecha de nacimiento no puede ser vacio\n";
        if (especie == null || especie.isEmpty())
        	arg0 += "- El campo especie no puede ser vacio\n";
        if (raza == null || raza.isEmpty())
        	arg0 += "- El campo raza no puede ser vacio\n";
        if (genero == null || genero.isEmpty())
        	arg0 += "- El campo genero no puede ser vacio\n";
        if (genero == null || genero.isEmpty())
        	arg0 += "- El campo genero no puede ser vacio\n";        
        if (tiposangre== null || tiposangre.isEmpty())
        	arg0 += "- El campo tipo de sangre no puede ser vacio\n";
       
        if (! arg0.isEmpty())
            throw new DAOExcepcion(arg0);


    }
	
}
