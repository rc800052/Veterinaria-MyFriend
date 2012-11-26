package vo;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import dominio.Cliente;

@XmlRootElement(name = "response")
public class ClienteCollection {

    private Collection<Cliente> clientes;
    
    public ClienteCollection() {
    }

    public ClienteCollection(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    @XmlElement(name="cliente")
    @XmlElementWrapper(name="clientes")
    public Collection<Cliente> getClientes() {
        return clientes;
    }

}
