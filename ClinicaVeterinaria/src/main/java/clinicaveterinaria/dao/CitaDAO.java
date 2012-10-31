package clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Calendario;
import clinicaveterinaria.modelo.Cita;
import clinicaveterinaria.modelo.CitaCabDet;
import clinicaveterinaria.modelo.CitaDetalle;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.modelo.Doctor;
import clinicaveterinaria.modelo.Paciente;
import clinicaveterinaria.negocio.GestionClientes;
import clinicaveterinaria.negocio.GestionDoctor;
import clinicaveterinaria.negocio.GestionPacientes;
import clinicaveterinaria.util.ConexionBD;

public class CitaDAO extends BaseDAO {
	
	public CitaDetalle insertarCitaDetalle(CitaDetalle vo) throws DAOExcepcion {

		String query = "insert into citadetalle (cantidad,precio,idCita,idProducto) values (?,?,?,?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDouble(1, vo.getCantidad());
			stmt.setDouble(2, vo.getPrecio());
			stmt.setInt(3, vo.getIdCita());
			stmt.setInt(4, vo.getoProducto().getIdProducto());
			
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
			vo.setIdCitaDet(id);

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
	
	public Cita insertar(Cita vo) throws DAOExcepcion {
		
		String query = "insert into cita (descripcion,telefono,direccion,fchcita,estado,idDoctor,idPaciente,idCliente) values (?,?,?,?,?,?,?,?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDescripcion());
			stmt.setString(2, vo.getTelefono());
			stmt.setString(3, vo.getDireccion());
			stmt.setDate(4, vo.getFchcita());
			stmt.setString(5, vo.getEstado());
			stmt.setInt(6, vo.getoDoctor().getIdDoctor()); 
			stmt.setInt(7, vo.getoPaciente().getIdPaciente());
			stmt.setInt(8, vo.getoCliente().getIdCliente());
			
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
			vo.setIdCita(id);

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

	public Cita obtener(int idCita) throws DAOExcepcion {
		Cita vo = new Cita();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select idCita, descripcion, telefono, direccion, fchcita, estado, idDoctor, idPaciente, idCliente from cita where idCita = ?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCita);
			rs = stmt.executeQuery();
			if (rs.next()) {
				
				GestionDoctor oGesDoctor = new GestionDoctor();
				Doctor oDoctor = oGesDoctor.obtener(rs.getInt(7));
				
				GestionPacientes oGesPaciente = new GestionPacientes();
				Paciente oPaciente = oGesPaciente.obtener(rs.getInt(8));
				
				GestionClientes oGesCliente = new GestionClientes();
				Cliente oCliente = oGesCliente.obtener(rs.getInt(9));

				vo.setIdCita(rs.getInt(1));
				vo.setDescripcion(rs.getString(2));
				vo.setTelefono(rs.getString(3));
				vo.setDireccion(rs.getString(4));
				vo.setFchcita(rs.getDate(5));
				vo.setEstado(rs.getString(6));
				vo.setoDoctor(oDoctor);
				vo.setoPaciente(oPaciente);
				vo.setoCliente(oCliente);
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
	
	public Cita actualizar(Cita vo) throws DAOExcepcion {
		String query = "update cita set descripcion=?,telefono=?,direccion=?,fchcita=?,estado='P',idDoctor=?,idPaciente=?,idCliente=? where idCita=?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDescripcion());
			stmt.setString(2, vo.getTelefono());
			stmt.setString(3, vo.getDireccion());
			stmt.setDate(4, vo.getFchcita());
			stmt.setInt(5, vo.getoDoctor().getIdDoctor());
			stmt.setInt(6, vo.getoPaciente().getIdPaciente());
			stmt.setInt(7, vo.getoCliente().getIdCliente());
			stmt.setInt(8, vo.getIdCita());
			
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
	
	public void anularCita(int idCita) throws DAOExcepcion {
		String query = "update cita set estado='A' where idCita=?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCita);
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo Anular la Cita");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Collection<Cita> buscarCitasPendientesPorCliente(int IdCliente)
			throws DAOExcepcion {
		String query = "select cita.fchcita, cita.descripcion, doctor.nombre as nombre_doctor, doctor.apellido as apellido_doctor, " +
		"paciente.especie as especie_paciente, paciente.nombre as nombre_paciente " +
	    "from cita left join doctor on cita.idDoctor = doctor.idDoctor " +
		"left join paciente on cita.idPaciente = paciente.idPaciente " +
		"where cita.estado='P' and cita.idCliente = ? order by cita.fchcita";
		
		Collection<Cita> lista = new ArrayList<Cita>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdCliente);
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				Doctor d = new Doctor();
				d.setNombre(rs.getString("nombre_doctor"));
				d.setApellido(rs.getString("apellido_doctor"));
				
				Paciente p = new Paciente();
				p.setEspecie(rs.getString("especie_paciente"));
				p.setNombre(rs.getString("nombre_paciente"));
				
				Cita vo = new Cita();
				vo.setFchcita(rs.getDate("fchcita"));
				vo.setDescripcion(rs.getString("descripcion"));
				vo.setoDoctor(d);
				vo.setoPaciente(p);
			
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
		return lista;
	}

	public Collection<CitaCabDet> listarCitasxFacturarCliente(int IdCliente)
			throws DAOExcepcion {
		String query = "select " +
				"c.idcita," +
				"c.descripcion," +
				"c.telefono," +
				"c.direccion," +
				"c.fchcita," +
				"d.estado," +
				"c.iddoctor," +
				"c.idpaciente," +
				"c.idcliente," +
				"d.idcitadet," +
				"d.idproducto," +
				"p.producto," +
				"t.tipo," +
				"d.cantidad," +
				"d.precio " +
				"from cita c, citadetalle d, producto p, tipoproducto t where " +
				"c.idcita = d.idcita and " +
				"d.idproducto = p.idproducto and " +
				"p.idtipo = t.idtipo and " +
				"d.estado='P' and " +
				"c.idCliente = ? " +
				"order by c.fchcita";

		Collection<CitaCabDet> lista = new ArrayList<CitaCabDet>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, IdCliente);
			rs = stmt.executeQuery();
			while (rs.next()) {

				CitaCabDet vo = new CitaCabDet();
				vo.setIdCita(rs.getInt("idCita"));
				vo.setDescripcion(rs.getString("descripcion"));
				vo.setEstado(rs.getString("telefono"));
				vo.setEstado(rs.getString("direccion"));
				vo.setFchcita(rs.getDate("fchcita"));
				vo.setEstado(rs.getString("estado"));
				vo.setIdDoctor(rs.getInt("iddoctor"));
				vo.setIdPaciente(rs.getInt("idpaciente"));
				vo.setIdCliente(rs.getInt("idcliente"));
				vo.setIdCitaDet(rs.getInt("idcitadet"));
				vo.setIdProducto(rs.getInt("idproducto"));
				vo.setProducto(rs.getString("producto"));
				vo.setTipo(rs.getString("tipo"));
				vo.setCantidad(rs.getDouble("cantidad"));
				vo.setPrecio(rs.getDouble("precio"));
			
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
		return lista;
	}

	public Collection<Calendario> listarCalendario(int tipo, Date fchini, Date fchfin)
			throws DAOExcepcion {
		
		String query = "select " +
				"cita.*," +
				"paciente.*," +
				"doctor.*," +
				"citadetalle.*," +
				"producto.* " +
				"from cita " +
				"left join paciente on cita.idpaciente = paciente.idpaciente " +
				"left join cliente on cita.idcliente = cliente.idcliente " +
				"left join doctor on cita.iddoctor = doctor.iddoctor " +
				"left join citadetalle on cita.idcita = citadetalle.idcita " +
				"left join producto on citadetalle.idproducto = producto.idproducto " +
				"left join tipoproducto on producto.idtipo = tipoproducto.idtipo " +
				"where tipoproducto.idtipo = ? " +
				"and fchcita >= ? " +
				"and fchcita <= ?";

		Collection<Calendario> lista = new ArrayList<Calendario>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, tipo);
			stmt.setDate(2, fchini);
			stmt.setDate(3, fchfin);
			
			rs = stmt.executeQuery();
			while (rs.next()) {

				Calendario vo = new Calendario();
				vo.setIdCita(rs.getInt("idCita"));
				vo.setFchcita(rs.getDate("fchcita"));
				vo.setIdCliente(rs.getInt("idcliente"));
				vo.setIdDoctor(rs.getInt("iddoctor"));
				vo.setIdPaciente(rs.getInt("idpaciente"));
				vo.setIdProducto(rs.getInt("idproducto"));
				vo.setNombre_cliente(rs.getString("nombre_cliente"));
				vo.setNombre_doctor(rs.getString("nombre_doctor"));
				vo.setNombre_paciente(rs.getString("nombre_paciente"));
				vo.setProducto(rs.getString("producto"));

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
		return lista;
	}

}

