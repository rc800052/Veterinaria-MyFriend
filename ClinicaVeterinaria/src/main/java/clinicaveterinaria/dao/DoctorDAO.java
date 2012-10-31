package clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.excepcion.LoginExcepcion;


import clinicaveterinaria.modelo.Doctor;
import clinicaveterinaria.util.ConexionBD;

public class DoctorDAO extends BaseDAO {

	public Collection<Doctor> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select * from doctor where nombre like ? order by idDoctor asc";
		Collection<Doctor> lista = new ArrayList<Doctor>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Doctor vo = new Doctor();
				vo.setIdDoctor(rs.getInt("idDoctor"));
				vo.setNombre(rs.getString("nombre"));
				vo.setApellido(rs.getString("apellido"));
				vo.setEmail(rs.getString("email"));
				vo.setTelefono(rs.getString("telefono"));
				vo.setUsuario(rs.getString("usuario"));
				vo.setClave(rs.getString("clave"));
				vo.setPerfil(rs.getString("perfil"));
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(lista.size());
		return lista;
	}

	public Doctor insertar(Doctor vo) throws DAOExcepcion {
		
		
		String query = "insert into doctor(nombre,apellido,email,telefono,usuario,clave,perfil) values (?,?,?,?,?,?,?)";
		//validarDatosDoctor(vo.getNombre(), vo.getApellido(), vo.getEmail(), vo.getTelefono(), vo.getUsuario(), vo.getClave(),vo.getPerfil());

		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getApellido());
			stmt.setString(3, vo.getEmail());
			stmt.setString(4, vo.getTelefono());
			stmt.setString(5, vo.getUsuario());
			stmt.setString(6, vo.getClave());
			stmt.setString(7, vo.getPerfil());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			vo.setIdDoctor(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
	
	public void insertarUsuario(String usuario) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT COUNT(*) FROM doctor where usuario =?";
		
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
			if (count > 0) {
				throw new SQLException("Usuario ya existe");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}
	
	
	public Doctor obtener(int idDoctor) throws DAOExcepcion {
		Doctor vo = new Doctor ();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idDoctor, nombre,apellido,email,telefono,usuario,clave,perfil from doctor where idDoctor=? order by idDoctor asc";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idDoctor);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdDoctor(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setApellido(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setTelefono(rs.getString(5));
				vo.setUsuario(rs.getString(6));
				vo.setClave(rs.getString(7));
				vo.setPerfil(rs.getString(8));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public void eliminar(int idDoctor) throws DAOExcepcion {
		String query = "delete from doctor WHERE idDoctor=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idDoctor);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Doctor actualizar(Doctor vo) throws DAOExcepcion {
		String query = "update doctor set nombre=?,apellido=?,email=?,telefono=?,usuario=?,clave=?,perfil=?  where idDoctor=?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getApellido());
			stmt.setString(3, vo.getEmail());
			stmt.setString(4, vo.getTelefono());
			stmt.setString(5, vo.getUsuario());
			stmt.setString(6, vo.getClave());
			stmt.setString(7, vo.getPerfil());
			stmt.setInt(8, vo.getIdDoctor());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	
	
	
	public Collection<Doctor> listar() throws DAOExcepcion {
		Collection<Doctor> c = new ArrayList<Doctor>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select idDoctor, nombre, apellido, email, telefono , usuario, clave, perfil from doctor order by idDoctor";
		
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Doctor vo = new Doctor();
				vo.setIdDoctor(rs.getInt("idDoctor"));
				vo.setNombre(rs.getString("nombre"));
				vo.setApellido(rs.getString("apellido"));
				vo.setEmail(rs.getString("email"));
				vo.setTelefono(rs.getString("telefono"));
				vo.setUsuario(rs.getString("usuario"));
				vo.setClave(rs.getString("clave"));
				vo.setPerfil(rs.getString("perfil"));
				c.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}

	//Comentario: Juan Botetano
	//Este validar DatosCliente me parece que va en la capa de negocio no en la capa de DAO
	
    @SuppressWarnings("unused")
	private void validarDatosDoctor(String nombre, String apellido, String email, String telefono, String usuario, String clave, String perfil) throws DAOExcepcion {

        String arg0 = "";

        if (nombre == null || nombre.isEmpty())
            arg0 = "- Nombre no puede ser vacio\n";
        if (apellido == null || apellido.isEmpty())
        	arg0 += "- Apellido no puede ser vacio\n";
        if (email== null || email.isEmpty())
        	arg0 += "- Emailno puede ser vacio\n";
        if (telefono== null || telefono.isEmpty())
        	arg0 += "- Telefono no puede ser vacio\n";
        if (usuario == null || usuario.isEmpty())
        	arg0 += "- Usuario no puede ser vacio\n";
        if (clave == null || clave.isEmpty())
        	arg0 += "- Clave de Usuario no puede ser vacio\n";
        if (perfil == null || perfil.isEmpty())
        	arg0 += "- Perfil de usuario no puede ser vacio\n";
       
        if (! arg0.isEmpty())
            throw new DAOExcepcion(arg0);


    }
  
    
    
	public Doctor validar(String idUsuario, String clave)
			throws DAOExcepcion, LoginExcepcion  {
		String query = "select nombre, apellido from doctor where usuario=? and clave=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Doctor vo = new Doctor();
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idUsuario);
			stmt.setString(2, clave);
			rs = stmt.executeQuery();

			if (rs.next()) {
				vo.setNombre(rs.getString("nombre"));
				vo.setApellido(rs.getString("apellido"));
				
			} else {
				throw new LoginExcepcion("No existe");
			}
		} catch (LoginExcepcion e) {
			System.err.println(e.getMessage());
			throw new LoginExcepcion(e.getMessage());
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
    
    
}
