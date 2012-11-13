package clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.modelo.Paciente;
import clinicaveterinaria.util.ConexionBD;




public class PacienteDAO extends BaseDAO {
	
	//Lista todas las mascotas segun su nombre, puede darse el caso que tenga mas 
	//de un registro
	
	public Collection<Paciente> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select * from paciente where nombre like ?";
		Collection<Paciente> lista = new ArrayList<Paciente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				Paciente vo = new Paciente();
				
				vo.setIdPaciente(rs.getInt("idPaciente"));
				vo.setNombre(rs.getString("nombre"));
				vo.setEsterelizado(rs.getString("esterilizado"));
				vo.setTamano(rs.getString("tamano"));
				vo.setActividad(rs.getString("actividad"));
				vo.setPeso(rs.getDouble("peso"));
				vo.setFchnac(rs.getString("fchnac"));
				vo.setEspecie(rs.getString("especie"));
				vo.setRaza(rs.getString("raza"));
				vo.setGenero(rs.getString("genero"));
				vo.setTiposangre(rs.getString("tiposangre"));
				
				ClienteDAO dao = new ClienteDAO();
				Cliente co=dao.obtener(rs.getInt("idCliente"));
			
				
				vo.setOcliente(co);

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
	
	
	//Esta busqueda es para enlazarlo con la Clase Clientes
	//busca segun el id del cliente o due�o
	
	public Collection<Paciente> buscarPorIdCliente(int IdCliente)
			throws DAOExcepcion {
		String query = "select idPaciente, nombre, esterilizado, tama�o, actividad, peso, fchnac, especie, raza, genero, tiposangre, idCliente from paciente where idCliente=?";
		Collection<Paciente> lista = new ArrayList<Paciente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdCliente);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Paciente vo = new Paciente();
				
				vo.setIdPaciente(rs.getInt("idPaciente"));
				vo.setNombre(rs.getString("nombre"));
				vo.setEsterelizado(rs.getString("esterilizado"));
				vo.setTamano(rs.getString("tamano"));
				vo.setActividad(rs.getString("actividad"));
				vo.setPeso(rs.getDouble("peso"));
				vo.setFchnac(rs.getString("fchnac"));
				vo.setEspecie(rs.getString("especie"));
				vo.setRaza(rs.getString("raza"));
				vo.setGenero(rs.getString("genero"));
				vo.setTiposangre(rs.getString("tiposangre"));
				
			
				ClienteDAO dao = new ClienteDAO();
				Cliente co=dao.obtener(rs.getInt("idCliente"));
				vo.setOcliente(co);
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
		//System.out.println(lista.size());
		return lista;
	}
	
	
	//Lista general de todos los pacientes sin ningun criterio de busqueda
	
	
	
	//Obtiene un paciente o mascota de acuerdo al campo
	//idPaciente, ya que es llave unica no necesita de la llave de Cliente
	
	public Paciente obtener(int idPaciente) throws DAOExcepcion {
		Paciente vo = new Paciente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idPaciente, nombre, esterilizado, tama�o, actividad, peso, fchnac, especie, raza, genero, tiposangre, idCliente from paciente where idPaciente=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPaciente);
			rs = stmt.executeQuery();
			if (rs.next()) {		
				
				vo.setIdPaciente(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setEsterelizado(rs.getString(3));
				vo.setTamano(rs.getString(4));
				vo.setActividad(rs.getString(5));
				vo.setPeso(rs.getDouble(6));
				vo.setFchnac(rs.getString(7));
				vo.setEspecie(rs.getString(8));
				vo.setRaza(rs.getString(9));
				vo.setGenero(rs.getString(10));
				vo.setTiposangre(rs.getString(11));
		
			ClienteDAO dao = new ClienteDAO();
				Cliente co=dao.obtener(rs.getInt("idCliente"));
				vo.setOcliente(co);
		
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
	
	
	//Insertar Paciente
	
	public Paciente insertar(Paciente vo) throws DAOExcepcion {

		String query = "insert into paciente(nombre, esterilizado, tama�o, actividad, peso, fchnac, especie, raza, genero, tiposangre, idCliente) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1,vo.getNombre());
			stmt.setString(2,vo.getEsterelizado());
			stmt.setString(3,vo.getTamano());
			stmt.setString(4, vo.getActividad());
			stmt.setDouble(5, vo.getPeso());
			stmt.setString(6,vo.getFchnac());
			stmt.setString(7, vo.getEspecie());
			stmt.setString(8, vo.getRaza());
			stmt.setString(9, vo.getGenero());
			stmt.setString(10, vo.getTiposangre());		
			stmt.setInt(11, vo.getOcliente().getIdCliente());
				
		
			
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
			vo.setIdPaciente(id);

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
	
	
	//Eliminar Paciente
	public void eliminar(int idPaciente) throws DAOExcepcion {
		String query = "delete from paciente WHERE idPaciente=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPaciente);
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
	
	public Collection<Paciente> listar() throws DAOExcepcion {
		
		Collection<Paciente> c = new ArrayList<Paciente>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
					
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select idPaciente, nombre, esterilizado, tama�o, actividad, peso, fchnac, especie,raza,genero,tiposangre from paciente order by nombre";
			
			
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Paciente vo = new Paciente();
				
				vo.setIdPaciente(rs.getInt("idPaciente"));
				
				vo.setNombre(rs.getString("nombre"));
				
			vo.setEsterelizado(rs.getString("esterilizado"));
				
				vo.setTamano(rs.getString("tamano"));
				vo.setActividad(rs.getString("actividad"));
				vo.setPeso(rs.getDouble("peso"));
				vo.setFchnac(rs.getString("fchnac"));
				vo.setEspecie(rs.getString("especie"));
				vo.setRaza(rs.getString("raza"));
				vo.setGenero(rs.getString("genero"));
				vo.setTiposangre(rs.getString("tiposangre"));
				
				
				ClienteDAO dao = new ClienteDAO();
				Cliente co=dao.obtener(rs.getInt("idCliente"));
				vo.setOcliente(co);
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
	

	//Actualizar Paciente
	public Paciente actualizar(Paciente vo) throws DAOExcepcion {
		String query = "update paciente set nombre=?, esterilizado=?, tama�o=?, actividad=?, peso=?, fchnac=?, especie=?, raza=?, genero=?, tiposangre=?, idCliente=? where idPaciente=?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getEsterelizado());
			stmt.setString(3, vo.getTamano());
			stmt.setString(4, vo.getActividad());
			stmt.setDouble(5, vo.getPeso());
			stmt.setString(6, vo.getFchnac());
			stmt.setString(7, vo.getEspecie());
			stmt.setString(8, vo.getRaza());
			stmt.setString(9, vo.getGenero());
			stmt.setString(10, vo.getTiposangre());	
			stmt.setInt(11, vo.getOcliente().getIdCliente());
			
			stmt.setInt(12, vo.getIdPaciente());
			
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
	
}
