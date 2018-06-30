package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Aplicacion.Usuarios;

public class SqlUsuarios extends conexion {
	Connection con = this.getConnection();
	
	public static Object[] usuario = new Object[4];
	
	public Usuarios login(Usuarios usr) {
			
		String sql = "SELECT id, rut, nombre, apellido, password, tipo_user FROM usuarios WHERE rut = ? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usr.getRut());
			ps.setString(2, usr.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				usr.setNombre(rs.getString(3));
				usr.setApellido(rs.getString(4));
				usr.setTipoUser(rs.getInt(6));
				
				for (int i=0; i<4; i++) {
					usuario[i] = rs.getString(i+1);
				}
				
				return usr;
			}
			return null;	
		} catch (SQLException ex) {
			return null;
		} finally {
			this.desconectar();
		}
	}
	
	public boolean modUsuario(Usuarios usr) {
		try {
			String SQL = "UPDATE usuarios SET nombre = ?, apellido = ?, edad = ?, fecha_nac = ?, nacionalidad = ?, "
					+ "estudio_carrera = ? WHERE rut = ?";
			
			PreparedStatement ps = con.prepareStatement(SQL);
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
			this.desconectar();
		}
		return false;
	}
	
	public boolean crearAstronomo(Usuarios usr) {
		try {
			// Parsing Fecha
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateF = null;
			dateF = sdf.parse(usr.getFecha_nac());
			Date fecha = Date.valueOf(sdf.format(dateF));
			
			String sql = "INSERT INTO usuarios values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			/** Agrego la informacion a la consulta obtenida del objeto traido **/
			ps.setString(1, usr.getRut());
			ps.setString(2, usr.getNombre());
			ps.setString(3, usr.getApellido());
			ps.setDate(4, fecha);
			ps.setInt(5, usr.getEdad());
			ps.setString(6, usr.getNacionalidad());
			ps.setString(7, usr.getEstudio_carrera());
			ps.setString(8, usr.getPassword());
			ps.setInt(9, 2);
			
			
			
			int res = ps.executeUpdate();
			
			if(res == 1) {
				return true;
			}
			
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		} finally {
			this.desconectar();
		}
		return false;
	}
}
