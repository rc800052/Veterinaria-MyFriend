package clinicaveterinaria.modelo;

import java.sql.Date;

public class Calendario {
	private int idCita;
	private Date fchcita;
	private int idPaciente;
	private String nombre_paciente;
	private int idDoctor;
	private String nombre_doctor;
	private int idCliente;
	private String nombre_cliente;
	private int idProducto;
	private String producto;

	public Calendario() {
		super();
	}

	public Calendario(int idCita, Date fchcita, int idPaciente,
			String nombre_paciente, int idDoctor, String nombre_doctor,
			int idCliente, String nombre_cliente, int idProducto,
			String producto) {
		super();
		this.idCita = idCita;
		this.fchcita = fchcita;
		this.idPaciente = idPaciente;
		this.nombre_paciente = nombre_paciente;
		this.idDoctor = idDoctor;
		this.nombre_doctor = nombre_doctor;
		this.idCliente = idCliente;
		this.nombre_cliente = nombre_cliente;
		this.idProducto = idProducto;
		this.producto = producto;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Date getFchcita() {
		return fchcita;
	}

	public void setFchcita(Date fchcita) {
		this.fchcita = fchcita;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombre_paciente() {
		return nombre_paciente;
	}

	public void setNombre_paciente(String nombre_paciente) {
		this.nombre_paciente = nombre_paciente;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getNombre_doctor() {
		return nombre_doctor;
	}

	public void setNombre_doctor(String nombre_doctor) {
		this.nombre_doctor = nombre_doctor;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
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

	
	
}
