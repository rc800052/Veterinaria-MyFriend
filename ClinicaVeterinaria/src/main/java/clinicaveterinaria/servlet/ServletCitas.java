package clinicaveterinaria.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clinicaveterinaria.citas.source.CitaService;
import clinicaveterinaria.dao.CitaDAO;
import clinicaveterinaria.dao.Citas;
import clinicaveterinaria.excepcion.DAOExcepcion;
import clinicaveterinaria.modelo.BeanCitas;
import clinicaveterinaria.modelo.Cita;
import clinicaveterinaria.modelo.Doctor;
import clinicaveterinaria.negocio.CitasImpl;

import java.text.DateFormat;

import java.text.ParseException;


@WebServlet("/ServletCitas")
public class ServletCitas extends HttpServlet {

	public void service(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		  String dAccion = request.getParameter("txh_Accion");
	    
	 // request.setAttribute("daccion",dAccion);
	  
	  
	  System.out.println(" Accion " +dAccion);
	  
	  /**-----------------------------------------------------**/
	   	if (dAccion.equals("buscar")){
			buscar(request, response);
			}	
	   	/**-----------------------------------------------------**/
	   	if (dAccion.equals("insertar")){
	   		insertar(request, response);
			}
	   	
		/**-----------------------------------------------------**/
//	   	if (dAccion.equals("insertar")){
//			Insertar_Parrafo(request, response);
//			}
//		//------------------------------------------------------
//
//	   	if (dAccion.equals("actualizar")){
//			Actualizar_Parrafo(request, response);
//			}	
		/**-----------------------------------------------------**/
	   	
		
	  
	  	  
}

	
	
		

	private void insertar(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("comienza la ejecucion del metodo actualizacion");
      
		CitasImpl cita = new CitasImpl();
		BeanCitas vo = new BeanCitas();
		
	    try {
		    // Captura los parametros que llegan de la Web.		 
	    	
	    	String codcliente = request.getParameter("txt_codcliente").trim();
			String codpaciente = request.getParameter("txt_codpaciente").trim();
			String coddoctor = request.getParameter("cbo_doctor").trim();
			
			String descripcion = request.getParameter("txt_Descripcion").trim();
			String telefono = request.getParameter("txt_Telefono").trim();
			String direccion = request.getParameter("txt_Direccion").trim();
			String fecha = request.getParameter("txt_Fecha").trim();			
			
			vo.setIdCliente(Integer.parseInt(codcliente));
	    	vo.setIdPaciente(Integer.parseInt(codpaciente));
			vo.setIdDoctor(Integer.parseInt(coddoctor));
	    	
	    	vo.setDescripcion(descripcion);
			vo.setTelefono(telefono);
			vo.setDireccion(direccion);
	    	vo.setFecha(fecha);	    	
	    	vo.setEstado("P");
	    	
	    	vo = cita.insertarcita(vo);
	    	
	    	//SE ENVIA A LA COLA
	    	CitaService citaService = new CitaService();
	    	citaService.sendCita(vo);	    	
	    	
	    	RequestDispatcher rd = request.getRequestDispatcher("frm_citas.jsp");
			rd.forward(request, response);
			 	
	    	
	    	System.out.println("redireccionando al JSP ");		
			
		}catch(Exception e){
		    System.out.println("Hubo error **************************" + e.getMessage());
			e.printStackTrace();
			
	    }
 	
		
	}



	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 CitasImpl ocitas = new CitasImpl();
		
		  try {
			    // Captura los parametros que llegan de la Web.
			  HttpSession session = request.getSession();
			  
		    	String cod1;
		    	cod1 = request.getParameter("txt_Codigo");
		    	
		    	int cod;
		    	cod=Integer.parseInt(cod1);
				
				Collection listaPacientes=ocitas.obtenerFullpacientes(cod);
				int nroFilas = listaPacientes.size();
				
				request.setAttribute("listaPacientes",listaPacientes);
				request.setAttribute("cod1",cod1);
				
				 System.out.println("llego al <<<<<<<<<<  "+nroFilas);
				
				 RequestDispatcher rd = request.getRequestDispatcher("frm_citas.jsp");
					rd.forward(request, response);
				 
				//getServletContext().getRequestDispatcher("/main/webapp/frm_citas.jsp").forward(request,response);
			}catch(Exception e){
			    System.out.println("Hubo error **************************" + e.getMessage());
				e.printStackTrace();
				
		    }
		  
		  
		  
		  
		 
	   	
		
	}

//	private void Actualizar_Parrafo(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("comienza la ejecucion del metodo actualizacion");
//        
//        DAOFactory objDAOFactory=DAOFactory.getDAOFactory(DAOFactory.ORACLE);
//        ParrafoDAO objParrafoDAO =objDAOFactory.getParrafoDAO() ;
//        BeanParrafo objBeanParrafo = new BeanParrafo();
//		
//	    try {
//		    // Captura los parametros que llegan de la Web.
//		    
//	    	String CPARRAF_COD;
//			String VPARRAF_DET;
//			String CPARRAF_ID_DICT_RESOL;
//			String CPARRAF_ESTADO;					
//	    	
//			
//			CPARRAF_COD  = request.getParameter("txt_Codigo").trim();
//			VPARRAF_DET  = request.getParameter("txt_Descripcion").trim();
//			CPARRAF_ID_DICT_RESOL  = request.getParameter("txt_Identificacion").trim();
//			CPARRAF_ESTADO  = request.getParameter("txt_Estado").trim();
//			
//			System.out.println("parametros"+CPARRAF_COD);
//			System.out.println("parametros"+VPARRAF_DET);
//			System.out.println("parametros"+CPARRAF_ID_DICT_RESOL);
//			
//			objBeanParrafo.setCPARRAF_COD(CPARRAF_COD);
//			objBeanParrafo.setVPARRAF_DET(VPARRAF_DET);
//			objBeanParrafo.setCPARRAF_ID_DICT_RESOL(CPARRAF_ID_DICT_RESOL);
//			objBeanParrafo.setCPARRAF_ESTADO(CPARRAF_ESTADO);
//			
//			
//				
//			
//						
//			objParrafoDAO.actualizarParrafo(objBeanParrafo);	
//			
//			getServletContext().getRequestDispatcher("/ListaParrafo").forward(request, response);
//	    	
//	    	
//	    	System.out.println("redireccionando al JSP ");
//
//			
//			
//		}catch(Exception e){
//		    System.out.println("Hubo error **************************" + e.getMessage());
//			e.printStackTrace();
//			
//	    }
//   	
//		
//	}
//
//	private void Insertar_Parrafo(HttpServletRequest request, HttpServletResponse response) {

//		
//		DAOFactory objDAOFactory=DAOFactory.getDAOFactory(DAOFactory.ORACLE);
//        ParrafoDAO objParrafoDAO =objDAOFactory.getParrafoDAO() ;
//        BeanParrafo objBeanParrafo = new BeanParrafo();
//		
//        String MENSAJE ="";
//	    
//	    
//	    
//		try{
//
//			System.out.println("llegoservletparentesco++++++++++++++++++++++++++++++++");
//			//////////////
//			String CPARRAF_COD;
//			String VPARRAF_DET;
//			String CPARRAF_ID_DICT_RESOL;
//			String CPARRAF_ESTADO;		
//			
//			CPARRAF_COD  = request.getParameter("txt_Codigo").toUpperCase().trim();
//			VPARRAF_DET  = request.getParameter("txt_Descripcion").toUpperCase().trim();
//			CPARRAF_ID_DICT_RESOL  = request.getParameter("txt_Identificacion").toUpperCase().trim();
//			CPARRAF_ESTADO  = request.getParameter("txt_Estado").toUpperCase().trim();
//			
//			System.out.println("parametros"+"txt_codigo");
//			System.out.println("parametros"+"txt_descripcion");
//				Collection Parrafo=objParrafoDAO.obtenerFullParrafo();								
//				
//				objBeanParrafo.setCPARRAF_COD(CPARRAF_COD);
//				objBeanParrafo.setVPARRAF_DET(VPARRAF_DET);	
//				objBeanParrafo.setCPARRAF_ID_DICT_RESOL(CPARRAF_ID_DICT_RESOL);	
//				objBeanParrafo.setCPARRAF_ESTADO(CPARRAF_ESTADO);	
//								
//				
//				if (objParrafoDAO.existeElemento(Parrafo,objBeanParrafo)== false ){
//					objParrafoDAO.insertarParrafo(objBeanParrafo);
//					
//					HttpSession session = request.getSession(true);
//					MENSAJE ="elemento insertado";
//					session.setAttribute("mensajero",MENSAJE );
//					getServletContext().getRequestDispatcher("/ListaParrafo").forward(request, response);
//					}
//				else {
//					HttpSession session = request.getSession(true);
//					System.out.println("elemento ya existe");
//					MENSAJE ="elemento ya existe";
//					session.setAttribute("mensajero",MENSAJE);
//					getServletContext().getRequestDispatcher("/ListaParrafo").forward(request, response);
//					
//			    	
//			    	
//					
//				}
//			
//			}catch(Exception e){
//			    System.out.println("Hubo error **************************" + e.getMessage());
//				e.printStackTrace();
//				
//		    
//						}
//
//	}
}