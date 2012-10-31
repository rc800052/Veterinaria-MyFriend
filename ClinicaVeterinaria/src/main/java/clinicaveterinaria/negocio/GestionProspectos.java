package clinicaveterinaria.negocio;

import java.util.Collection;

import clinicaveterinaria.dao.ClienteDAO;
import clinicaveterinaria.dao.ProspectoDAO;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Prospecto;
import clinicaveterinaria.modelo.Cliente;

public class GestionProspectos {

	public Collection<Prospecto> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		ProspectoDAO dao = new ProspectoDAO();
		return dao.buscarPorNombre(nombre);
	}
	
	public Prospecto insertar(String nombre, String email, String direccion, String imagen, String telcasa, String telcelular, String cliente )
			throws DAOExcepcion {

		validarDatosProspecto(nombre, email, direccion, imagen, telcasa, telcelular);
		
		ProspectoDAO dao = new ProspectoDAO();

		Prospecto vo = new Prospecto();
		vo.setNombre(nombre);
		vo.setEmail(email);
		vo.setDireccion(direccion);
		vo.setImagen(imagen);
		vo.setTelcasa(telcasa);
		vo.setTelcelular(telcelular);
		vo.setCliente(cliente);
		return dao.insertar(vo);
	}

	public Prospecto obtener(int idProspecto) throws DAOExcepcion {
		ProspectoDAO dao = new ProspectoDAO();
		return dao.obtener(idProspecto);
	}

	public void eliminar(int idProspecto) throws DAOExcepcion {
		ProspectoDAO dao = new ProspectoDAO();
		dao.eliminar(idProspecto);
	}

	public Prospecto actualizar(int idProspecto, String nombre, String email, String direccion, String imagen, String telcasa, String telcelular, String cliente)
			 throws DAOExcepcion {
		ProspectoDAO dao = new ProspectoDAO();

		Prospecto vo = new Prospecto();
		vo.setIdProspecto(idProspecto);
		vo.setNombre(nombre);
		vo.setEmail(email);
		vo.setDireccion(direccion);
		vo.setImagen(imagen);
		vo.setTelcasa(telcasa);
		vo.setTelcelular(telcelular);
		vo.setCliente(cliente);
		return dao.actualizar(vo);
	}

	public Collection<Prospecto> listar() throws DAOExcepcion {
		ProspectoDAO dao = new ProspectoDAO();
		return dao.listar();
	}

	public void cambiar2cliente(int idProspecto) throws DAOExcepcion {
		ProspectoDAO daoProspecto = new ProspectoDAO();
        ClienteDAO daoCliente = new ClienteDAO();
        
		daoProspecto.cambiar2Cliente(idProspecto);
		Prospecto oProspecto = new Prospecto(); 
		oProspecto = daoProspecto.obtener(idProspecto);
		
		Cliente oCliente = new Cliente();
		oCliente.setNombre(oProspecto.getNombre());
		oCliente.setEmail(oProspecto.getEmail());
		oCliente.setDireccion(oProspecto.getDireccion());
		oCliente.setImagen(oProspecto.getImagen());
		oCliente.setTelcasa(oProspecto.getTelcasa());
		oCliente.setTelcelular(oProspecto.getTelcelular());
		oCliente.setIdProspecto(oProspecto.getIdProspecto());

		daoCliente.insertarProspecto2Cliente(oCliente);
	}

    private void validarDatosProspecto(String nombre, String email, String direccion, String imagen, String telcasa, String telcelular) throws DAOExcepcion {

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