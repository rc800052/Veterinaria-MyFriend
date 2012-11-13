package clinicaveterinaria.modelo;

//import java.util.Date;


public class Paciente {
	
	private int idPaciente;
	private String nombre;
	private String esterelizado;
	private String tamano;
	private String actividad;
	private double peso;
	private String fchnac;
	private String especie;
	private String raza;
	private String genero;
	private String tiposangre;
	private Cliente ocliente;
	
	
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEsterelizado() {
		return esterelizado;
	}
	public void setEsterelizado(String esterelizado) {
		this.esterelizado = esterelizado;
	}
	
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getFchnac() {
		return fchnac;
	}
	public void setFchnac(String fchnac) {
		this.fchnac = fchnac;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTiposangre() {
		return tiposangre;
	}
	public void setTiposangre(String tiposangre) {
		this.tiposangre = tiposangre;
	}
	
	public Cliente getOcliente() {
		return ocliente;
	}
	public void setOcliente(Cliente ocliente) {
		this.ocliente = ocliente;
	}
	
	public Paciente() {
		super();
	}
	
	public Paciente(int idPaciente, String nombre, String esterelizado,
			String tamano, String actividad, double peso, String fchnac,
			String especie, String raza, String genero, String tiposangre,
			Cliente ocliente) {
		super();
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.esterelizado = esterelizado;
		this.tamano = tamano;
		this.actividad = actividad;
		this.peso = peso;
		this.fchnac = fchnac;
		this.especie = especie;
		this.raza = raza;
		this.genero = genero;
		this.tiposangre = tiposangre;
		this.ocliente = ocliente;
	}
	
	
	
	
	}
	