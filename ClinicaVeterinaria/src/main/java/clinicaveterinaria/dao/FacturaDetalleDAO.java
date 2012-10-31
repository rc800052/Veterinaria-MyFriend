package clinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.FacturaDetalle;
import clinicaveterinaria.modelo.Producto;
import clinicaveterinaria.util.ConexionBD;

public class FacturaDetalleDAO extends BaseDAO {
/*
	public Collection<Categoria> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select id_categoria, nombre, descripcion from categoria where nombre like ?";
		Collection<Categoria> lista = new ArrayList<Categoria>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria vo = new Categoria();
				vo.setIdCategoria(rs.getInt("id_categoria"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDescripcion(rs.getString("descripcion"));
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
*/
	
	
public FacturaDetalle insertar(FacturaDetalle factdeta,Producto prod) throws DAOExcepcion {
		String query = "insert into facturadetalle(cantidad,precio,subtotal,igv,idProducto,idFactura,idCitaDet) values (?,?,?,?,?,?,?)";
		
		String query2 = "update citadetalle set estado = 'F' where idCitaDet = ? ";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setDouble(1,factdeta.getCantidad());
			stmt.setDouble(2,factdeta.getPrecio());
			stmt.setDouble(3,factdeta.getSubtotal());
			stmt.setDouble(4,factdeta.getIgv());
			prod = factdeta.getoProducto();
			stmt.setInt(5,prod.getIdProducto());
			stmt.setInt(6,factdeta.getIdFact());
			stmt.setInt(7,factdeta.getIdCitaDet());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			//
			stmt = con.prepareStatement(query2);
			stmt.setInt(1,factdeta.getIdCitaDet());
			int d = stmt.executeUpdate();
			if (d != 1) {
				throw new SQLException("No se pudo actualizar");
			}
			//
			
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			factdeta.setIdFacDet(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return factdeta;
	}

/*
	public Factura obtener(int idFactura) throws DAOExcepcion {
		Factura fact = new Factura();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select Factura.idFactura, Factura.fch_Factura, Cliente.nombre from factura,cliente where factura.Cliente_idCliente = Cliente.idCliente and Factura.idFactura=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idFactura);
			rs = stmt.executeQuery();
			if (rs.next()) {
				fact.setIdFactura(rs.getInt(1));
				fact.setFchFactura(rs.getDate(2));
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
	

	public Categoria actualizar(Categoria vo) throws DAOExcepcion {
		String query = "update categoria set nombre=?,descripcion=? where id_categoria=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDescripcion());
			stmt.setInt(3, vo.getIdCategoria());
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
   
	
	public Collection<Factura> listar_cliente(int idCliente) throws DAOExcepcion {
		Collection<Factura> f = new ArrayList<Factura>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select factura.idFactura,factura.fch_Factura,cliente.nombre from factura,cliente where factura.Cliente_idCliente = Cliente.idCliente and Cliente.idCliente = ? order by factura.idFactura";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Factura fact = new Factura();
				Cliente clie= new Cliente();
				
				fact.setIdFactura(rs.getInt("factura.idFactura"));
				fact.setFchFactura(rs.getDate("factura.fch_Factura"));
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
	*/

}
