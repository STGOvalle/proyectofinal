package Aplicacion;

public class Turnos {
	int id_usuario;
	String comienzo_turno, final_turno, comienzo_descanso, final_descanso;
	
	public Turnos() {
	
	}

	public Turnos(int id_usuario, String comienzo_turno, String final_turno, String comienzo_descanso,
			String final_descanso) {
		super();
		this.id_usuario = id_usuario;
		this.comienzo_turno = comienzo_turno;
		this.final_turno = final_turno;
		this.comienzo_descanso = comienzo_descanso;
		this.final_descanso = final_descanso;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getComienzo_turno() {
		return comienzo_turno;
	}

	public void setComienzo_turno(String comienzo_turno) {
		this.comienzo_turno = comienzo_turno;
	}

	public String getFinal_turno() {
		return final_turno;
	}

	public void setFinal_turno(String final_turno) {
		this.final_turno = final_turno;
	}

	public String getComienzo_descanso() {
		return comienzo_descanso;
	}

	public void setComienzo_descanso(String comienzo_descanso) {
		this.comienzo_descanso = comienzo_descanso;
	}

	public String getFinal_descanso() {
		return final_descanso;
	}

	public void setFinal_descanso(String final_descanso) {
		this.final_descanso = final_descanso;
	}
	

	
	
}
