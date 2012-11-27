package service;

import junit.framework.TestCase;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestProductoService extends TestCase{

    // @Resource(type = UserServiceImpl.class)
    // private ServiceDefn service;
	Logger logger = Logger.getLogger(TestProductoService.class);

    @Test
    public void testGetProductos() {
    	/*WebClient wc = WebClient.create("http://localhost:8080/cxf-rest/rs/user-service");
    	wc.accept("application/json");
    	Response res = wc.path("/users").get();
    	System.out.println(res.getEntity().toString());*/
    	
    	System.out.println(invokeService("http://localhost:8080/gosus-rest/rs/producto-service/productos"));
    }
    
    @Test
    public void testGetProductosXNombre() {
    	String parametroNombre = "cachorro";
    	System.out.println(invokeService("http://localhost:8080/gosus-rest/rs/producto-service/productosXNombre/"+parametroNombre));
    }
    
    @Test
    public void testGetProductosXRangoFilas() {
    	Integer firstParam = 1;
    	Integer secondParam = 5;
    	System.out.println(invokeService("http://localhost:8080/gosus-rest/rs/producto-service/productos/"+firstParam.toString()+"/"+secondParam.toString()));
    }

    private String invokeService(String targetURL) {
        WebClient webClient = WebClient.create(targetURL);
        webClient.accept("application/json");
        return webClient.get(String.class);
    }
}
