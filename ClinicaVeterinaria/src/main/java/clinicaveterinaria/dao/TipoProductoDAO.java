package clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.TipoProducto;
import clinicaveterinaria.util.ConexionBD;

public class TipoProductoDAO extends BaseDAO {

	public TipoProducto insertar(TipoProducto vo) throws DAOExcepcion {
		String query = "insert into tipoproducto (tipo) values (?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getTipo());
			
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
			vo.setIdTipo(id);

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
		
	public TipoProducto obtener(int IdTipo) throws DAOExcepcion {
		TipoProducto vo = new TipoProducto();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idTipo, tipo from tipoproducto where idTipo=?";
	
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdTipo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdTipo(rs.getInt(1));
				vo.setTipo(rs.getString(2));
				
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
	
	public void eliminar(int IdTipo) throws DAOExcepcion {
		String query = "delete from tipoproducto WHERE idTipo=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdTipo);
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
	
	public TipoProducto actualizar(TipoProducto vo) throws DAOExcepcion {
		String query = "update tipoproducto set tipo=? where idTipo=?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1,vo.getTipo());
			stmt.setInt(2, vo.getIdTipo());

			
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

	public Collection<TipoProducto> listar() throws DAOExcepcion {
		Collection<TipoProducto> c = new ArrayList<TipoProducto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select idTipo, tipo from tipoproducto order by idTipo";
		
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				TipoProducto vo = new TipoProducto();
				vo.setIdTipo(rs.getInt("idTipo"));
				vo.setTipo(rs.getString("tipo"));

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

	public Collection<TipoProducto> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select idTipo, tipo from tipoproducto; where tipo like ?";
		Collection<TipoProducto> lista = new ArrayList<TipoProducto>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				TipoProducto vo = new TipoProducto();
				vo.setIdTipo(rs.getInt("idTipo"));
				vo.setTipo(rs.getString("tipo"));
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

}
