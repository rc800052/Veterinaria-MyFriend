package clinicaveterinaria.modelo;

public class Producto {
	private int idProducto;
	private String producto;
	private double precio;
	private TipoProducto oTipoProducto;
	
	public Producto() {
		super();
	}

	public Producto(int idProducto, String producto, double precio,
			TipoProducto oTipoProducto) {
		super();
		this.idProducto = idProducto;
		this.producto = producto;    
		this.precio = precio;
		this.oTipoProducto = oTipoProducto;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public TipoProducto getoTipoProducto() {
		return oTipoProducto;
	}

	public void setoTipoProducto(TipoProducto oTipoProducto) {
		this.oTipoProducto = oTipoProducto;
	}
}
