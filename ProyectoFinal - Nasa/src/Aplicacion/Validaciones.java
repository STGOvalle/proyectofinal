package Aplicacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validaciones {
	public Validaciones() {
		
	}
	
	public boolean campoVacio(String cad) {
		boolean res = false;
		
		if (cad.length() > 0) {
			res = true;
		}
		
		return res;
	}
	
	public boolean soloString(String cad) {
		Pattern P = Pattern.compile("(^[a-z A-Z]*$)");
		Matcher mat = P.matcher(cad);
		
		boolean res = mat.matches();
		
		return res;
	}
	
	public boolean soloNum(String cad) {
		Pattern P = Pattern.compile("(^[0-9]*$)");
		Matcher mat = P.matcher(cad);
		
		boolean res = mat.matches();
		return res;
	}
	
	public boolean Rut(String cad) {
		Pattern P = Pattern.compile("(^[1-9]{1}[0-9]?.[0-9]{3}.[0-9]{3}-([0-9]|K){1}$)");
		Matcher mat = P.matcher(cad);
		
		boolean res = mat.matches();
		
		return res;
	}
	
	public boolean esDoble(String cad) {
		Pattern P = Pattern.compile("(^[0-9]*)\\.([0-9]*)");
		Matcher mat = P.matcher(cad);
		
		boolean res = mat.matches();
		return res;
	}
	
	public boolean fecha(String cad) {
		Pattern P = Pattern.compile("(^[0-9]{2}\\/[0-9]{2}\\/[1-9]{4}$)");
		Matcher mat = P.matcher(cad);
		
		boolean res = mat.matches();
		
		return res;
	}
	
	public boolean fechaTurno(String cad) {
		Pattern P = Pattern.compile("(^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$)");
		Matcher mat = P.matcher(cad);
		
		boolean res = mat.matches();
		
		return res;
	}
}
