package Aplicacion;

public class Planetas {

	private String Nombre,Elem_org,Rotacion;
	private double Gravedad,Vel_Esc;
	private int Diametro_p,Temperatura,Dist_Sol,cant_satelites=0;
	
	public Planetas(int DP,String N,String EO,int T,double G,double VE,int DS,String R, int CS) {
		
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

	public int getDiametro_p() {
		return Diametro_p;
	}

	public void setDiametro_p(int diametro_p) {
		Diametro_p = diametro_p;
	}

	public int getTemperatura() {
		return Temperatura;
	}

	public void setTemperatura(int temperatura) {
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

	public int getDist_Sol() {
		return Dist_Sol;
	}

	public void setDist_Sol(int dist_Sol) {
		Dist_Sol = dist_Sol;
	}

	public String getRotacion() {
		return Rotacion;
	}

	public void setRotacion(String rotacion) {
		Rotacion = rotacion;
	}

	public int getCant_satelites() {
		return cant_satelites;
	}

	public void setCant_satelites(int cant_satelites) {
		this.cant_satelites = cant_satelites;
	}
	
	
	
}