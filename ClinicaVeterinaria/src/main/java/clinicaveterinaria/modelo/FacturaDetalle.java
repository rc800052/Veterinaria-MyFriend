package clinicaveterinaria.modelo;

public class FacturaDetalle {
	private int idFacDet;
	private int idFact;
	private double cantidad;
	private double precio;
	private double subtotal;
	private double igv;
	private Producto oProducto;
	private int idCitaDet;
	
	public FacturaDetalle() {
		super();
	}

	public FacturaDetalle(int idFacDet, int idFact, double cantidad, double precio, double subtotal, double igv, Producto oProducto, int idCitaDet ) {
		super();
		this.idFacDet = idFacDet;
		this.idFact = idFact;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subtotal = subtotal;
		this.igv = igv;
		this.oProducto = oProducto;
		this.idCitaDet = idCitaDet;
	}

	public int getIdFacDet() {
		return idFacDet;
	}

	public void setIdFacDet(int idFacDet) {
		this.idFacDet = idFacDet;
	}
	
	public int getIdFact() {
		return idFact;
	}

	public void setIdFact(int idFact) {
		this.idFact = idFact;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public Producto getoProducto() {
		return oProducto;
	}

	public void setoProducto(Producto oProducto) {
		this.oProducto = oProducto;
	}

	public int getIdCitaDet() {
		return idCitaDet;
	}

	public void setIdCitaDet(int idCitaDet) {
		this.idCitaDet = idCitaDet;
	}
	
	
}
