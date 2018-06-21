package Persistencia;

import java.sql.*;

import Aplicacion.Planetas;

public class SqlPlanetas extends conexion{
	public boolean agregarPlaneta(Planetas pln) {
		Connection con = this.getConnection();
		
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
}
