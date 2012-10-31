package clinicaveterinaria.modelo;

public class Historia {

	private String notaMedica;
	private String imagenMedica;
	private String condicionEspecial;
	private int Cita_idCita;
	private int idHistoria;

	public Historia() {
		super();
	}

	public Historia(int idHistoria, String notaMedica, String imagenMedica,
			String condicionEspecial, int Cita_idCita) {
		super();
		this.idHistoria = idHistoria;
		this.notaMedica = notaMedica;
		this.imagenMedica = imagenMedica;
		this.condicionEspecial = condicionEspecial;
		this.Cita_idCita = Cita_idCita;
	}

	public String getNotaMedica() {
		return notaMedica;
	}

	public void setNotaMedica(String notaMedica) {
		this.notaMedica = notaMedica;
	}

	public String getImagenMedica() {
		return imagenMedica;
	}

	public void setImagenMedica(String imagenMedica) {
		this.imagenMedica = imagenMedica;
	}

	public String getCondicionEspecial() {
		return condicionEspecial;
	}

	public void setCondicionEspecial(String condicionEspecial) {
		this.condicionEspecial = condicionEspecial;
	}

	public int getCita_idCita() {
		return Cita_idCita;
	}

	public void setCita_idCita(int cita_idCita) {
		Cita_idCita = cita_idCita;
	}

	public int getIdHistoria() {
		return idHistoria;
	}

	public void setIdHistoria(int idHistoria) {
		this.idHistoria = idHistoria;
	}
	
}
