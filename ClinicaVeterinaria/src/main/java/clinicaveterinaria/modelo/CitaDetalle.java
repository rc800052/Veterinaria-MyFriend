package clinicaveterinaria.modelo;

public class CitaDetalle {
	private int idCitaDet;
	private double cantidad;
	private double precio;
	private int idCita;
	
	private Producto oProducto;

	public CitaDetalle() {
		super();
	}

	public CitaDetalle(int idCitaDet, double cantidad, double precio,
			Producto oProducto, int idCita) {
		super();
		this.idCitaDet = idCitaDet;
		this.cantidad = cantidad;
		this.precio = precio;
		this.oProducto = oProducto;
		this.idCita = idCita;
	}

	public int getIdCitaDet() {
		return idCitaDet;
	}

	public void setIdCitaDet(int idCitaDet) {
		this.idCitaDet = idCitaDet;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
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

	public Producto getoProducto() {
		return oProducto;
	}

	public void setoProducto(Producto oProducto) {
		this.oProducto = oProducto;
	}
	
}
