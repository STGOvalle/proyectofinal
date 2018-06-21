package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Aplicacion.Usuarios;

public class Sqltabla extends conexion{
	
	public ArrayList Astronomos() {
		ArrayList data = new ArrayList();
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection con = this.getConnection();
			
			String sql = "SELECT rut, nombre, apellido FROM usuarios";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Usuarios user = new Usuarios();
				user.setRut(rs.getString(1));
				user.setNombre(rs.getString(2));
				user.setApellido(rs.getString(3));
				
				data.add(user);
			}
			
			
			return data;
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			this.desconectar();
		}
		return data;
		
	}
	
	public Object[] getAstronomo(String rut) {
		Object[] data = new Object[7];
		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection con = this.getConnection();
			
			String sql = "SELECT rut, nombre, apellido, edad, fecha_nac, nacionalidad, estudio_carrera FROM usuarios WHERE rut = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, rut);
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int cantidadColumnas = rsMd.getColumnCount();
			while(rs.next()) {
				for (int i=0; i<cantidadColumnas; i++) {
					data[i] = rs.getObject(i+1);
				}
				return data;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return data;
	}
}
