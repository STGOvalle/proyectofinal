package Aplicacion;

public class Observacion {
	String Observacion, hora_inicio, hora_termino, usuario, uape, planeta;
	int id_usuario, id_planeta, id;
	
	public Observacion() {
		
	}

	public Observacion(String O, String HI, String HT, int IU, int IP) {
		this.Observacion=O;
		this.hora_inicio = HI;
		this.hora_termino = HT;
		this.id_usuario = IU;
		this.id_planeta = IP;
	}
	
	public Observacion(int I, String U,String A, String HI, String HT, String O) {
		this.id = I;
		this.usuario = U;
		this.uape = A;
		this.hora_inicio = HI;
		this.hora_termino = HT;
		this.Observacion = O;
	}
	
	public Observacion(int idUsuario, int plnid, String horaI, String horaFinal, String observacion) {
		this.id_usuario = idUsuario;
		this.id_planeta = plnid;
		this.hora_inicio = horaI;
		this.hora_termino = horaFinal;
		this.Observacion = observacion;
	}

	public Observacion(int id, String ob) {
		this.id = id;
		this.Observacion = ob;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int i) {
		this.id = i;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public String getPlaneta() {
		return this.planeta;
	}
	
	public void setUsuario(String U) {
		this.usuario = U;
	}
	
	public void setPlaneta(String P) {
		this.planeta = P;
	}
	
	public void setApeAstronomo(String A) {
		this.uape = A;
	}
	
	public String getApeAstronomo() {
		return this.uape;
	}

	public String getHoraInicio() {
		return this.hora_inicio;
	}
	
	public void setHoraInicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	
	public String getHoraTermino() {
		return this.hora_termino;
	}
	
	public void setHoraTermino(String hora_termino) {
		this.hora_termino = hora_termino;
	}
	
	public int getIdUsuario() {
		return this.id_usuario;
	}
	
	public void setIdUsuario(int usr) {
		this.id_usuario = usr;
	}
	
	public int getIdPlaneta() {
		return this.id_planeta;
	}
	
	public void setIdPlaneta(int id_pln) {
		this.id_planeta = id_pln;
	}
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

}