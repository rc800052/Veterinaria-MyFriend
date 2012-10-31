package clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Historia;
import clinicaveterinaria.util.ConexionBD;

public class HistoriaDAO extends BaseDAO {

	public Collection<Historia> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select cl.nombre,cl.email,cl.direccion,cl.telcelular from historia h, cita ci, cliente cl where h.Cita_idCita=ci.idCita and ci.Cliente_idCliente=cl.idCliente and nombre like ?";
		Collection<Historia> lista = new ArrayList<Historia>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Historia vo = new Historia();
				vo.setIdHistoria(rs.getInt("idHistoria"));
				vo.setNotaMedica(rs.getString("notaMedica"));
				vo.setImagenMedica(rs.getString("imagenMedica"));				
				vo.setCondicionEspecial(rs.getString("condicionEspecial"));				
				vo.setCita_idCita(rs.getInt("ci.idCita"));				
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

	public Historia insertar(Historia vo) throws DAOExcepcion {
		
		
		String query = "insert into historia(notaMedica,imagenMedica,condicionEspecial,idCita) values (?,?,?,?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNotaMedica());
			stmt.setString(2, vo.getImagenMedica());
			stmt.setString(3, vo.getCondicionEspecial());
			stmt.setInt(4, vo.getCita_idCita());
			
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
			vo.setIdHistoria(id);

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
	
	public Historia obtener(int idPaciente) throws DAOExcepcion {
		Historia vo = new Historia ();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select ci.idCita as Cita_idCita,hi.idCita,notaMedica,imagenMedica,condicionEspecial from cita ci, historia hi where ci.idCita=hi.idCita and ci.idPaciente=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPaciente);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setCita_idCita(rs.getInt(1));
//				vo.setNotaMedica(rs.getString(2));
//				vo.setImagenMedica(rs.getString(3));
//				vo.setCondicionEspecial(rs.getString(4));
//				vo.setCita_idCita(rs.getInt(5));

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

	public void eliminar(int idHistoria) throws DAOExcepcion {
		String query = "delete from Historia WHERE idHistoria=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idHistoria);
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

	public Collection<Historia> listar() throws DAOExcepcion {
		Collection<Historia> c = new ArrayList<Historia>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select * from historia";
//			String query = "SELECT * FROM clinicaveterinaria.historia order by notaMedica";
		
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Historia vo = new Historia();
				vo.setIdHistoria(rs.getInt("idHistoria"));
				vo.setNotaMedica(rs.getString("notaMedica"));
				vo.setImagenMedica(rs.getString("imagenMedica"));
				vo.setCondicionEspecial(rs.getString("condicionEspecial"));
				vo.setCita_idCita(rs.getInt("idCita"));
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
    
}
