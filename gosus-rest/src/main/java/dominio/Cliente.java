package dominio;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cliente")
public class Cliente {

	private int idCliente;
	private String nombre;
	private String email;
	private String direccion;
	private String imagen;
	private String telcasa;
	private String telcelular;
	private String notas;
	private int idProspecto;

	// Cambiar a Cliente
	public void cambiar2Cliente() {
	
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTelcasa() {
		return telcasa;
	}

	public void setTelcasa(String telcasa) {
		this.telcasa = telcasa;
	}

	public String getTelcelular() {
		return telcelular;
	}

	public void setTelcelular(String telcelular) {
		this.telcelular = telcelular;
	}

	public String getNotas() {
		return notas;
	}

	public Integer getIdProspecto() {
		return idProspecto;
	}

	public void setIdProspecto(Integer idProspecto) {
		this.idProspecto = idProspecto;
	}
	
	
	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente, String nombre, String email,
			String direccion, String imagen, String telcasa, String telcelular,
			String notas, Integer idProspecto) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.imagen = imagen;
		this.telcasa = telcasa;
		this.telcelular = telcelular;
		this.notas = notas;
		this.idProspecto = idProspecto;
	}

}

