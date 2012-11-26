package dominio;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "producto")
public class Producto {
	private int idProducto;
	private String producto;
	private double precio;
	
	public Producto() {
		super();
	}

	public Producto(int idProducto, String producto, double precio) {
		super();
		this.idProducto = idProducto;
		this.producto = producto;    
		this.precio = precio;
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

}
