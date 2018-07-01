package Persistencia;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Aplicacion.Turnos;

public class SqlTurnos extends conexion{
	Connection con = this.getConnection();
	
	public boolean  crearTurno(Turnos tur) {
		
		try {
			/** Parseo de fechas **/
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date TC, TF, DC, DF = null;
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			
			/** Turno comienzo **/
			TC = sdf.parse(tur.getComienzo_turno());
			Date TCF = Date.valueOf(sdf2.format(TC));
			/** Turno Final **/
			TF = sdf.parse(tur.getFinal_turno());
			Date TFF = Date.valueOf(sdf2.format(TF));
			/** Comienzo descanso **/
			DC = sdf.parse(tur.getComienzo_descanso());
			Date DCF = Date.valueOf(sdf2.format(DC));
			/** Final Descanso **/
			DF = sdf.parse(tur.getFinal_descanso());
			Date DFF = Date.valueOf(sdf2.format(DF));
			
			String SQL = "INSERT INTO turnos VALUES (default, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, tur.getId_usuario());
			ps.setDate(2, TCF);
			ps.setDate(3, TFF);
			ps.setDate(4, DCF);
			ps.setDate(5, DFF);
			
			int res = ps.executeUpdate();
			
			if(res == 1) {
				return true;
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
		return false;
	}
	
	public Object[] getLastTurno(int id) {
		
		Object[] data = new Object[4];
		try {
			
			String SQL = "SELECT turno_comienzo, turno_final, descanso_comienzo, descanso_final FROM turnos WHERE id_usuario = ? ORDER BY id DESC LIMIT 1";
			PreparedStatement ps = con.prepareStatement(SQL);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
