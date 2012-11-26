package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import util.ConexionBD;
import dominio.Cliente;
import excepcion.DAOExcepcion;

public class ClienteDAO extends BaseDAO {

	public Collection<Cliente> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select * from cliente where nombre like ?";
		Collection<Cliente> lista = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente vo = new Cliente();
				vo.setIdCliente(rs.getInt("idCliente"));
				vo.setNombre(rs.getString("nombre"));
				vo.setEmail(rs.getString("email"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setTelcasa(rs.getString("telcasa"));
				vo.setTelcelular(rs.getString("telcelular"));
				vo.setImagen(rs.getString("imagen"));
				vo.setNotas(rs.getString("notas"));
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

	public Cliente insertarProspecto2Cliente(Cliente vo) throws DAOExcepcion {
		
		String query = "insert into cliente (nombre,email,direccion,imagen,telcasa,telcelular) values (?,?,?,?,?,?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getDireccion());
			stmt.setString(4, vo.getImagen());
			stmt.setString(5, vo.getTelcasa());
			stmt.setString(6, vo.getTelcelular());
			stmt.setInt(7, vo.getIdProspecto());
			
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
			vo.setIdCliente(id);

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
	
	public Cliente insertar(Cliente vo) throws DAOExcepcion {
		
		
		String query = "insert into cliente(nombre,email,direccion,imagen,telcasa,telcelular,notas) values (?,?,?,?,?,?,?)";
		validarDatosCliente(vo.getNombre(), vo.getEmail(), vo.getDireccion(), vo.getImagen(), vo.getTelcasa(), vo.getTelcelular(),vo.getNotas());
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getDireccion());
			stmt.setString(4, vo.getImagen());
			stmt.setString(5, vo.getTelcasa());
			stmt.setString(6, vo.getTelcelular());
			stmt.setString(7, vo.getNotas());

			
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
			vo.setIdCliente(id);

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

	
	public Cliente obtener(int idCliente) throws DAOExcepcion {
		Cliente vo = new Cliente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idCliente, nombre, email, direccion, imagen, telcasa, telcelular, notas from cliente where idCliente=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdCliente(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setEmail(rs.getString(3));
				vo.setDireccion(rs.getString(4));
				vo.setImagen(rs.getString(5));
				vo.setTelcasa(rs.getString(6));
				vo.setTelcelular(rs.getString(7));
				vo.setNotas(rs.getString(8));
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

	public void eliminar(int idCliente) throws DAOExcepcion {
		String query = "delete from cliente WHERE idcliente=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCliente);
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

	public Cliente actualizar(Cliente vo) throws DAOExcepcion {
		String query = "update cliente set nombre=?,email=?,direccion=?,imagen=?,telcasa=?,telcelular=?,notas=?   where idCliente=?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getDireccion());
			stmt.setString(4, vo.getImagen());
			stmt.setString(5, vo.getTelcasa());
			stmt.setString(6, vo.getTelcelular());
			stmt.setString(7, vo.getNotas());
			//stmt.setInt(8, vo.getIdProspecto());
			stmt.setInt(8, vo.getIdCliente());
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

	
	
	public Cliente actualizarNotas(Cliente vo) throws DAOExcepcion {
		String query = "update cliente set notas=? where idCliente=?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNotas());
			stmt.setInt(2, vo.getIdCliente());
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
	
	
	public Collection<Cliente> listar() throws DAOExcepcion {
		Collection<Cliente> c = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select idcliente, nombre, email, direccion, imagen, telcasa, telcelular, notas from cliente order by nombre";
		
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente vo = new Cliente();
				vo.setIdCliente(rs.getInt("idCliente"));
				vo.setNombre(rs.getString("nombre"));
				vo.setEmail(rs.getString("email"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setImagen(rs.getString("imagen"));
				vo.setTelcasa(rs.getString("telcasa"));
				vo.setTelcelular(rs.getString("telcelular"));
				vo.setImagen(rs.getString("imagen"));
				vo.setNotas(rs.getString("notas"));
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
