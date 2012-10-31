package clinicaveterinaria.modelo;

public class TipoProducto {
	private int idTipo;
	private String tipo;
	
	public TipoProducto() {
		super();
	}
	
	public TipoProducto(int idTipo, String tipo) {
		super();
		this.idTipo = idTipo;
		this.tipo = tipo;
	}   

	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
