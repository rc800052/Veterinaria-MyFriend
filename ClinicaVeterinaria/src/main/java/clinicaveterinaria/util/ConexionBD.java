package clinicaveterinaria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

public static Connection obtenerConexion() throws SQLException {

	Connection con = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicaveterinaria", "root", "mysql");
		//con = DriverManager.getConnection("jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com", "gosus", "123456789");//NO FUNCIONO DE ESA MANERA
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;
}
}
