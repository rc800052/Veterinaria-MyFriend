package clinicaveterinaria.modelo;

public class Prospecto {

	private int idProspecto;
	private String nombre;
	private String email;
	private String direccion;
	private String imagen;
	private String telcasa;
	private String telcelular;
	private String cliente; 



	// Cambiar a Prospecto
	public void cambiar2Cliente() {
	
	}

	public Prospecto() {
		super();
	}

	public Prospecto(int idProspecto, String nombre, String email,
			String direccion, String imagen, String telcasa, String telcelular,
			String cliente) {
		super();
		this.idProspecto = idProspecto;
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.imagen = imagen;
		this.telcasa = telcasa;
		this.telcelular = telcelular;
		this.cliente = cliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public int getIdProspecto() {
		return idProspecto;
	}

	public void setIdProspecto(int idProspecto) {
		this.idProspecto = idProspecto;
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



}

