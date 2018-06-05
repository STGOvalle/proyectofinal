package Aplicacion;

public class Planetas {

	private String Nombre,Elem_org;
	private double Diametro_p,Temperatura,Gravedad,Vel_Esc,Dist_Sol,Rotacion;
	private int cant_satelites=0;
	
	public Planetas(double DP,String N,String EO,double T,double G,double VE,double DS,double R, int CS) {
		
		this.Diametro_p= DP;
		this.Nombre= N;
		this.Elem_org= EO;
		this.Temperatura= T;
		this.Gravedad= G;
		this.Vel_Esc= VE;
		this.Dist_Sol= DS;
		this.Rotacion=R;
		this.cant_satelites=CS;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getElem_org() {
		return Elem_org;
	}

	public void setElem_org(String elem_org) {
		Elem_org = elem_org;
	}

	public double getDiametro_p() {
		return Diametro_p;
	}

	public void setDiametro_p(double diametro_p) {
		Diametro_p = diametro_p;
	}

	public double getTemperatura() {
		return Temperatura;
	}

	public void setTemperatura(double temperatura) {
		Temperatura = temperatura;
	}

	public double getGravedad() {
		return Gravedad;
	}

	public void setGravedad(double gravedad) {
		Gravedad = gravedad;
	}

	public double getVel_Esc() {
		return Vel_Esc;
	}

	public void setVel_Esc(double vel_Esc) {
		Vel_Esc = vel_Esc;
	}

	public double getDist_Sol() {
		return Dist_Sol;
	}

	public void setDist_Sol(double dist_Sol) {
		Dist_Sol = dist_Sol;
	}

	public double getRotacion() {
		return Rotacion;
	}

	public void setRotacion(double rotacion) {
		Rotacion = rotacion;
	}

	public int getCant_satelites() {
		return cant_satelites;
	}

	public void setCant_satelites(int cant_satelites) {
		this.cant_satelites = cant_satelites;
	}
	
	
	
}