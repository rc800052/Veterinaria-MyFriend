package clinicaveterinaria.negocio;

import java.util.Collection;

import clinicaveterinaria.dao.ClienteDAO;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cliente;

public class GestionClientes {

	public Collection<Cliente> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();
		return dao.buscarPorNombre(nombre);
	}
	
	public Cliente insertar(String nombre, String email, String direccion, String imagen, String telcasa, String telcelular, String notas )
			throws DAOExcepcion {
		
		
		validarDatosCliente(nombre, email, direccion, imagen, telcasa, telcelular,notas);

		
		ClienteDAO dao = new ClienteDAO();

		
		
		Cliente vo = new Cliente();
		vo.setNombre(nombre);
		vo.setEmail(email);
		vo.setDireccion(direccion);
		vo.setImagen(imagen);
		vo.setTelcasa(telcasa);
		vo.setTelcelular(telcelular);
		vo.setNotas(notas);

		
		return dao.insertar(vo);
	}

	public Cliente obtener(int idCliente) throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();
		return dao.obtener(idCliente);
	}

	//Comentario: Juan Botetano
	//Validar : No se puede eliminar un cliente si tiene pacientes
	public void eliminar(int idCliente) throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();
		dao.eliminar(idCliente);
	}


	
	
	public Cliente actualizar(int idCliente, String nombre, String email,String direccion, String imagen, String telcasa, String telcelular, String notas)
			 throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();

		Cliente vo = new Cliente();
		vo.setIdCliente(idCliente);
		vo.setNombre(nombre);
		vo.setEmail(email);
		vo.setDireccion(direccion);
		vo.setImagen(imagen);
		vo.setTelcasa(telcasa);
		vo.setTelcelular(telcelular);
		vo.setNotas(notas);

		
		return dao.actualizar(vo);
	}

	
	public Cliente actualizarNotas(int idCliente, String notas)
			 throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();

		Cliente vo = new Cliente();
		vo.setIdCliente(idCliente);
		vo.setNotas(notas);
		
		return dao.actualizarNotas(vo);
	}
	
	
	public Collection<Cliente> listar() throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();
		return dao.listar();
	}

	
    private void validarDatosCliente(String nombre, String email, String direccion, String imagen, String telcasa, String telcelular, String notas) throws DAOExcepcion {

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
	
	
}
