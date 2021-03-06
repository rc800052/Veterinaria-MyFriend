package vo;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import dominio.Producto;

@XmlRootElement(name = "response")
public class ProductoCollection {

    private Collection<Producto> productos;
    
    public ProductoCollection() {
    }

    public ProductoCollection(Collection<Producto> productos) {
        this.productos = productos;
    }

    @XmlElement(name="producto")
    @XmlElementWrapper(name="productos")
    public Collection<Producto> getProductos() {
        return productos;
    }

}
