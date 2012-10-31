package clinicaveterinaria.modelo;

import java.sql.Date;

public class CitaCabDet {
	private int idCita;
	private String descripcion;
	private String telefono;
	private String direccion;
	private Date fchcita;
	private String estado;
	private int idPaciente;
	private int idDoctor;
	private int idCliente;
	private int idCitaDet;
	private int idProducto;
	private String producto;
	private String Tipo;
	private double cantidad;
	private double precio;

	public CitaCabDet() {
		super();
	}

	public CitaCabDet(int idCita, String descripcion, String telefono,
			String direccion, Date fchcita, String estado, int idPaciente,
			int idDoctor, int idCliente, int idCitaDet, int idProducto,
			double cantidad, double precio) {
		super();
		this.idCita = idCita;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fchcita = fchcita;
		this.estado = estado;
		this.idPaciente = idPaciente;
		this.idDoctor = idDoctor;
		this.idCliente = idCliente;
		this.idCitaDet = idCitaDet;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
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

	public Date getFchcita() {
		return fchcita;
	}

	public void setFchcita(Date fchcita) {
		this.fchcita = fchcita;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCitaDet() {
		return idCitaDet;
	}

	public void setIdCitaDet(int idCitaDet) {
		this.idCitaDet = idCitaDet;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
