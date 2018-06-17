package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Aplicacion.Usuarios;

public class SqlUsuarios {
	
	public boolean login(Usuarios usr) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		conexion con = new conexion();
		Connection reg = con.getConnection();
		
		String sql = "SELECT rut, nombre, apellido, password, tipo_user, username FROM usuarios WHERE username = ?";
		try {
			ps = reg.prepareStatement(sql);
			ps.setString(1, usr.getUsername());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if (usr.getPassword().equals(rs.getString(4))) {
					usr.setRut(rs.getString(1));
					usr.setNombre(rs.getString(2));
					usr.setApellido(rs.getString(3));
					usr.setTipoUser(rs.getInt(5));
					return true;
				} else {
					return false;
				}
			}
			return false;	
		} catch (SQLException ex) {
			return false;
		} finally {
			con.desconectar();
		}
	}
}
