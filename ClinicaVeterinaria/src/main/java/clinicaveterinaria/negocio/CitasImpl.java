package clinicaveterinaria.negocio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import java.util.ArrayList;




import clinicaveterinaria.modelo.BeanCitas;
import clinicaveterinaria.util.ConexionBD;



import clinicaveterinaria.dao.Citas;
import clinicaveterinaria.excepcion.DAOExcepcion;

public class CitasImpl implements Citas {
	
	private Connection getConnection() throws SQLException {

		
		ConexionBD cnx = new ConexionBD();
		return cnx.obtenerConexion();
			
		}
	

	public Collection obtenerFullpacientes(int cod) throws Exception {
		System.out.println("llego al producto ful implemente)----------- ");
		Collection objLista = new ArrayList();
		BeanCitas objBeancitas = null;
		
		try {
			
			String query = "Select idPaciente,nombre,especie,raza,genero from paciente where idCliente =?";
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
				con = ConexionBD.obtenerConexion();
				stmt = con.prepareStatement(query);
				stmt.setInt(1, cod);
				rs = stmt.executeQuery();
			     while (rs.next()) {
				    	 
			    	 objBeancitas = new BeanCitas();
			    	 objBeancitas.setIdPaciente(rs.getInt(1)); 
			    	 objBeancitas.setNombre(rs.getString(2));
			    	 objBeancitas.setEspecie(rs.getString(3));
			    	 objBeancitas.setRaza(rs.getString(4));
			    	 objBeancitas.setGenero(rs.getString(5));
			    		objLista.add(objBeancitas);
						
						System.out.println("llego al <<<<<<<<<<"+rs.getInt(1));
										
				}
			     rs.close();
					stmt.close();
					con.close();
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				
				return objLista;
		
	}


	
	
	
	public BeanCitas insertarcita(BeanCitas citas) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		Boolean flagOK = true;
		
		System.out.println("llego al producto ful implemente)----------- ");
		
		String query = "insert into cita (descripcion,telefono,direccion,fchcita,estado,idDoctor,idPaciente,idCliente) values (?,?,?,?,?,?,?,?)";
		System.out.println("llego al producto ful implemente2222)----------- ");
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, citas.getDescripcion());
			stmt.setString(2, citas.getTelefono());
			stmt.setString(3, citas.getDireccion());
			System.out.println(citas.getFecha());
			stmt.setDate(4, new Date(sdf.parse(citas.getFecha()).getTime()));
			stmt.setString(5, citas.getEstado());
			stmt.setInt(6, citas.getIdDoctor()); 
			stmt.setInt(7, citas.getIdPaciente());
			stmt.setInt(8, citas.getIdCliente());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				flagOK = false;
				throw new SQLException("No se pudo insertar");
			} else {
				// Obtener el ultimo id
				int id = 0;
				query = "select last_insert_id()";
				stmt = con.prepareStatement(query);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
				}
				citas.setIdCita(id);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			rs.close();
			stmt.close();
			con.close();			
		}
		
		return citas;
	}

}
