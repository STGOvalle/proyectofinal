package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Aplicacion.Usuarios;

public class SqlUsuarios {
	conexion con = new conexion();
	Connection reg = con.getConnection();
	
	public boolean login(Usuarios usr) {
			
		String sql = "SELECT rut, nombre, apellido, password, tipo_user FROM usuarios WHERE rut = ?";

		try {
			PreparedStatement ps = reg.prepareStatement(sql);
			ps.setString(1, usr.getRut());
			ResultSet rs = ps.executeQuery();
			
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
	
	public boolean modUsuario(Usuarios usr) {
		try {
			String SQL = "UPDATE usuarios SET nombre = ?, apellido = ?, edad = ?, fecha_nac = ?, nacionalidad = ?, "
					+ "estudio_carrera = ? WHERE rut = ?";
			
			PreparedStatement ps = reg.prepareStatement(SQL);
			ps.setString(1, usr.getNombre());
			ps.setString(2, usr.getApellido());
			ps.setInt(3, usr.getEdad());
			ps.setString(4, usr.getFecha_nac());
			ps.setString(5, usr.getNacionalidad());
			ps.setString(6, usr.getEstudio_carrera());
			ps.setString(7, usr.getRut());
			boolean res = ps.execute();
					
			if(res) {
				return true;
			}
			
			return false;
			
		} catch(SQLException e) {
			System.out.println(e.toString());
		} finally {
			con.desconectar();
		}
		return false;
	}
}
