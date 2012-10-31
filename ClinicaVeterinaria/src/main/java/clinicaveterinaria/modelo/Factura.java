package clinicaveterinaria.modelo;

import java.sql.Date;
//INICIANDO
public class Factura {
	private int idFactura;
	private Date fch_Factura;
	private String serie;
	private String numero;
	private Date fch_Emision;
	private String moneda;
	private double tc;
	private Cliente oCliente;
	private int idCliente;
	private String ClienteNombre;

	public Factura() {
		super();
	}

	public Factura(int idFactura, Date fch_Factura, String serie, String numero, Date fch_Emision, String moneda, double tc, Cliente oCliente) {
		super();
		this.idFactura = idFactura;
		this.fch_Factura = fch_Factura;
		this.serie = serie;
		this.numero = numero;
		this.fch_Emision = fch_Emision;
		this.moneda = moneda;
		this.tc = tc;
		this.oCliente = oCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFch_Factura() {
		return fch_Factura;
	}

	public void setFch_Factura(Date fch_Factura) {
		this.fch_Factura = fch_Factura;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFch_Emision() {
		return fch_Emision;
	}

	public void setFch_Emision(Date fch_Emision) {
		this.fch_Emision = fch_Emision;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public double getTc() {
		return tc;
	}

	public void setTc(double tc) {
		this.tc = tc;
	}

	public Cliente getoCliente() {
		return oCliente;
	}

	public void setoCliente(Cliente oCliente) {
		this.oCliente = oCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getClienteNombre() {
		return ClienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		ClienteNombre = clienteNombre;
	}

	
}
