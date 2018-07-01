package Persistencia;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Aplicacion.Observacion;
import Aplicacion.Planetas;
import Aplicacion.Usuarios;

public class SqlObservacion extends conexion{
	Connection con = this.getConnection();
	
	public boolean crearObservacion(Observacion obs) {
		
		
		String SQL = "INSERT INTO observacion VALUES (default, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, obs.getIdUsuario());
			ps.setInt(2, obs.getIdPlaneta());
			ps.setString(3, obs.getHoraInicio());
			ps.setString(4, obs.getHoraTermino());
			ps.setString(5, obs.getObservacion());
			
			boolean res = ps.execute();
			if(!res) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.desconectar();
		}
		
		return false;
	}
	
	public ArrayList getObservaciones(int ID) {
		ArrayList data = new ArrayList();
		
		String SQL = "SELECT o.id, u.nombre, u.apellido, o.hora_inicio, o.hora_termino, o.observacion "
				+ "FROM observacion o INNER JOIN usuarios u ON o.id_usuario = u.id WHERE o.id_planeta = ?";	
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, ID);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Observacion obs = new Observacion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				
				data.add(obs);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.desconectar();
		}
		
		return data;
	}
	
	public Object[] getObservacion(int id) {
		Object[] data = new Object[7];
		try {
			Connection con = this.getConnection();
			
			String sql = "SELECT hora_inicio, hora_termino, observacion, id FROM observacion WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
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
		} finally {
			this.desconectar();
		}
		return data;
	}
	
	public boolean modObservacion(Observacion obs) {
		try {
			String SQL = "UPDATE observacion SET observacion = ? WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, obs.getObservacion());
			ps.setInt(2, obs.getId());

			boolean res = ps.execute();
					
			if(res) {
				return true;
			}
			
		} catch(SQLException e) {
			System.out.println(e.toString());
		} finally {
			this.desconectar();
		}
		return false;
	}
	
	public ArrayList getObservacionTime(String finicio, String ffinal) {
		ArrayList data = new ArrayList();
			
		try {
			String SQL = "SELECT o.id, hora_inicio, hora_termino, observacion, p.nombre, u.nombre, u.apellido FROM observacion o "
					+ "INNER JOIN planetas p ON o.id_planeta = p.id "
					+ "INNER JOIN usuarios u ON o.id_usuario = u.id "
					+ "WHERE DATE(hora_inicio) BETWEEN ? AND ? ORDER BY id DESC";
			/** Parseo de fechas **/
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date FI, FF = null;
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			/** Fecha comienzo **/
			FI = sdf.parse(finicio);
			Date FIF = Date.valueOf(sdf2.format(FI));
			/** Fecha Final **/
			FF = sdf.parse(ffinal);
			Date FFF = Date.valueOf(sdf2.format(FF));
			
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setDate(1, FIF);
			ps.setDate(2, FFF);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Observacion obs = new Observacion(
						rs.getInt(1),
						rs.getDate(2).toString(), 
						rs.getDate(3).toString(), 
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						);
				
				data.add(obs);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.desconectar();
		}
		
		return data;
	}
}
