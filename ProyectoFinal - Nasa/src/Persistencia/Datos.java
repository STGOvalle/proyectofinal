package Persistencia;

import java.util.ArrayList;

import Aplicacion.Usuarios;

public class Datos {
	
	public static ArrayList <Usuarios> data = new ArrayList<Usuarios>();
	
	public Datos() {
		data.add(new Usuarios ("admin", "admin", 1));
		data.add(new Usuarios ("astronomo", "astronomo", 0));
	}
	

}
