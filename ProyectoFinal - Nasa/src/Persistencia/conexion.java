package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		} catch (Exception e) {
			System.out.println("Error al conectarse a la base de datos"+e.toString());
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void desconectar() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
