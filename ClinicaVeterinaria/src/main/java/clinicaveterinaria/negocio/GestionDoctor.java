package clinicaveterinaria.negocio;

import java.util.Collection;
import clinicaveterinaria.dao.DoctorDAO;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.excepcion.LoginExcepcion;


import clinicaveterinaria.modelo.Doctor;

public class GestionDoctor {

	public Doctor validarUsuario(String usuario, String clave)
			throws DAOExcepcion, LoginExcepcion {
		DoctorDAO dao = new DoctorDAO();
		return dao.validar(usuario, clave);
	}

	
	public Collection<Doctor> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		return dao.buscarPorNombre(nombre);
	}
	
	public Doctor insertar(String nombre, String apellido, String email, String telefono, String usuario, String clave, String perfil)
			throws DAOExcepcion {
				
		//validarDatosDoctor(nombre, apellido, email, telefono, usuario, clave, perfil);
		
		DoctorDAO dao = new DoctorDAO();
			
		Doctor vo = new Doctor();
		vo.setNombre(nombre);
		vo.setApellido(apellido);
		vo.setEmail(email);
		vo.setTelefono(telefono);
		vo.setUsuario(usuario);
		vo.setClave(clave);
		vo.setPerfil(perfil);
		
		
		return dao.insertar(vo);
	}
	

	public Doctor obtener(int idDoctor) throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		return dao.obtener(idDoctor);
	}

	//Comentario: Juan Botetano
	//Validar : No se puede eliminar un Doctor si tiene pacientes
	public void eliminar(int idDoctor) throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		dao.eliminar(idDoctor);
	}
	public void insertarUsuario(String usuario) throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		dao.insertarUsuario(usuario);
	}

	public Doctor actualizar(int idDoctor, String nombre, String apellido ,String email,String telefono, String usuario, String clave, String perfil)
			 throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();

		Doctor vo = new Doctor();
		vo.setIdDoctor(idDoctor);		
		vo.setNombre(nombre);
		vo.setApellido(apellido);
		vo.setEmail(email);
		vo.setTelefono(telefono);
		vo.setUsuario(usuario);
		vo.setClave(clave);
		vo.setPerfil(perfil);
		
		return dao.actualizar(vo);
	}


	
	public Collection<Doctor> listar() throws DAOExcepcion {
		DoctorDAO dao = new DoctorDAO();
		return dao.listar();
	}

	/*
    private void validarDatosDoctor(String nombre, String email, String direccion, String imagen, String telcasa, String telcelular, String notas) throws DAOExcepcion {

        String arg0 = "";

        if (nombre == null || nombre.isEmpty())
            arg0 = "- Nombre no puede ser vacio\n";
        if (email == null || email.isEmpty())
        	arg0 += "- Email no puede ser vacio\n";
        if (direccion == null || direccion.isEmpty())
        	arg0 += "- Direccion no puede ser vacio\n";
        if (imagen == null || imagen.isEmpty())
        	arg0 += "- Imagen no puede ser vacio\n";
        if (telcasa == null || telcasa.isEmpty())
        	arg0 += "- Telefono de Usuario no puede ser vacio\n";
        if (telcelular== null || telcelular.isEmpty())
        	arg0 += "- Celular de usuario no puede ser vacio\n";
       
        if (! arg0.isEmpty())
            throw new DAOExcepcion(arg0);


    }
	
*/	
}
