package clinicaveterinaria.modelo;


public class BeanCitas {

	private Integer  idCita;
	private String   descripcion;
	private String   telefono;
	private String   direccion;
	private String  fecha;
	private String   estado;
	private Integer   idDoctor;
	private Integer   idPaciente;
	private Integer   idCliente;
	
	private String nombre;
	private String especie;
	private String raza;
	private String genero;
	
	
	public BeanCitas() {	
	}
	
	public BeanCitas(int idCita, String descripcion, String telefono,
			String direccion, String fecha, String estado, int idDoctor,
			int idPaciente, int idCliente) {
		super();
		this.idCita = idCita;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fecha = fecha;
		this.estado = estado;
		this.idDoctor = idDoctor;
		this.idPaciente = idPaciente;
		this.idCliente = idCliente;
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Integer idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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
	
	
	
	
		
	
}
