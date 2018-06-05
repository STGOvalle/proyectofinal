package Aplicacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
	public Validaciones() {
		
	}
	
	public boolean campoVacio(String cad) {
		boolean res = false;
		
		if (cad.length() > 0) {
			return res = true;
		}
		
		return res;
	}
	
	public boolean soloString(String cad) {
		boolean res = false;
		Pattern P = Pattern.compile("(^[a-z A-Z]*$)");
		Matcher mat = P.matcher(cad);
		
		boolean b = mat.matches();
		if (b) {
			return true;
		}
		
		return false;
	}
}
