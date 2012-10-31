package clinicaveterinaria.modelo;

public class Doctor {
	private int idDoctor;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String usuario;
	private String clave;
	private String perfil;
	 
	public Doctor() {
		super();
	}
	
	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Doctor(int idDoctor, String nombre, String apellido,
			String email, String telefono, String usuario, String clave, String perfil) {
		super();
		this.idDoctor = idDoctor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.usuario = usuario;
		this.clave = clave;
		this.perfil = perfil;
	}

}
