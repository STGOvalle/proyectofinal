package Persistencia;

import java.sql.*;
import java.util.ArrayList;

import Aplicacion.Planetas;
import Aplicacion.Usuarios;

public class SqlPlanetas extends conexion{
	Connection con = this.getConnection();
	
	public boolean agregarPlaneta(Planetas pln) {
		
		try {
			String sql = "INSERT INTO planetas values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			/** Agrego la informacion a la consulta obtenida del objeto traido **/
			ps.setString(1, pln.getNombre());
			ps.setInt(2, pln.getDiametro_p());
			ps.setString(3, pln.getElem_org());
			ps.setInt(4, pln.getTemperatura());
			ps.setDouble(5, pln.getGravedad());
			ps.setDouble(6, pln.getVel_Esc());
			ps.setInt(7, pln.getDist_Sol());
			ps.setString(8, pln.getRotacion());
			ps.setInt(9, pln.getCant_satelites());
			
			
			boolean res = ps.execute();
			
			if(!res) {
				return true;
			} else {
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		} finally {
			this.desconectar();
		}
		return false;
	}
	
	public ArrayList ObtenerPlanetas() {
		ArrayList data = new ArrayList();
		
		
		try {
			String sql = "SELECT nombre, id FROM planetas";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Planetas pln = new Planetas();
				pln.setNombre(rs.getString(1));
				pln.setId(rs.getInt(2));
				
				data.add(pln);
				return data;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.desconectar();
		}
		
		return null;
	}
	
	public Object[] ObtenerPlaneta(int ID) {
		Object[] data = new Object[10];
		
		
		try {
			String SQL = "SELECT nombre, diametro, elemento_organico, temperatura, gravedad, vel_esc, dist_sol,"
					+ "rotacion, cant_sat, id FROM planetas WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int cantidadColumnas = rsMd.getColumnCount();
			while(rs.next()) {
				for (int i=0; i<cantidadColumnas; i++) {
					data[i] = rs.getObject(i+1);
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.desconectar();
		}
		return null;
	}
	
	public boolean modPlaneta(Planetas pln) {
		try {
			String SQL = "UPDATE planetas SET nombre = ?, diametro = ?, elemento_organico = ?, temperatura = ?,"
					+ "gravedad = ?, vel_esc = ?, dist_sol = ?, rotacion = ?, cant_sat = ? WHERE id = ?";
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, pln.getNombre());
			ps.setInt(2, pln.getDiametro_p());
			ps.setString(3, pln.getElem_org());
			ps.setInt(4, pln.getTemperatura());
			ps.setDouble(5, pln.getGravedad());
			ps.setDouble(6, pln.getVel_Esc());
			ps.setInt(7, pln.getDist_Sol());
			ps.setString(8, pln.getRotacion());
			ps.setInt(9, pln.getCant_satelites());
			ps.setInt(10, pln.getId());
			
			int res = ps.executeUpdate();
			
			if(res == 1) {
				return true;
			}
			
		} catch(SQLException e) {
			System.out.println(e.toString());
		} finally {
			this.desconectar();
		}
		return false;
	}
	
	public ArrayList getPlanetas() {
		ArrayList data = new ArrayList();
		
		
		try {
			String sql = "SELECT id, nombre, diametro, elemento_organico, temperatura, gravedad, vel_esc, dist_sol, "
					+ "rotacion, cant_sat FROM planetas";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Planetas pln = new Planetas(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getDouble(6),
						rs.getDouble(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getInt(10)
						);
				
				data.add(pln);
				
			}
			
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.desconectar();
		}
		
		return null;
	}
}
