package clinicaveterinaria.dao;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.Factura;
import clinicaveterinaria.modelo.Cliente;
import clinicaveterinaria.util.ConexionBD;

public class FacturaDAO extends BaseDAO {

	public Collection<Factura> buscarPorFecha(Date fch_FacturaDesde, Date fch_FacturaHasta)
			throws DAOExcepcion {
		String query = "select Factura.idFactura, Factura.fch_Factura, Factura.serie, Factura.numero, Factura.moneda, Factura.tc, Cliente.nombre from factura,cliente where factura.idCliente = Cliente.idCliente and Factura.fch_Factura>= ? and Factura.fch_Factura < ?";
		Collection<Factura> lista = new ArrayList<Factura>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDate(1,fch_FacturaDesde);
			stmt.setDate(2,fch_FacturaHasta);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Factura fact = new Factura();
				fact.setIdFactura(rs.getInt(1));
				fact.setFch_Factura(rs.getDate(2));
				fact.setSerie(rs.getString(3));
				fact.setNumero(rs.getString(4));
				fact.setMoneda(rs.getString(5));
				fact.setTc(rs.getDouble(6));
				fact.setClienteNombre(rs.getString(7));
				lista.add(fact);
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
	
public Factura insertar(Factura fact,Cliente clie) throws DAOExcepcion {
		String query = "insert into Factura(fch_Factura,serie,numero,fch_Emision,moneda,tc,idCliente) values (?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDate(1,fact.getFch_Factura());
			stmt.setString(2,fact.getSerie());
			stmt.setString(3,fact.getNumero());
			stmt.setDate(4,fact.getFch_Emision());
			stmt.setString(5,fact.getMoneda());
			stmt.setDouble(6,fact.getTc());
			
			clie = fact.getoCliente();
			stmt.setInt(7,clie.getIdCliente());
			
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
			fact.setIdFactura(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return fact;
	}


	public Factura obtener(int idFactura) throws DAOExcepcion {
		Factura fact = new Factura();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select Factura.idFactura, Factura.fch_Factura, Factura.serie, Factura.numero, Factura.moneda, Factura.tc, Cliente.nombre from factura,cliente where factura.idCliente = Cliente.idCliente and Factura.idFactura=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idFactura);
			rs = stmt.executeQuery();
			if (rs.next()) {
				fact.setIdFactura(rs.getInt(1));
				fact.setFch_Factura(rs.getDate(2));
				fact.setSerie(rs.getString(3));
				fact.setNumero(rs.getString(4));
				fact.setMoneda(rs.getString(5));
				fact.setTc(rs.getDouble(6));
				fact.setClienteNombre(rs.getString(7));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return fact;
	}

	public void eliminar(int idFactura) throws DAOExcepcion {
		String query = "delete from Factura WHERE idFactura=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idFactura);
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
	
	public int obtenerUltimo() throws DAOExcepcion {
		
		String query = "";
		int id = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			query = "select max(idFactura) from factura";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
		
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		
		return id;
	}
	

	public Factura actualizar(Factura fact) throws DAOExcepcion {
		String query = "update factura set fch_Factura=?,serie=?,numero=?,fch_Emision=?,moneda=?,tc=?,idCliente=? where idFactura=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDate(1, fact.getFch_Factura());
			stmt.setString(2, fact.getSerie());
			stmt.setString(3, fact.getNumero());
			stmt.setDate(4, fact.getFch_Emision());
			stmt.setString(5, fact.getMoneda());
			stmt.setDouble(6, fact.getTc());
			stmt.setInt(7, fact.getIdCliente());
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
		return fact;
	}

	
	public Collection<Factura> listar_x_cliente(int idCliente) throws DAOExcepcion {
		Collection<Factura> f = new ArrayList<Factura>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select factura.idFactura,factura.fch_Factura,factura.serie,factura.numero,factura.moneda,factura.tc,cliente.nombre from factura,cliente where factura.idCliente = Cliente.idCliente and factura.idCliente = ? order by factura.idFactura";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Factura fact = new Factura();
				Cliente clie= new Cliente();
				
				fact.setIdFactura(rs.getInt("factura.idFactura"));
				fact.setFch_Factura(rs.getDate("factura.fch_Factura"));
				fact.setSerie(rs.getString("factura.serie"));
				fact.setNumero(rs.getString("factura.numero"));
				fact.setMoneda(rs.getString("factura.moneda"));
				fact.setTc(rs.getDouble("factura.tc"));
				fact.setClienteNombre(rs.getString("cliente.nombre"));
				
				clie.setNombre(rs.getString("cliente.nombre"));
				fact.setoCliente(clie);
				
				f.add(fact);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return f;
	}

}
