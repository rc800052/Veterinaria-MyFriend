package clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Prospecto;
import clinicaveterinaria.util.ConexionBD;

public class ProspectoDAO extends BaseDAO {

	public Collection<Prospecto> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select * from prospecto where nombre like ?";
		Collection<Prospecto> lista = new ArrayList<Prospecto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				Prospecto vo = new Prospecto();
				vo.setIdProspecto(rs.getInt("idprospecto"));
				vo.setNombre(rs.getString("nombre"));
				vo.setEmail(rs.getString("email"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setTelcasa(rs.getString("telcasa"));
				vo.setTelcelular(rs.getString("telcelular"));
				vo.setImagen(rs.getString("imagen"));
				vo.setCliente(rs.getString("cliente"));
						
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

	public Prospecto insertar(Prospecto vo) throws DAOExcepcion {
		String query = "insert into Prospecto(nombre,email,direccion,imagen,telcasa,telcelular,cliente) values (?,?,?,?,?,?,?)";
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
			stmt.setString(7, vo.getCliente());
			
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
			vo.setIdProspecto(id);

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

	public Prospecto obtener(int idProspecto) throws DAOExcepcion {
		Prospecto vo = new Prospecto();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idProspecto, nombre, email, direccion, imagen, telcasa, telcelular, cliente from Prospecto where idProspecto=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idProspecto);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdProspecto(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setEmail(rs.getString(3));
				vo.setDireccion(rs.getString(4));
				vo.setImagen(rs.getString(5));
				vo.setTelcasa(rs.getString(6));
				vo.setTelcelular(rs.getString(7));
				vo.setCliente(rs.getString(8));
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

	public void eliminar(int idProspecto) throws DAOExcepcion {
		String query = "delete from Prospecto WHERE idProspecto=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idProspecto);
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

	public Prospecto actualizar(Prospecto vo) throws DAOExcepcion {
		String query = "update Prospecto set nombre=?,email=?,direccion=?,imagen=?,telcasa=?,telcelular=?,cliente=? where idProspecto=?";
		
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
			stmt.setString(7, vo.getCliente());
			
			
			//vo.setCliente(rs.getBoolean(8));
			
			stmt.setInt(8, vo.getIdProspecto());
			
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

	public Collection<Prospecto> listar() throws DAOExcepcion {
		Collection<Prospecto> c = new ArrayList<Prospecto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select idProspecto, nombre, email, direccion, imagen, telcasa, telcelular, cliente from Prospecto order by nombre";
		
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Prospecto vo = new Prospecto();
				vo.setIdProspecto(rs.getInt("idProspecto"));
				vo.setNombre(rs.getString("nombre"));
				vo.setEmail(rs.getString("email"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setImagen(rs.getString("imagen"));
				vo.setTelcasa(rs.getString("telcasa"));
				vo.setTelcelular(rs.getString("telcelular"));
				vo.setCliente(rs.getString("cliente"));
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

	public void cambiar2Cliente (int idProspecto) throws DAOExcepcion {
		String query = "update Prospecto set cliente=1 where idProspecto=?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idProspecto);
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se Puede cambiar a Cliente");
			}
		} 
		
		catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}
	
}