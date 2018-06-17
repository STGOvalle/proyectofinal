package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class conexion {
	private static Connection con;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/nasa";
	
	public conexion() {
		con = null;
		try {
			Class.forName(driver);
			con = DriverManager .getConnection(url, user, password);
			if (con != null) {
				System.out.println("Conexión establecida...");
			}
		} catch (Exception e) {
			System.out.println("Error al conectarse a la base de datos"+e.toString());
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void desconectar() {
		con = null;
		if (con == null) {
			System.out.println("Desconexion realizada.");
		}
	}

}
