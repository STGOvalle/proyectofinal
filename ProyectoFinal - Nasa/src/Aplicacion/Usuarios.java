package Aplicacion;

public class Usuarios {
	private String Rut,Nombre,Apellido,fecha_nac,Nacionalidad,Estudio_carrera, password;
	private int edad, tipo_user, id;
	
	public Usuarios() {
		
	}
	
	public Usuarios(String R,String N,String APE,String FC,int E,String NAC,String EC) {
		this.Rut= R;
		this.Nombre =N;
		this.Apellido = APE;
		this.fecha_nac =FC;
		this.edad= E;
		this.Nacionalidad =NAC;
		this.Estudio_carrera =EC;
	}
	public Usuarios(String u, String p, int tU) {
		this.Rut = u;
		this.password = p;
		this.tipo_user = tU;
	}
	
	public Usuarios(int i, String N, String A) {
		this.id = i;
		this.Nombre = N;
		this.Apellido = A;
	}
	
	public Usuarios(String R,String N,String APE,String FC,int E,String NAC,String EC, String P) {
		this.Rut= R;
		this.Nombre =N;
		this.Apellido = APE;
		this.fecha_nac =FC;
		this.edad= E;
		this.Nacionalidad =NAC;
		this.Estudio_carrera =EC;
		this.password = P;
	}

	public String getRut() {
		return Rut;
	}
	public void setRut(String rut) {
		Rut = rut;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public String getEstudio_carrera() {
		return Estudio_carrera;
	}
	public void setEstudio_carrera(String estudio_carrera) {
		Estudio_carrera = estudio_carrera;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String p) {
		this.password = p;
	}
	
	public int getTipoUser() {
		return tipo_user;
	}
	
	public void setTipoUser(int TU) {
		this.tipo_user = TU;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int i) {
		this.id = i;
	}
	@Override
	public String toString() {
		String v = this.Nombre+" "+this.Apellido;
		return v;
	}
}