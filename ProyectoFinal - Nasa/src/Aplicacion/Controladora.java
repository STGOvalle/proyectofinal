package Aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Persistencia.SqlObservacion;
import Persistencia.SqlPlanetas;
import Persistencia.SqlTurnos;
import Persistencia.SqlUsuarios;
import Persistencia.Sqltabla;

public class Controladora {
	public Controladora() {
		
	}
	
	public Usuarios getLogin(String user, String pass) {
		SqlUsuarios SQL = new SqlUsuarios();
		Usuarios usr = new Usuarios();	
		
		usr.setRut(user);
		usr.setPassword(pass);
		
		Usuarios datos = SQL.login(usr);
		
		if (datos != null) {
			return usr;
		}
		return null;
	}
	
	public boolean crearPlaneta(Planetas pln) {
		SqlPlanetas SQL = new SqlPlanetas();
		boolean res = SQL.agregarPlaneta(pln);
		return res;
	}
	
	public boolean crearObservacion(Observacion obs) {
		SqlObservacion SQL = new SqlObservacion();
		boolean res = SQL.crearObservacion(obs);
		return res;
	}

	public boolean modAstronomo(Usuarios usr) {
		SqlUsuarios SQL = new SqlUsuarios();
		boolean res = SQL.modUsuario(usr);
		return res;
	}
	
	public Object[] getStronomo(String rut) {
		Sqltabla SQL = new Sqltabla();
		Object[] data = SQL.getAstronomo(rut);
		return data;
	}
	
	public ArrayList getAstronomos() {
		Sqltabla datos = new Sqltabla();
		ArrayList data = datos.Astronomos();
		return data;
	}
	
	public boolean crearAstronomo(Usuarios usr) {
		SqlUsuarios SQL = new SqlUsuarios();
		boolean res = SQL.crearAstronomo(usr);
		return res;
	}
	
	public ArrayList getPlanetas() {
		SqlPlanetas SQL = new SqlPlanetas();
		ArrayList data = SQL.ObtenerPlanetas();
		return data;
	}
	
	public Object[] getPlaneta(int ID) {
		SqlPlanetas SQL = new SqlPlanetas();
		Object[] data = SQL.ObtenerPlaneta(ID);
		return data;
	}
	
	public boolean modPlaneta(Planetas pln) {
		SqlPlanetas SQL = new SqlPlanetas();
		boolean res = SQL.modPlaneta(pln);
		return res;
	}
	
	public ArrayList getObservaciones(int ID) {
		SqlObservacion SQL = new SqlObservacion();
		ArrayList data = SQL.getObservaciones(ID);
		return data;
	}
	
	public Object[] getObservacion(int ID) {
		SqlObservacion datos = new SqlObservacion();
		Object[] data = datos.getObservacion(ID);
		return data;
	}
	
	public boolean modObservacion(Observacion obs) {
		SqlObservacion SQL = new SqlObservacion();
		boolean res = SQL.modObservacion(obs);
		return res;
	}
	
	public ArrayList getObservacionFecha(String HI, String HF) {
		SqlObservacion datos = new SqlObservacion();
		ArrayList data = datos.getObservacionTime(HI, HF);
		return data;
	}
	
	public boolean crearTurno(Turnos tur) {
		SqlTurnos SQL = new SqlTurnos();
		boolean res = SQL.crearTurno(tur);
		return res;
	}
	
	public Object[] getLastTurno(int id) {
		SqlTurnos SQL = new SqlTurnos();
		Object[] data = SQL.getLastTurno(id);
		return data;
	}
	
	public ArrayList getPlanetasM() {
		SqlPlanetas SQL = new SqlPlanetas();
		ArrayList data = SQL.getPlanetas();
		return data;
	}

}
