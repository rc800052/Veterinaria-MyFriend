package clinicaveterinaria.modelo;

import java.util.Collection;
import java.sql.Date;
/*
 * Ricardo Campos
 */
public class Cita {
	private int idCita;
	private String descripcion;
	private String telefono;
	private String direccion;
	private Date fchcita;
	private String estado;
	
	private Paciente oPaciente;
	private Doctor oDoctor;
	private Cliente oCliente;
	private Producto oProducto;
	private Collection<CitaDetalle> oCitaDetalle;

	public Cita() {
		super();
	}

	public Cita(int idCita, String descripcion, String telefono,
			String direccion, Date fchcita, String estado, Paciente oPaciente,
			Doctor oDoctor, Cliente oCliente,
			Collection<CitaDetalle> oCitaDetalle) {
		super();
		this.idCita = idCita;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fchcita = fchcita;
		this.estado = estado;
		this.oPaciente = oPaciente;
		this.oDoctor = oDoctor;
		this.oCliente = oCliente;
		this.oCitaDetalle = oCitaDetalle;
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

	public Paciente getoPaciente() {
		return oPaciente;
	}

	public void setoPaciente(Paciente oPaciente) {
		this.oPaciente = oPaciente;
	}

	public Doctor getoDoctor() {
		return oDoctor;
	}

	public void setoDoctor(Doctor oDoctor) {
		this.oDoctor = oDoctor;
	}

	public Cliente getoCliente() {
		return oCliente;
	}

	public void setoCliente(Cliente oCliente) {
		this.oCliente = oCliente;
	}
	
	public Producto getoProducto() {
		return oProducto;
	}

	public void setoProducto(Producto oProducto) {
		this.oProducto = oProducto;
	}
	
	public Collection<CitaDetalle> getoCitaDetalle() {
		return oCitaDetalle;
	}

	public void setoCitaDetalle(Collection<CitaDetalle> oCitaDetalle) {
		this.oCitaDetalle = oCitaDetalle;
	}

}
